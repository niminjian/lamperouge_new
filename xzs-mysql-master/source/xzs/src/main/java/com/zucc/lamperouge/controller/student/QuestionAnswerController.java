package com.zucc.lamperouge.controller.student;

import com.zucc.lamperouge.base.BaseApiController;
import com.zucc.lamperouge.base.RestResponse;
import com.zucc.lamperouge.domain.ExamPaperQuestionCustomerAnswer;
import com.zucc.lamperouge.domain.Subject;
import com.zucc.lamperouge.domain.TextContent;
import com.zucc.lamperouge.domain.question.QuestionObject;
import com.zucc.lamperouge.service.ExamPaperQuestionCustomerAnswerService;
import com.zucc.lamperouge.service.QuestionService;
import com.zucc.lamperouge.service.SubjectService;
import com.zucc.lamperouge.service.TextContentService;
import com.zucc.lamperouge.utility.DateTimeUtil;
import com.zucc.lamperouge.utility.HtmlUtil;
import com.zucc.lamperouge.utility.JsonUtil;
import com.zucc.lamperouge.utility.PageInfoHelper;
import com.zucc.lamperouge.viewmodel.admin.question.QuestionEditRequestVM;
import com.zucc.lamperouge.viewmodel.student.exam.ExamPaperSubmitItemVM;
import com.zucc.lamperouge.viewmodel.student.question.answer.QuestionAnswerVM;
import com.zucc.lamperouge.viewmodel.student.question.answer.QuestionPageStudentRequestVM;
import com.zucc.lamperouge.viewmodel.student.question.answer.QuestionPageStudentResponseVM;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("StudentQuestionAnswerController")
@RequestMapping(value = "/api/student/question/answer")
public class QuestionAnswerController extends BaseApiController {

    private final ExamPaperQuestionCustomerAnswerService examPaperQuestionCustomerAnswerService;
    private final QuestionService questionService;
    private final TextContentService textContentService;
    private final SubjectService subjectService;

    @Autowired
    public QuestionAnswerController(ExamPaperQuestionCustomerAnswerService examPaperQuestionCustomerAnswerService, QuestionService questionService, TextContentService textContentService, SubjectService subjectService) {
        this.examPaperQuestionCustomerAnswerService = examPaperQuestionCustomerAnswerService;
        this.questionService = questionService;
        this.textContentService = textContentService;
        this.subjectService = subjectService;
    }

    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public RestResponse<PageInfo<QuestionPageStudentResponseVM>> pageList(@RequestBody QuestionPageStudentRequestVM model) {
        model.setCreateUser(getCurrentUser().getId());
        PageInfo<ExamPaperQuestionCustomerAnswer> pageInfo = examPaperQuestionCustomerAnswerService.studentPage(model);
        PageInfo<QuestionPageStudentResponseVM> page = PageInfoHelper.copyMap(pageInfo, q -> {
            Subject subject = subjectService.selectById(q.getSubjectId());
            QuestionPageStudentResponseVM vm = modelMapper.map(q, QuestionPageStudentResponseVM.class);
            vm.setCreateTime(DateTimeUtil.dateFormat(q.getCreateTime()));
            TextContent textContent = textContentService.selectById(q.getQuestionTextContentId());
            QuestionObject questionObject = JsonUtil.toJsonObject(textContent.getContent(), QuestionObject.class);
            String clearHtml = HtmlUtil.clear(questionObject.getTitleContent());
            vm.setShortTitle(clearHtml);
            vm.setSubjectName(subject.getName());
            return vm;
        });
        return RestResponse.ok(page);
    }


    @RequestMapping(value = "/select/{id}", method = RequestMethod.POST)
    public RestResponse<QuestionAnswerVM> select(@PathVariable Integer id) {
        QuestionAnswerVM vm = new QuestionAnswerVM();
        ExamPaperQuestionCustomerAnswer examPaperQuestionCustomerAnswer = examPaperQuestionCustomerAnswerService.selectById(id);
        ExamPaperSubmitItemVM questionAnswerVM = examPaperQuestionCustomerAnswerService.examPaperQuestionCustomerAnswerToVM(examPaperQuestionCustomerAnswer);
        QuestionEditRequestVM questionVM = questionService.getQuestionEditRequestVM(examPaperQuestionCustomerAnswer.getQuestionId());
        vm.setQuestionVM(questionVM);
        vm.setQuestionAnswerVM(questionAnswerVM);
        return RestResponse.ok(vm);
    }

}
