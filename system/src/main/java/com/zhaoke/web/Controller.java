package com.zhaoke.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Cereated by keker on 2019/4/25 13:50
 */
@RestController
@RequestMapping("system")
public class Controller {

    @PostMapping(value = "/echo")
    public String echo(String name, String age) {
        /*try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return "system0(系统0) Hello " + name + " age " + age;
    }

}
