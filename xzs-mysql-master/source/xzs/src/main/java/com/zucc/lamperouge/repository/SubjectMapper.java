package com.zucc.lamperouge.repository;

import com.zucc.lamperouge.domain.Subject;
import com.zucc.lamperouge.viewmodel.admin.education.SubjectPageRequestVM;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SubjectMapper  extends BaseMapper<Subject> {

    List<Subject> getSubjectByLevel(Integer level);

    List<Subject> allSubject();

    List<Subject> page(SubjectPageRequestVM requestVM);
}