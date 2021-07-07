package com.zzh.controller;

import com.zzh.domain.Activities;
import com.zzh.domain.User;
import com.zzh.service.ActivitiesService;
import com.zzh.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController{
    @Resource
    private UserService userService;
    @Resource
    private ActivitiesService activitiesService;

    public void showActivities(Model model){
        List<Activities> activities = activitiesService.findAll();
        model.addAttribute("activities", activities);
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest req,
                         HttpSession session,
                         Model model){
        session = req.getSession();
        session.invalidate();
        showActivities(model);
        return "index";
    }

    @RequestMapping("/skip")
    public String Register(Model model,
                           @RequestParam("username")String username,
                           @RequestParam("password")String password,
                           @RequestParam("realname")String realname,
                           @RequestParam("number")String number
                           ) throws IOException {
//        System.out.println("test  "+username+password);
        userService.insert(username,password,realname,number);
        return "login";
    }
    @RequestMapping("/dologin")
    public String Login(
                        @RequestParam("username")String username,
                        @RequestParam("password")String password,
                        HttpServletRequest request,
                        HttpServletResponse response,
                        HttpSession session,
                        Model model
                        ){
        session = request.getSession();

        User user = userService.findByUsername(username);
        showActivities(model);
//        String nName = user.getUsername();
//        String nPassword = user.getPassword();
//        System.out.println(nName+"  "+nPassword);
        if(user.getUsername().equals(username) && user.getPassword().equals(password)){
            session.setAttribute("user",user);
//            System.out.println("success");
            return "index";
        }
        else{
//            System.out.println("error");
            return "login";
        }
    }

    @RequestMapping("personalCenter")
    public String personalCenter(HttpSession session,
                                 HttpServletRequest req,
                                 HttpServletResponse resp,
                                 Model model){
        //1.将用户信息传入
        session = req.getSession();
        User user = (User)session.getAttribute("thisUser");
        //2.通过用户信息查找数据库中的创建活动和参加活动
        String uName = user.getUsername();
        int uid = userService.findIdByName(uName);
        List<Activities> creAct = activitiesService.findByLid(uid);
        List<Integer> joiActId = activitiesService.findActidByUid(uid);
        List<Activities> joiAct = new ArrayList<Activities>();
        for (int actId:joiActId){
            joiAct.add(activitiesService.findActById(actId));
        }

        //3.将活动存入session传给前端
        model.addAttribute("creAct",creAct);
        model.addAttribute("joiAct",joiAct);

        return "personalCenter";
    }
}





















//
//import com.zzh.domain.User;
//import org.apache.ibatis.annotations.Mapper;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.servlet.http.HttpServletRequest;
//
//@Controller
//@ComponentScan("com.zzh.service")
//@MapperScan("com.zzh.mapper")
//public class UserController{
//    @Autowired
//    private User user;
//
//    @RequestMapping()
//    public String findByName(HttpServletRequest request){
//
//    }
//
//
//}
