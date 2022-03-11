package com.lamperouge.lamperouge.configuration.spring.security;

import com.lamperouge.lamperouge.base.RestResponse;
import com.lamperouge.lamperouge.base.SystemCode;
import com.lamperouge.lamperouge.utility.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author nmj
 * @create 2022-01-09 18:32
 */
public class RestUtil {
    //使用指定类初始化日志对象
    private static final Logger logger = LoggerFactory.getLogger(RestUtil.class);


    public static void response(HttpServletResponse response, SystemCode systemCode) {
        response(response, systemCode.getCode(), systemCode.getMessage());
    }

    public static void response(HttpServletResponse response, int systemCode, String msg){
        response(response, systemCode, msg, null);
    }

    // 这里的content是传入到构造器的response中，这个参数支持泛型，因此可以直接传入Object
    // 有很多response函数，最终是通过这个进行处理
    // 猜测是往response中写入内容，没太明白
    public static void response(HttpServletResponse response, int systemCode, String msg, Object content){
        try {
            RestResponse res = new RestResponse<>(systemCode, msg, content);
            String resStr = JsonUtil.toJsonStr(res);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(resStr);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }
}
