package com.zzh.controller;

import com.zzh.domain.Activities;
import com.zzh.domain.Teams;
import com.zzh.domain.User;
import com.zzh.serviceImpl.ActivitiesService;
import com.zzh.serviceImpl.TeamService;
import com.zzh.serviceImpl.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class UserController{
    @Resource
    private UserService userService;
    @Resource
    private ActivitiesService activitiesService;
    @Resource
    private TeamService teamService;

    public void showActivities(Model model){
        List<Teams> teams = teamService.findAllTeamsAndLeaders();
        model.addAttribute("teams", teams);
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
        if(user.getUsername().equals(username) && user.getPassword().equals(password)){
            session.setAttribute("user",user);
            return "index";
        }
        else{
            return "login";
        }
    }

    @RequestMapping("personalCenter")
    public String personalCenter(HttpSession session,
                                 HttpServletRequest req,
                                 HttpServletResponse resp,
                                 Model model){
        //1.?????????????????????
        session = req.getSession();
        User user = (User)session.getAttribute("thisUser");
        //2.??????????????????????????????????????????????????????????????????

        //????????????
        String uName = user.getUsername();
        //??????id
        int uid = userService.findIdByName(uName);
        //???????????????
        List<Teams> myTeam = teamService.findByLeaderId(uid);
        //???????????????
        List<Activities> creAct = activitiesService.findByLid(uid);
        //??????????????????id
        List<Integer> joiActId = activitiesService.findActidByUid(uid);
        if(joiActId.size()==0){
            joiActId.add(-1);
        }
        //???????????????
        List<Activities> joiAct = activitiesService.findActByIds(joiActId);

        //????????????
        int leaderId = -1;
        if(myTeam.size()!=0){
            leaderId = myTeam.get(0).getLeaderid();
        }
        User leader = userService.findById(leaderId);

        //3.???????????????session????????????
        model.addAttribute("myTeam",myTeam);
        model.addAttribute("leader",leader);
        model.addAttribute("creAct",creAct);
        model.addAttribute("joiAct",joiAct);

        return "personalCenter";
    }
}