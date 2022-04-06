package com.zucc.lamperouge.service;

import com.zucc.lamperouge.domain.TaskExam;
import com.zucc.lamperouge.domain.User;
import com.zucc.lamperouge.viewmodel.admin.task.TaskPageRequestVM;
import com.zucc.lamperouge.viewmodel.admin.task.TaskRequestVM;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface TaskExamService extends BaseService<TaskExam> {

    PageInfo<TaskExam> page(TaskPageRequestVM requestVM);

    void edit(TaskRequestVM model, User user);

    TaskRequestVM taskExamToVM(Integer id);

    List<TaskExam> getByGradeLevel(Integer gradeLevel);
}
