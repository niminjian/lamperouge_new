package com.lamperouge.lamperouge.domain.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @author nmj
 * @create 2022-01-16 18:55
 */
public enum RoleEnum {

    STUDENT(1, "STUDENT"),
    ADMIN(3, "ADMIN");


    int code;
    String name;

    RoleEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    private static final Map<Integer, RoleEnum> keyMap = new HashMap<>();

    static {
        for (RoleEnum item : RoleEnum.values()) {
            keyMap.put(item.getCode(), item);
        }
    }

    public static RoleEnum fromCode(Integer code) {
        return keyMap.get(code);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoleName() {
        return "ROLE_" + name;
    }
}
