package com.th.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tianh on 2018/11/26.
 */
@RestController
public class Hello {

    @Value("${server.port}")
    private Integer port;

    @GetMapping("/hi")
    public String hi(@RequestParam String name) {
        return "hi,"+name+"i'm from port:" + port;
    }
}
