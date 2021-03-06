package com.mq;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Sender{

    @Autowired
    RedisMq redisMq;

    //在redis中存储消息
    @GetMapping("/push")
    public Object pushMsg(@RequestParam("msg")String msg){
        redisMq.push(msg);
        return "SUCCESS";
    }

    //从redis中获取消息
    @GetMapping("/pop")
    public Object popMsg(){
        return redisMq.pop();
    }

}
