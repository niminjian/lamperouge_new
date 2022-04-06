package com.zucc.lamperouge.listener;

import com.zucc.lamperouge.domain.enums.ExamPaperTypeEnum;
import com.zucc.lamperouge.domain.enums.QuestionTypeEnum;
import com.zucc.lamperouge.event.CalculateExamPaperAnswerCompleteEvent;
import com.zucc.lamperouge.service.ExamPaperAnswerService;
import com.zucc.lamperouge.service.ExamPaperQuestionCustomerAnswerService;
import com.zucc.lamperouge.service.TaskExamCustomerAnswerService;
import com.zucc.lamperouge.service.TextContentService;
import com.zucc.lamperouge.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


@Component
public class CalculateExamPaperAnswerListener implements ApplicationListener<CalculateExamPaperAnswerCompleteEvent> {

    private final ExamPaperAnswerService examPaperAnswerService;
    private final ExamPaperQuestionCustomerAnswerService examPaperQuestionCustomerAnswerService;
    private final TextContentService textContentService;
    private final TaskExamCustomerAnswerService examCustomerAnswerService;

    @Autowired
    public CalculateExamPaperAnswerListener(ExamPaperAnswerService examPaperAnswerService, ExamPaperQuestionCustomerAnswerService examPaperQuestionCustomerAnswerService, TextContentService textContentService, TaskExamCustomerAnswerService examCustomerAnswerService) {
        this.examPaperAnswerService = examPaperAnswerService;
        this.examPaperQuestionCustomerAnswerService = examPaperQuestionCustomerAnswerService;
        this.textContentService = textContentService;
        this.examCustomerAnswerService = examCustomerAnswerService;
    }

    @Override
    @Transactional
    public void onApplicationEvent(CalculateExamPaperAnswerCompleteEvent calculateExamPaperAnswerCompleteEvent) {
        Date now = new Date();

        ExamPaperAnswerInfo examPaperAnswerInfo = (ExamPaperAnswerInfo) calculateExamPaperAnswerCompleteEvent.getSource();
        ExamPaper examPaper = examPaperAnswerInfo.getExamPaper();
        ExamPaperAnswer examPaperAnswer = examPaperAnswerInfo.getExamPaperAnswer();
        List<ExamPaperQuestionCustomerAnswer> examPaperQuestionCustomerAnswers = examPaperAnswerInfo.getExamPaperQuestionCustomerAnswers();

        examPaperAnswerService.insertByFilter(examPaperAnswer);
        examPaperQuestionCustomerAnswers.stream().filter(a -> QuestionTypeEnum.needSaveTextContent(a.getQuestionType())).forEach(d -> {
            TextContent textContent = new TextContent(d.getAnswer(), now);
            textContentService.insertByFilter(textContent);
            d.setTextContentId(textContent.getId());
            d.setAnswer(null);
        });
        examPaperQuestionCustomerAnswers.forEach(d -> {
            d.setExamPaperAnswerId(examPaperAnswer.getId());
        });
        examPaperQuestionCustomerAnswerService.insertList(examPaperQuestionCustomerAnswers);

        switch (ExamPaperTypeEnum.fromCode(examPaper.getPaperType())) {
            case Task: {
                examCustomerAnswerService.insertOrUpdate(examPaper, examPaperAnswer, now);
                break;
            }
            default:
                break;
        }
    }
}
