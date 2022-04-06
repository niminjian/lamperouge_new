package com.zucc.lamperouge.repository;


import com.zucc.lamperouge.domain.UserFaceInfo;
import com.zucc.lamperouge.dto.FaceUserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface MybatisUserFaceInfoMapper {

    List<UserFaceInfo> findUserFaceInfoList();

    void insertUserFaceInfo(UserFaceInfo userFaceInfo);

    List<FaceUserInfo> getUserFaceInfoByGroupId(Integer groupId);

}
