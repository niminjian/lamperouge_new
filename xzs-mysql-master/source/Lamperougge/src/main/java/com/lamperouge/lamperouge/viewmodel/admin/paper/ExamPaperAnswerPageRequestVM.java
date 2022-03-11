package com.lamperouge.lamperouge.viewmodel.admin.paper;

import com.lamperouge.lamperouge.base.BasePage;

/**
 * @author nmj
 * @create 2022-01-24 18:12
 */
public class ExamPaperAnswerPageRequestVM extends BasePage {

    private Integer subjectId;

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }
}
