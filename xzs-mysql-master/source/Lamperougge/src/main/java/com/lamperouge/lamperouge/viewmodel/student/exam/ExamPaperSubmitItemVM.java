package com.lamperouge.lamperouge.viewmodel.student.exam;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author nmj
 * @create 2022-01-24 18:18
 */
public class ExamPaperSubmitItemVM {

    private Integer id;

    @NotNull
    private Integer questionId;

    private boolean doRight;

    private String content;

    private Integer itemOrder;

    private List<String> contentArray;

    private String score;

    private String questionScore;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public boolean isDoRight() {
        return doRight;
    }

    public void setDoRight(boolean doRight) {
        this.doRight = doRight;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getItemOrder() {
        return itemOrder;
    }

    public void setItemOrder(Integer itemOrder) {
        this.itemOrder = itemOrder;
    }

    public List<String> getContentArray() {
        return contentArray;
    }

    public void setContentArray(List<String> contentArray) {
        this.contentArray = contentArray;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getQuestionScore() {
        return questionScore;
    }

    public void setQuestionScore(String questionScore) {
        this.questionScore = questionScore;
    }
}
