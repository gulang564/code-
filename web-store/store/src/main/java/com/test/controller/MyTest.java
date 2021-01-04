package com.test.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MyTest {
    @RequestMapping("/getdata")
    public Object getdata(){
        Map map=new HashMap();
        map.put("1",123);
        map.put("2",22);
        return map;
    }
}
