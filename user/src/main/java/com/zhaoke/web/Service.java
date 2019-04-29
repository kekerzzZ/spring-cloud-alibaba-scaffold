package com.zhaoke.web;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Cereated by keker on 2019/4/25 14:33
 */
@Component
@FeignClient(value = "service-system", fallback = ServiceFallBack.class, configuration = Config.class)
public interface Service {

    @PostMapping(value = "/system/echo")
    String echo(@RequestParam("name") String name, @RequestParam("age") String age);

}
