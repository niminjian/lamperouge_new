package com.lamperouge.lamperouge.viewmodel.admin.question;

import org.hibernate.validator.constraints.Range;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author nmj
 * @create 2022-01-24 15:48
 */
public class QuestionEditRequestVM {

    private Integer id;

    @NotNull
    private Integer questionType;

    @NotNull
    private Integer subjectId;

    @NotBlank
    private String title;

    private Integer gradeLevel;

    @Valid
    private List<QuestionEditItemVM> items;

    @NotBlank
    private String analyze;

    private List<String> correctArray;

    private String correct;

    @NotBlank
    private String score;

    // @Range  被注释的元素必须在合适的范围内
    @Range(min = 1, max = 5, message = "请选择题目难度")
    private Integer difficult;
}
