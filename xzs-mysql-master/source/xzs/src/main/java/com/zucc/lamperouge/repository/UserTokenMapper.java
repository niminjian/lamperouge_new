package com.zucc.lamperouge.repository;

import com.zucc.lamperouge.domain.UserToken;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserTokenMapper extends BaseMapper<UserToken> {
    UserToken getToken(String token);
}
