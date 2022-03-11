package com.lamperouge.lamperouge.base;

/**
 * @author nmj
 * @create 2022-01-09 18:37
 */
public enum SystemCode {
    /**
     * OK
     */
    OK(1,"成功"),

    /**
     * AccessTokenError
     */
    AccessTokenError(400, "用户登录令牌失效"),
    /**
     * UNAUTHORIZED
     */
    UNAUTHORIZED(401, "用户未登录"),
    /**
     * UNAUTHORIZED
     */
    AuthError(402, "用户名或密码错误"),
    /**
     * InnerError
     */
    InnerError(500, "系统内部错误"),
    /**
     * ParameterValidError
     */
    ParameterValidError(501, "参数验证错误"),

    /**
     * AccessDenied
     */
    AccessDenied(502, "用户没有权限访问");


    /**
     * The code
     */
    int code;
    /**
     * The message
     */
    String message;

    SystemCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * Gets code.
     *
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * Get message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }
}
