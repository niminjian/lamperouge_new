package com.zucc.lamperouge.repository;

import com.zucc.lamperouge.domain.ExamPaperAnswer;
import com.zucc.lamperouge.domain.other.KeyValue;
import com.zucc.lamperouge.viewmodel.admin.paper.ExamPaperAnswerPageRequestVM;
import com.zucc.lamperouge.viewmodel.student.exampaper.ExamPaperAnswerPageVM;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface ExamPaperAnswerMapper extends BaseMapper<ExamPaperAnswer> {

    List<ExamPaperAnswer> studentPage(ExamPaperAnswerPageVM requestVM);

    Integer selectAllCount();

    List<KeyValue> selectCountByDate(@Param("startTime") Date startTime, @Param("endTime") Date endTime);

    ExamPaperAnswer getByPidUid(@Param("pid") Integer paperId, @Param("uid") Integer uid);

    List<ExamPaperAnswer> adminPage(ExamPaperAnswerPageRequestVM requestVM);
}
