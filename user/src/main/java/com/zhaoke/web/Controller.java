package com.zhaoke.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Cereated by keker on 2019/4/25 14:33
 */
@RestController
@RequestMapping("user")
public class Controller {

    @Autowired
    Service service;

    @PostMapping(value = "test")
    public String test(@RequestParam("name") String name, @RequestParam("age") String age) {

        return service.echo(name, age);
    }
}
