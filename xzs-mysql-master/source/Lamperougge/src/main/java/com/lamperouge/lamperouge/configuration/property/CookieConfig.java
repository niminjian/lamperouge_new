package com.lamperouge.lamperouge.configuration.property;

/**
 * @author nmj
 * @create 2022-01-16 15:39
 */
public class CookieConfig {

    public static String getName() {
        return "lamperouge";
    }

    // 猜测是周期性获取cookie的时间
    public static Integer getInterval() {
        return 30 * 24 * 60 * 60;
    }
}
