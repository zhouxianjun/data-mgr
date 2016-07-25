package com.alone.common.enums;

import com.alone.common.dto.BasicEnum;
import lombok.Getter;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 16-7-22 上午12:07
 */
public enum RefType implements BasicEnum {
    BOX(1, "盒子"),
    APP_PACKAGE(2, "应用包"),
    REQUIRE_PACKAGE(3,  "必刷包"),
    WHITE(4, "白名单"),
    ACTIVE(5, "策略");

    @Getter
    private int val;

    @Getter
    private String name;

    RefType(int val, String name) {
        this.val = val;
        this.name = name;
    }
}
