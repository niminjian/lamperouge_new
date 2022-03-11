package com.lamperouge.lamperouge.service;

import com.github.pagehelper.PageInfo;
import com.lamperouge.lamperouge.domain.ExamPaper;
import com.lamperouge.lamperouge.domain.User;
import com.lamperouge.lamperouge.viewmodel.admin.exam.ExamPaperEditRequestVM;
import com.lamperouge.lamperouge.viewmodel.admin.exam.ExamPaperPageRequestVM;
import com.lamperouge.lamperouge.viewmodel.student.dashboard.PaperFilter;
import com.lamperouge.lamperouge.viewmodel.student.exam.ExamPaperPageVM;

import java.util.List;

/**
 * @author nmj
 * @create 2022-01-24 15:01
 */
public interface ExamPaperService extends BaseService<ExamPaper> {

    PageInfo<ExamPaper> page(ExamPaperPageRequestVM requestVM);

    PageInfo<ExamPaper> taskExamPaper(ExamPaperPageRequestVM requestVM);

    PageInfo<ExamPaper> studentPage(ExamPaperPageVM requestVM);

    ExamPaper savePaperFromVM(ExamPaperEditRequestVM examPaperEditRequestVM, User user);

    ExamPaperEditRequestVM examPaperToVM(Integer id);

    List<PageInfo> indexPaper(PaperFilter paperFilter);

    Integer selectAllCount();

    List<Integer> selectMothCount();
}
