package com.lamperouge.lamperouge.viewmodel.admin.exam;

import com.lamperouge.lamperouge.viewmodel.admin.question.QuestionEditRequestVM;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author nmj
 * @create 2022-01-24 15:46
 */
public class ExamPaperTitleItemVM {

    @NotBlank(message = "标题内容不能为空")
    private String name;

    // @Size(max,min)  被注释的元素的大小必须在指定的范围内。
    @Size(min = 1, message = "请添加题目")
    @Valid
    private List<QuestionEditRequestVM> questionItems;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<QuestionEditRequestVM> getQuestionItems() {
        return questionItems;
    }

    public void setQuestionItems(List<QuestionEditRequestVM> questionItems) {
        this.questionItems = questionItems;
    }
}
