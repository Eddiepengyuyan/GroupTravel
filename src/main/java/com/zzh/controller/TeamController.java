package com.zzh.controller;

import com.zzh.domain.Activities;
import com.zzh.domain.Teams;
import com.zzh.domain.User;
import com.zzh.service.ActivitiesService;
import com.zzh.service.TeamService;
import com.zzh.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class TeamController {
    @Resource
    private TeamService teamService;
    @Resource
    private UserService userService;
    @Resource
    private ActivitiesService activitiesService;

    @RequestMapping("/createGroup")
    public String createGroupMapper(){
        return "createGroup";
    }

    @RequestMapping("/createGroupTransfer")
    public String findAllTeams(@RequestParam("group_name")String name,
                               @RequestParam("group_leader")String leaderName,
                               @RequestParam("group_info")String message,
                               Model model){
//        List<Teams> teams = teamService.findAllTeams();
//        User leader = userService.findByUsername(leaderName);
        //通过团长姓名查找团长id
        int leaderId = userService.findIdByName(leaderName);
//        在team表中添加一条记录
        teamService.addTeam(leaderId,name,message);
        //获取team的id
        Teams team = teamService.findByName(name);
        int teamId = team.getId();
        //        在team_user表中添加一条记录
        teamService.addUser(teamId,leaderId);
        return "personalCenter";
    }

    @RequestMapping("/index")
    public String findAll(Model model, HttpServletRequest req, HttpSession session){
        List<Teams> teams = teamService.findAllTeamsAndLeaders();
//        int leaderId = -1;
//        if(teams.size()!=0){
//            leaderId = teams.get(0).getLeaderid();
//        }
//        User leader = userService.findById(leaderId);

        model.addAttribute("teams",teams);
//        model.addAttribute("leader",leader);
        return "index";
    }

    @RequestMapping("/GroupAbout")
    public String GroupAbout(Model model,
                             HttpServletRequest request,
                             HttpSession session,
                             @RequestParam(value="teamName",required = false)String teamName){
        Teams thisTeam = teamService.findByName(teamName);
        int leaderId = thisTeam.getLeaderid();
        User leader = userService.findById(leaderId);
        model.addAttribute("thisTeam",thisTeam);
        model.addAttribute("leader",leader);
        List<Activities> thisActivities = activitiesService.findByLid(leaderId);
        model.addAttribute("thisActivities",thisActivities);
        return "GroupAbout";
    }

    @RequestMapping("/GroupAct")
    public String GroupAct(Model model,
                             HttpServletRequest request,
                             HttpSession session,
                             @RequestParam(value="teamName",required = false)String teamName){
//1.将用户信息传入
        session = request.getSession();
        User user = (User)session.getAttribute("thisUser");
        //2.通过用户信息查找数据库中的创建活动和参加活动

        //用户姓名
        String uName = user.getUsername();
        //用户id
        int uid = userService.findIdByName(uName);
        //创建的活动
        List<Activities> creAct = activitiesService.findByLid(uid);
        //加入的活动的id
        List<Integer> joiActId = activitiesService.findActidByUid(uid);
        if(joiActId.size()==0){
            joiActId.add(-1);
        }
        //加入的活动
        List<Activities> joiAct = activitiesService.findActByIds(joiActId);


        //3.将活动存入session传给前端
        model.addAttribute("creAct",creAct);
        model.addAttribute("joiAct",joiAct);


        return "GroupAct";
    }

    @RequestMapping("/GroupaboutAdd")
    public String GroupAboutAdd(Model model,
                                HttpServletRequest request,
                                HttpSession session,
                                @RequestParam(value="teamid")int teamid,
                                @RequestParam(value = "userid")int userid){
        //在team_user表中添加一条数据
        teamService.addUser(teamid,userid);
        //找到当前团队
        Teams thisTeam = teamService.findById(teamid);
        //获取团长id
        int leaderId = thisTeam.getLeaderid();
        //找到团长信息
        User leader = userService.findById(leaderId);
        //当前团队的信息
        model.addAttribute("thisTeam",thisTeam);
        //当前团队团长的信息
        model.addAttribute("leader",leader);
        //当前团队的活动
        List<Activities> thisActivities = activitiesService.findByLid(leaderId);
        model.addAttribute("thisActivities",thisActivities);
        //当前团队的成员
        List<Integer> userIds = teamService.findUserIds(thisTeam.getId());
        List<User> this_user = userService.findByids(userIds);
        model.addAttribute("users",this_user);
        return "GroupAbout";
    }

}
