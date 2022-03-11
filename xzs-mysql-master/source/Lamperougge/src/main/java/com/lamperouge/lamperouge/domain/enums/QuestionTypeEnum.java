package com.lamperouge.lamperouge.domain.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @author nmj
 * @create 2022-01-24 16:17
 */
public enum  QuestionTypeEnum {
    SingleChoice(1, "单选题"),
    MultipleChoice(2, "多选题"),
    TrueFalse(3, "判断题"),
    GapFilling(4, "填空题"),
    ShortAnswer(5, "简答题");

    int code;
    String name;

    QuestionTypeEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    private static final Map<Integer, QuestionTypeEnum> keyMap = new HashMap<>();

    static {
        // value()方法可以将枚举类转变为一个枚举类型的数组
        for (QuestionTypeEnum item : QuestionTypeEnum.values()){
            keyMap.put(item.getCode(), item);
        }
    }

    public static QuestionTypeEnum fromCode(Integer code) {
        return keyMap.get(code);
    }

    // 判断哪些题型需要保存文本内容
    public static boolean needSaveTextContent(Integer code) {
        QuestionTypeEnum questionTypeEnum = QuestionTypeEnum.fromCode(code);
        switch (questionTypeEnum) {
            case GapFilling:
            case ShortAnswer:
                return true;
            default:
                return false;
        }
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
}
