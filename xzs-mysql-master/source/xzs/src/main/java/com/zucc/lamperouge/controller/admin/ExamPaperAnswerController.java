package com.zucc.lamperouge.controller.admin;

import com.zucc.lamperouge.base.BaseApiController;
import com.zucc.lamperouge.base.RestResponse;
import com.zucc.lamperouge.domain.ExamPaperAnswer;
import com.zucc.lamperouge.domain.Subject;
import com.zucc.lamperouge.domain.User;
import com.zucc.lamperouge.utility.DateTimeUtil;
import com.zucc.lamperouge.utility.ExamUtil;
import com.zucc.lamperouge.utility.PageInfoHelper;
import com.zucc.lamperouge.viewmodel.student.exampaper.ExamPaperAnswerPageResponseVM;
import com.zucc.lamperouge.viewmodel.admin.paper.ExamPaperAnswerPageRequestVM;
import com.github.pagehelper.PageInfo;
import com.zucc.lamperouge.service.ExamPaperAnswerService;
import com.zucc.lamperouge.service.SubjectService;
import com.zucc.lamperouge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("AdminExamPaperAnswerController")
@RequestMapping(value = "/api/admin/examPaperAnswer")
public class ExamPaperAnswerController extends BaseApiController {

    private final ExamPaperAnswerService examPaperAnswerService;
    private final SubjectService subjectService;
    private final UserService userService;

    @Autowired
    public ExamPaperAnswerController(ExamPaperAnswerService examPaperAnswerService, SubjectService subjectService, UserService userService) {
        this.examPaperAnswerService = examPaperAnswerService;
        this.subjectService = subjectService;
        this.userService = userService;
    }


    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public RestResponse<PageInfo<ExamPaperAnswerPageResponseVM>> pageJudgeList(@RequestBody ExamPaperAnswerPageRequestVM model) {
        PageInfo<ExamPaperAnswer> pageInfo = examPaperAnswerService.adminPage(model);
        PageInfo<ExamPaperAnswerPageResponseVM> page = PageInfoHelper.copyMap(pageInfo, e -> {
            ExamPaperAnswerPageResponseVM vm = modelMapper.map(e, ExamPaperAnswerPageResponseVM.class);
            Subject subject = subjectService.selectById(vm.getSubjectId());
            vm.setDoTime(ExamUtil.secondToVM(e.getDoTime()));
            vm.setSystemScore(ExamUtil.scoreToVM(e.getSystemScore()));
            vm.setUserScore(ExamUtil.scoreToVM(e.getUserScore()));
            vm.setPaperScore(ExamUtil.scoreToVM(e.getPaperScore()));
            vm.setSubjectName(subject.getName());
            vm.setCreateTime(DateTimeUtil.dateFormat(e.getCreateTime()));
            User user = userService.selectById(e.getCreateUser());
            vm.setUserName(user.getUserName());
            return vm;
        });
        return RestResponse.ok(page);
    }


}
