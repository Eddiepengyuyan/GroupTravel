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
        model.addAttribute("teams",teams);
        return "index";
    }

    @RequestMapping("/GroupAbout")
    public String GroupAbout(Model model,
                             HttpServletRequest request,
                             HttpSession session,
                             @RequestParam(value="teamId",required = false)int teamId){
        //获取当前用户
        session = request.getSession();
        User user = (User)session.getAttribute("thisUser");
        //获取当前团队
        Teams thisTeam = teamService.findById(teamId);
        int leaderId = thisTeam.getLeaderid();
        User leader = userService.findById(leaderId);
        //获取当前团队中的用户的id
        List<Integer> userids = teamService.findUserIds(thisTeam.getId());
        boolean isInTeam = false;
        if(user != null){
            for (int uids:userids){
                if (user.getId() == uids){
                    isInTeam = true;
                }
            }
        }
        //获取本团队活动id
        List<Integer> actids = activitiesService.findActidByTid(teamId);
        List<Activities> thisActivities = activitiesService.findActByIds(actids);
        //参与人员
        List<User> users = userService.findByids(userids);

        model.addAttribute("isInTeam",isInTeam);
        model.addAttribute("thisTeam",thisTeam);
        model.addAttribute("leader",leader);
        model.addAttribute("users",users);
//        List<Activities> thisActivities = activitiesService.findByLid(leaderId);
        model.addAttribute("thisActivities",thisActivities);
        return "GroupAbout";
    }

    @RequestMapping("/GroupAct")
    public String GroupAct(Model model,
                             HttpServletRequest request,
                             HttpSession session,
                             @RequestParam(value="teamId",required = false)int teamId)
    {
        //加入的活动的id
        List<Integer> joiActId = activitiesService.findActidByTid(teamId);
        if(joiActId.size()==0){
            joiActId.add(-1);
        }
        //加入的活动
        //正在进行的活动
        List<Activities> joiAct0 = activitiesService.findActByIds1(joiActId);
        //正在进行的活动的费用列表
        List<Integer> joiFee0 = activitiesService.findFeeByIds1(joiActId);
        //已经结束的活动
        List<Activities> joiAct1 = activitiesService.findActByIds2(joiActId);
        //已经结束的活动的费用列表
        List<Integer> joiFee1 = activitiesService.findFeeByIds2(joiActId);
        //所有活动的人数的列表
        List<Integer> countAllUser = activitiesService.countAllUser(joiActId);

        //3.将活动存入session传给前端
//        model.addAttribute("creAct",creAct);
        model.addAttribute("joiAct_under",joiAct0);
        model.addAttribute("joiAct_close",joiAct1);
        model.addAttribute("joiFee0",joiFee0);
        model.addAttribute("joiFee1",joiFee1);
        model.addAttribute("teamId",teamId);
        model.addAttribute("teamId",teamId);
        model.addAttribute("countAllUser",countAllUser);

        return "GroupAct";
    }

    @RequestMapping("/GroupaboutAdd")
    public String GroupAboutAdd(Model model,
                                HttpServletRequest request,
                                HttpSession session,
                                @RequestParam(value="teamid")int teamid,
                                @RequestParam(value = "userid")int userid)
    {
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
