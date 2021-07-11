package com.zzh.controller;

import com.zzh.domain.Teams;
import com.zzh.domain.User;
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

    @RequestMapping("/createGroup")
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
        List<Teams> teams = teamService.findAllTeams();
        int leaderId = teams.get(0).getLeaderid();
        User leader = userService.findById(leaderId);
        String leaderName = leader.getUsername();
        model.addAttribute("teams",teams);
        model.addAttribute("leader",leader);
        return "index";
    }

}
