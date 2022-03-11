package com.lamperouge.lamperouge.viewmodel.student.exam;

import com.lamperouge.lamperouge.base.BasePage;

import javax.validation.constraints.NotNull;

/**
 * @author nmj
 * @create 2022-01-24 15:29
 */
public class ExamPaperPageVM extends BasePage {

    @NotNull
    private Integer paperType;
    private Integer subjectId;
    private Integer levelId;

    public Integer getPaperType() {
        return paperType;
    }

    public void setPaperType(Integer paperType) {
        this.paperType = paperType;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Integer getLevelId() {
        return levelId;
    }

    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }
}
