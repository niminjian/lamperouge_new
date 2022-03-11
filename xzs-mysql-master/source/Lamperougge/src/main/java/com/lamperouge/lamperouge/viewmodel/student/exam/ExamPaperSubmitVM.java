package com.lamperouge.lamperouge.viewmodel.student.exam;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author nmj
 * @create 2022-01-24 18:07
 */
public class ExamPaperSubmitVM {

    @NotNull
    private Integer id;

    @NotNull
    private Integer doTime;

    private String score;

    @NotNull
    @Valid
    private List<ExamPaperSubmitVM> answerItems;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDoTime() {
        return doTime;
    }

    public void setDoTime(Integer doTime) {
        this.doTime = doTime;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public List<ExamPaperSubmitVM> getAnswerItems() {
        return answerItems;
    }

    public void setAnswerItems(List<ExamPaperSubmitVM> answerItems) {
        this.answerItems = answerItems;
    }
}
