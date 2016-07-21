package com.alone.common.enums;

import com.alone.common.dto.BasicEnum;
import lombok.Getter;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 16-7-22 上午12:07
 */
public enum RequireAppType implements BasicEnum {
    APK(1, "APK"),
    BIN(2, "BIN"),
    SHELL(3,  "SHELL"),
    CONFIG(4, "配置文件"),
    OTHER(5, "其他");

    @Getter
    private int val;

    @Getter
    private String name;

    RequireAppType(int val, String name) {
        this.val = val;
        this.name = name;
    }
}
