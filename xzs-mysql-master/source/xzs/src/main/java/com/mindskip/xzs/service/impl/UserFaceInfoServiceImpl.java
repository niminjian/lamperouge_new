package com.mindskip.xzs.service.impl;

import com.mindskip.xzs.domain.UserFaceInfo;
import com.mindskip.xzs.repository.MybatisUserFaceInfoMapper;
import com.mindskip.xzs.service.UserFaceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserFaceInfoServiceImpl implements UserFaceInfoService {


    @Autowired
    private MybatisUserFaceInfoMapper userFaceInfoMapper;

    @Override
    public void insertSelective(UserFaceInfo userFaceInfo) {
        userFaceInfoMapper.insertUserFaceInfo(userFaceInfo);
    }
}
