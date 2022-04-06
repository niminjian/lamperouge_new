package com.zucc.lamperouge.viewmodel.admin.task;

import com.zucc.lamperouge.base.BasePage;


public class TaskPageRequestVM extends BasePage {
    private Integer gradeLevel;

    public Integer getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(Integer gradeLevel) {
        this.gradeLevel = gradeLevel;
    }
}
