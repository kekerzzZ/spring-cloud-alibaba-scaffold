package com.zhaoke.web;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 改变负载均衡策略
 * Cereated by keker on 2019/4/25 16:33
 */
@Configuration
public class Config {

    @Bean
    public IRule ribbonRule() {
        return new RoundRobinRule();
    }
}
