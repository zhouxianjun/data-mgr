package com.alone.core;

import com.alone.common.AppContext;

import java.util.concurrent.locks.LockSupport;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 2016/7/8 12:44
 */
public class Server {
    public static void main(String[] args) {
        new AppContext(new String[]{"spring*.xml"});
        //阻塞防止停止
        LockSupport.park();
    }
}
