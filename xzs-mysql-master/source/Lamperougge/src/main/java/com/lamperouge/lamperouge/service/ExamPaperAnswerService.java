package com.lamperouge.lamperouge.service;

import com.github.pagehelper.PageInfo;
import com.lamperouge.lamperouge.domain.ExamPaperAnswer;
import com.lamperouge.lamperouge.domain.ExamPaperAnswerInfo;
import com.lamperouge.lamperouge.domain.User;
import com.lamperouge.lamperouge.viewmodel.student.exam.ExamPaperSubmitVM;
import com.lamperouge.lamperouge.viewmodel.student.exampaper.ExamPaperAnswerPageVM;

import java.util.List;

/**
 * @author nmj
 * @create 2022-01-24 16:48
 */
public interface ExamPaperAnswerService extends BaseService<ExamPaperAnswer> {

    /**
     * 学生考试记录分页
     * @param requestVM 过滤条件
     * @return PageInfo<ExamPaperAnswer>
     */
    PageInfo<ExamPaperAnswer> studentPage(ExamPaperAnswerPageVM requestVM);

    /**
     * 计算试卷提交结果(不入库)
     *
     * @param examPaperSubmitVM
     * @param user
     * @return
     */
    ExamPaperAnswerInfo calculateExamPaperAnswer(ExamPaperSubmitVM examPaperSubmitVM, User user);

    /**
     * 试卷批改
     * @param examPaperSubmitVM  examPaperSubmitVM
     * @return String
     */
    String judge(ExamPaperSubmitVM examPaperSubmitVM);

    /**
     * 试卷答题信息转成ViewModel 传给前台
     *
     * @param id 试卷id
     * @return ExamPaperSubmitVM
     */
    ExamPaperSubmitVM examPaperAnswerToVM(Integer id);

    Integer selectAllCount();

    List<Integer> selectMothCount();

    PageInfo<ExamPaperAnswer> adminPage(com.lamperouge.lamperouge.viewmodel.admin.paper.ExamPaperAnswerPageRequestVM requestVM);
}
