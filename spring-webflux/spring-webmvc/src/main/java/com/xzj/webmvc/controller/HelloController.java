package com.xzj.webmvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by xuzhijun.online on 2019/3/28.
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Welcome to reactive world ~";
    }
}