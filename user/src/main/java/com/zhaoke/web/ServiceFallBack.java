package com.zhaoke.web;

import org.springframework.stereotype.Component;

/**
 * 降级
 * Cereated by keker on 2019/4/25 14:59
 */
@Component
public class ServiceFallBack implements Service {

    @Override
    public String echo(String string, String age) {
        return "系统升级中";
    }
}
