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
        int leaderId = userService.findIdByName(leaderName);
        teamService.addTeam(leaderId,name,message);
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


        return "GroupAct";
    }

    @RequestMapping("/GroupaboutAdd")
    public String GroupAboutAdd(Model model,
                                HttpServletRequest request,
                                HttpSession session,
                                @RequestParam(value="teamid")int teamid,
                                @RequestParam(value = "userid")int userid){
        teamService.addUser(teamid,userid);
        Teams thisTeam = teamService.findById(teamid);
        int leaderId = thisTeam.getLeaderid();
        List<Activities> thisActivities = activitiesService.findByLid(leaderId);
        model.addAttribute("thisActivities",thisActivities);
        return "GroupAbout";
    }

}
