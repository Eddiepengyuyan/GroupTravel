package com.zzh.controller;

import com.zzh.domain.Activities;
import com.zzh.domain.User;
import com.zzh.serviceImpl.ActivitiesService;
import com.zzh.serviceImpl.MailService;
import com.zzh.serviceImpl.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class EmailController {
    @Resource
    private MailService mailService;
    @Resource
    private ActivitiesService activitiesService;
    @Resource
    private UserService userService;


    @RequestMapping("/EmailSetUp")
    public String sendEmailSetUp(Model model, HttpServletRequest req, HttpSession session,
                          @RequestParam("actId")int actId){
        Activities thisAct = activitiesService.findActById(actId);
        List<Integer> uids = userService.findIdByActid(actId);
        List<User> users = userService.findByids(uids);
        for (User user:users){
            String userEmail = user.getNumber();
            mailService.sendSimpleMail(userEmail," HuiFenWEB 系统通知","活动已成立，请前往网站查看详细信息。");
        }
        return "Email";
    }

    @RequestMapping("/EmailEnd")
    public String sendEmailEnd(Model model, HttpServletRequest req, HttpSession session,
                          @RequestParam("actId")int actId,
                               @RequestParam("teamId")int teamId){
        Activities thisAct = activitiesService.findActById(actId);
        List<Integer> uids = userService.findIdByActid(actId);
        List<User> users = userService.findByids(uids);
        for (User user:users){
            String userEmail = user.getNumber();
            mailService.sendSimpleMail(userEmail," HuiFenWEB 系统通知","活动已结束，请前往网站查看详细信息。");
        }
        model.addAttribute("teamId",teamId);
        return "EmailEnd";
    }
}
