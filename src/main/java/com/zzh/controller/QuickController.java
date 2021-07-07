package com.zzh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class QuickController {

    @RequestMapping("/quick")
    @ResponseBody
    public String quick(){
        return "hello world!";
    }

    //打开所有jsp页面
//    @RequestMapping("/index")
//    public String html(@PathVariable("index")String view){
//        return view;
//    }//其中view就是你要打开的视图哦
}
