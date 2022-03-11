package com.lamperouge.lamperouge.service.impl;

import com.lamperouge.lamperouge.configuration.property.SystemConfig;
import com.lamperouge.lamperouge.service.AuthenticationService;
import com.lamperouge.lamperouge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import com.lamperouge.lamperouge.domain.User;
import org.springframework.stereotype.Service;

/**
 * @author nmj
 * @create 2022-01-10 23:11
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserService userService;
    private final SystemConfig systemConfig;

    @Autowired
    public AuthenticationServiceImpl(UserService userService, SystemConfig systemConfig) {
        this.userService = userService;
        this.systemConfig = systemConfig;
    }

    @Override
    public boolean authUser(String username, String password) {
        return false;
    }

    @Override
    public boolean authUser(User user, String username, String password) {
        return false;
    }

    @Override
    public String pwdEncode(String password) {
        return null;
    }

    @Override
    public String pwdDecode(String encodePwd) {
        return null;
    }
}
