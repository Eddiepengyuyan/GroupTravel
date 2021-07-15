package com.zzh.controller;

import com.zzh.domain.Activities;
import com.zzh.domain.User;
import com.zzh.serviceImpl.ActivitiesService;
import com.zzh.serviceImpl.TeamService;
import com.zzh.serviceImpl.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ActivitiesController {

    public void showActivities(Model model,int teamId){
        List<Integer> actids = activitiesService.findActidByTid(teamId);
        if(actids.size() == 0){
            actids.add(-1);
        }
        List<Activities> thisActivities = activitiesService.findActByIds(actids);
        List<Activities> activities = activitiesService.findAll();
        model.addAttribute("activities", thisActivities);
    }

    public void aboutAct(Model model,HttpSession session,String theme,int teamId,HttpServletRequest request){
        //获取当前用户
        session = request.getSession();
        User thisUser = (User)session.getAttribute("thisUser");
        //获取当前活动
        Activities activity = activitiesService.findByTheme(theme);
        //获取团长信息
        int leaderid = activity.getLeaderid();
        String leaderName = userService.findById(leaderid).getRealname();
        //查询team_user表中用户的id
        List<Integer> tUids = teamService.findUserIds(teamId);
        boolean isInTeam = false;
        if(thisUser != null){
            for(int uid:tUids){
                if(thisUser.getId()==uid){
                    isInTeam = true;
                }
            }
        }

        //查询act_user表中此活动的uid
        int actid = activity.getId();
        List<Integer> aUids = userService.findIdByActid(actid);
        List<User> users = new ArrayList<User>();
        for (Integer uid : aUids){
            users.add(userService.findById(uid));
        }

        //报名活动的状态
        boolean isInAct = false;
        if(thisUser != null){
            for(int uid:aUids){
                if(thisUser.getId()==uid){
                    isInAct = true;
                }
            }
        }

        //活动进行状态
        int status = activity.getStatus();

        //添加进session和model
        session.setAttribute("thisActivity",activity);
        session.setAttribute("leadername",leaderName);
        showActivities(model,teamId);
        model.addAttribute("teamId",teamId);
        model.addAttribute("users",users);
        model.addAttribute("isInAct",isInAct);
        model.addAttribute("isInTeam",isInTeam);
    }

    @Resource
    private ActivitiesService activitiesService;
    @Resource
    private UserService userService;
    @Resource
    private TeamService teamService;

    @RequestMapping("/createAct")
    public String contactinfo(Model model,
                              @RequestParam("teamId")int teamId)
    {
        showActivities(model,teamId);
        model.addAttribute("teamId",teamId);
        return "createAct";
    }

    @RequestMapping("/transfer")
    public String contactMapper(
                        @RequestParam(value="activity_name")String name,
                        @RequestParam(value="activity_number")String number,
                        @RequestParam(value="activity_subject")String subject,
                        @RequestParam(value="activity_time")String time,
                        @RequestParam(value="activity_start")String start,
                        @RequestParam(value="activity_cost")String cost,
                        @RequestParam(value="activity_message")String message,
                        @RequestParam(value="teamId")int teamId,
                        Model model) throws IOException
    {
//        System.out.println("传参test"+name+number+theme);
        int leaderid = userService.findIdByName(name);
        activitiesService.insert(subject,start,time,number,cost,message,leaderid);
        //添加进act_user
        Activities thisAct = activitiesService.findByTheme(subject);
        userService.addUser(thisAct.getId(), leaderid);
        //添加进team_act
        teamService.addAct(teamId,thisAct.getId());
        showActivities(model,teamId);
        return "redirect:/index";
    }

    @RequestMapping("/about")
    public String activityDetial(Model model,
                                 HttpServletRequest request,
                                 HttpSession session,
                                 @RequestParam(value="actTheme",required = false)String theme,
                                 @RequestParam(value="teamId")int teamId)
    {
        aboutAct(model,session,theme,teamId,request);
        return "about";
    }



    @RequestMapping("/aboutAdd")
    public String addUser(Model model,
                          HttpServletRequest request,
                          HttpSession session,
                          @RequestParam(value="actid")int actid,
                          @RequestParam(value = "userid")int userid,
                          @RequestParam(value="teamId")int teamId
                          )
    {
        int uid = userid;
        userService.addUser(actid,uid);
        Activities act = activitiesService.findActById(actid);
        String theme = act.getTheme();
        System.out.println(theme);
        aboutAct(model,session,theme,teamId,request);
        return "about";
    }

    @RequestMapping("/deleteAct")
    public String deleteAct(Model model,
                            HttpServletRequest request,
                            HttpSession session,
                            @RequestParam(value="actTheme")String theme,
                            @RequestParam(value="teamId")int teamId,
                            RedirectAttributes redirectAttributes)
    {
        Activities activity = activitiesService.findByTheme(theme);
        int actid = activity.getId();
        activitiesService.deleteById(actid);
        redirectAttributes.addAttribute("teamId",teamId);
        return "redirect:/GroupAct";
    }

    @RequestMapping("/edit")
    public String editAct(Model model,
                          HttpServletRequest request,
                          HttpSession session,
                          @RequestParam(value="actTheme",required = false)String theme,
                          @RequestParam(value="teamId")int teamId)
    {
        model.addAttribute("teamId",teamId);
        return "edit";
    }

    @RequestMapping("/editSuccess")
    public String editSuccess(@RequestParam(value="activity_number")String number,
                              @RequestParam(value="activity_subject")String theme,
                              @RequestParam(value="activity_time")String time,
                              @RequestParam(value="activity_start")String start,
                              @RequestParam(value="activity_cost")String fee,
                              @RequestParam(value="activity_message")String message,
                              @RequestParam(value="teamId",required = false)int teamId,
                              Model model,
                              HttpServletRequest request,
                              HttpServletResponse response,
                              RedirectAttributes redirectAttributes,
                              HttpSession session)
    {
        int id = activitiesService.findByTheme(theme).getId();
        activitiesService.updateAct(id,number,theme,time,start,fee,message);
        redirectAttributes.addAttribute("teamId",teamId);
        return "redirect:/GroupAct";
    }

    @RequestMapping("/setup")
    public String setupAct(@RequestParam(value="actTheme")String theme,
                           @RequestParam(value="teamId")String teamId,
                           HttpSession session,
                           HttpServletRequest request,
                           HttpServletResponse response,
                           RedirectAttributes redirectAttributes)
    {
        Activities thisAct = activitiesService.findByTheme(theme);
        int id = thisAct.getId();
        activitiesService.setupAct(id);
        int fee = Integer.parseInt(thisAct.getFee());
        int countUser = activitiesService.countUserByActId(thisAct.getId());
        int feePerUser = fee/countUser;
        activitiesService.addAaperfee(feePerUser,id);
        redirectAttributes.addAttribute("teamId",teamId);
        return "redirect:/GroupAct";
    }
    
    @RequestMapping("/closeAct")
    public String closeAct(@RequestParam(value="actTheme")String theme,
                           @RequestParam(value="teamId")String teamId,
                           RedirectAttributes redirectAttributes,
                           Model model)
    {
        Activities thisAct = activitiesService.findByTheme(theme);
        int id = thisAct.getId();
        activitiesService.closeAct(id);
        redirectAttributes.addAttribute("teamId",teamId);
        return "redirect:/GroupAct";
    }

    @RequestMapping("/actReport")
    public String actReport(@RequestParam(value="actTheme")String theme,
                            @RequestParam(value="teamId")int teamId,
                            Model model,
                            HttpServletRequest request,
                            HttpServletResponse response,
                            HttpSession session)
    {

        //查找本团队的活动活动
        List<Integer> actIds = activitiesService.findActidByTid(teamId);
        if (actIds.size() == 0){
            actIds.add(-1);
        }
        List<Activities> activities = activitiesService.findActByIds(actIds);
        //获得活动id
        Activities thisAct = activitiesService.findByTheme(theme);
        int leaderId = thisAct.getLeaderid();
        User leader = userService.findById(leaderId);
        int fee = Integer.parseInt(thisAct.getFee());
        int countUser = activitiesService.countUserByActId(thisAct.getId());
        int feePerUser = fee/countUser;

        model.addAttribute("actList",activities);
        model.addAttribute("thisActivity",thisAct);
        model.addAttribute("leaderName",leader.getUsername());
        model.addAttribute("teamId",teamId);
        model.addAttribute("countUser",countUser);
        model.addAttribute("feePerUser",feePerUser);
        return "actReport";
    }

    @RequestMapping("/add_zjperfee")
    public String add_zjperfee(Model model,
                               HttpServletRequest request,
                               HttpServletResponse response,
                               HttpSession session,
                               RedirectAttributes redirectAttributes,
                               @RequestParam(value="addUseract")int actId,
                               @RequestParam(value="addUseruser")int userId,
                               @RequestParam(value="zj_perfee")int zjperfee,
                               @RequestParam(value="teamId")int teamId,
                               @RequestParam(value="thisActTheme")String theme){
        //缴纳费用
        int zjBefore = activitiesService.getZjperfee(actId,userId);
        int zjAfter = zjperfee + zjBefore;
        activitiesService.addZjperfee(zjAfter,actId,userId);

        //debug
        System.out.println(zjperfee);
        System.out.println(zjAfter);
        
        redirectAttributes.addAttribute("teamId",teamId);
        redirectAttributes.addAttribute("actTheme",theme);
        return "redirect:/about";
    }

    @RequestMapping("/pay")
    public String pay(Model model,
                      HttpSession session,
                      HttpServletRequest request,
                      HttpServletResponse response,
                      @RequestParam("actTheme")String theme)
    {
        session = request.getSession();
        User thisUser = (User)session.getAttribute("thisUser");
        int uid = thisUser.getId();
        Activities thisAct = activitiesService.findByTheme(theme);
        int actId = thisAct.getId();
        int aaPerFee = activitiesService.getAaperfee(actId,uid);
        int zjPerFee = activitiesService.getZjperfee(actId,uid);
        int perFee = aaPerFee+zjPerFee;
        model.addAttribute("thisActivity",thisAct);
        model.addAttribute("aaPerFee",aaPerFee);
        model.addAttribute("zjPerFee",zjPerFee);
        model.addAttribute("perFee",perFee);
        return"pay";
    }


}
