package com.lamperouge.lamperouge.domain.other;

/**
 * @author nmj
 * @create 2022-01-24 18:24
 */
public class ExamPaperAnswerUpdate {

    private Integer id;
    private Integer customerScore;
    private boolean doRight;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomerScore() {
        return customerScore;
    }

    public void setCustomerScore(Integer customerScore) {
        this.customerScore = customerScore;
    }

    public boolean isDoRight() {
        return doRight;
    }

    public void setDoRight(boolean doRight) {
        this.doRight = doRight;
    }
}
