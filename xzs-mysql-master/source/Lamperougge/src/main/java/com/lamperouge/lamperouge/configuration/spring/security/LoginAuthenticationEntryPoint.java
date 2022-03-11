package com.lamperouge.lamperouge.configuration.spring.security;

import com.lamperouge.lamperouge.base.SystemCode;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author nmj
 * @create 2022-01-09 18:28
 */

//未登录
@Component
public class LoginAuthenticationEntryPoint extends LoginUrlAuthenticationEntryPoint {
    public LoginAuthenticationEntryPoint() {
        super("/api/user/login");   //指向表单登录页面的位置，基于此可以构建到表单登录界面的重定向URL
    }

    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authenticationException) {
        RestUtil.response(response, SystemCode.UNAUTHORIZED);
    }
}
