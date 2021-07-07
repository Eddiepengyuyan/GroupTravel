package com.zzh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("activity1");
        return "index";
    }
}
//    @RequestMapping("/index")
//    public String html(@PathVariable("index")String view){
//        return view;
//    }

