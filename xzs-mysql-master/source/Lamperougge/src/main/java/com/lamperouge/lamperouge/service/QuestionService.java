package com.lamperouge.lamperouge.service;

import com.github.pagehelper.PageInfo;
import com.lamperouge.lamperouge.domain.Question;
import com.lamperouge.lamperouge.viewmodel.admin.question.QuestionEditRequestVM;
import com.lamperouge.lamperouge.viewmodel.admin.question.QuestionPageRequestVM;

import java.util.List;

/**
 * @author nmj
 * @create 2022-01-24 16:13
 */
public interface QuestionService extends BaseService<Question> {

    PageInfo<Question> page(QuestionPageRequestVM requestVM);

    Question insertFullQuestion(QuestionEditRequestVM model, Integer userId);

    Question updateFullQuestion(QuestionEditRequestVM model);

    QuestionEditRequestVM getQuestionEditRequestVM(Integer questionId);

    QuestionEditRequestVM getQuestionEditRequestVM(Question question);

    Integer selectAllCount();

    List<Integer> selectMothCount();
}
