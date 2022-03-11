package com.lamperouge.lamperouge.base;

/**
 * @author nmj
 * @create 2022-01-09 19:08
 */
public class RestResponse<T> {
    private int code;
    private String message;
    private T response; //使用了泛型，可以存储任何类型的对象；

    /**
     * Instantiates a new Rest response.    初始化一个Rest的返回对象
     *
     * @param code
     * @param message
     */
    public RestResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * Instantiates a new Rest response.
     * @param code
     * @param message
     * @param response
     */
    public RestResponse(int code, String message, T response) {
        this.code = code;
        this.message = message;
        this.response = response;
    }

    /**
     * Fail a rest response.
     * @param code
     * @param msg
     * @return the rest response
     */
    public static RestResponse fail(Integer code, String msg) { //发生错误时需要将状态码和错误信息传入，因为错误有好多种
        return new RestResponse<>(code, msg);
    }

    /**
     * Ok rest response.
     * @return
     */
    public static RestResponse ok() { //状态正常时只有一种状态，就不需要传入信息
        SystemCode systemCode = SystemCode.OK;
        return new RestResponse<>(systemCode.getCode(), systemCode.getMessage());
    }

    /**
     * Ok rest response.
     * @param response the response
     * @param <F> the type parameter
     * @return the rest response
     */
    public static <F> RestResponse<F> ok(F response) {
        SystemCode systemCode = SystemCode.OK;
        return new RestResponse<>(systemCode.getCode(), systemCode.getMessage(), response);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }
}
