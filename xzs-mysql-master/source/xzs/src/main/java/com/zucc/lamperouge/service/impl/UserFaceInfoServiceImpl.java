package com.zucc.lamperouge.service.impl;

import com.zucc.lamperouge.domain.UserFaceInfo;
import com.zucc.lamperouge.repository.MybatisUserFaceInfoMapper;
import com.zucc.lamperouge.service.UserFaceInfoService;
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
