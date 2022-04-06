package com.zucc.lamperouge.service;

import com.zucc.lamperouge.domain.ExamPaper;
import com.zucc.lamperouge.domain.User;
import com.zucc.lamperouge.viewmodel.admin.exam.ExamPaperEditRequestVM;
import com.zucc.lamperouge.viewmodel.admin.exam.ExamPaperPageRequestVM;
import com.zucc.lamperouge.viewmodel.student.dashboard.PaperFilter;
import com.zucc.lamperouge.viewmodel.student.dashboard.PaperInfo;
import com.zucc.lamperouge.viewmodel.student.exam.ExamPaperPageVM;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ExamPaperService extends BaseService<ExamPaper> {

    PageInfo<ExamPaper> page(ExamPaperPageRequestVM requestVM);

    PageInfo<ExamPaper> taskExamPage(ExamPaperPageRequestVM requestVM);

    PageInfo<ExamPaper> studentPage(ExamPaperPageVM requestVM);

    ExamPaper savePaperFromVM(ExamPaperEditRequestVM examPaperEditRequestVM, User user);

    ExamPaperEditRequestVM examPaperToVM(Integer id);

    List<PaperInfo> indexPaper(PaperFilter paperFilter);

    Integer selectAllCount();

    List<Integer> selectMothCount();
}
