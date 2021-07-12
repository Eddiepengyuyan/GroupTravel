package com.zzh.controller;

import com.zzh.service.MailService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class EmailController {
    @Resource
    private MailService mailService;

    @RequestMapping("/Email")
    public String findAll(Model model,HttpServletRequest req,HttpSession session){
        mailService.sendSimpleMail("1783276979@qq.com","测试spring boot imail-主题","测试spring boot imail - 内容");
        return "Email";
    }
}
