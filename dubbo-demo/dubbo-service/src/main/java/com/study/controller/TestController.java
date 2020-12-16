package com.study.controller;

import com.study.service.TestService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    //    @Resource
//    private TestService testServiceImpl;
    @Reference(version = "1.0.0" )
    private TestService testServiceImpl;

    @RequestMapping("/ins")
    public String ins(){
        testServiceImpl.ins();
        System.out.println("------------------ins-----------------------");
        return "ins";
    }

    @RequestMapping("/del")
    public String del(){
        testServiceImpl.del();
        return "del";
    }

    @RequestMapping("/upd")
    public String upd(){
        testServiceImpl.upd();
        return "upd";
    }

    @RequestMapping("/sel")
    public String sel(){
        testServiceImpl.sel();
        return "sel";
    }

    @RequestMapping(value = "/good")
    public String good(){
        return "good";
    }
}