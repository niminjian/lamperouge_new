package com.lamperouge.lamperouge.service;

import com.github.pagehelper.PageInfo;
import com.lamperouge.lamperouge.domain.ExamPaperQuestionCustomerAnswer;
import com.lamperouge.lamperouge.domain.other.ExamPaperAnswerUpdate;
import com.lamperouge.lamperouge.viewmodel.student.exam.ExamPaperSubmitItemVM;
import com.lamperouge.lamperouge.viewmodel.student.exam.ExamPaperSubmitVM;
import com.lamperouge.lamperouge.viewmodel.student.question.answer.QuestionPageStudentRequestVM;

import java.util.List;

/**
 * @author nmj
 * @create 2022-01-24 18:13
 */
public interface ExamPaperQuestionCustomerAnswerService extends BaseService<ExamPaperQuestionCustomerAnswer> {

    PageInfo<ExamPaperQuestionCustomerAnswer> studentPage(QuestionPageStudentRequestVM requestVM);

    List<ExamPaperQuestionCustomerAnswer> selectListByPaperAnswerId(Integer id);

    /**
     * 试卷提交答案入库
     *
     * @param examPaperQuestionCustomerAnswers List<ExamPaperQuestionCustomerAnswer>
     */
    void insertList(List<ExamPaperQuestionCustomerAnswer> examPaperQuestionCustomerAnswers);

    /**
     * 试卷问题答题信息转成ViewModel 传给前台
     *
     * @param qa ExamPaperQuestionCustomerAnswer
     * @return ExamPaperSubmitItemVM
     */
    ExamPaperSubmitItemVM examPaperQuestionCustomerAnswerToVM(ExamPaperQuestionCustomerAnswer qa);

    Integer selectAllCount();

    List<Integer> selectMothCount();

    int updateScore(List<ExamPaperAnswerUpdate> examPaperAnswerUpdates);
}
