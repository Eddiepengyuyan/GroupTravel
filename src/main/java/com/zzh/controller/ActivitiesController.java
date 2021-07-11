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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ActivitiesController {

    public void showActivities(Model model){
        List<Activities> activities = activitiesService.findAll();
        model.addAttribute("activities", activities);
    }

    public void aboutAct(Model model,HttpSession session,String theme,HttpServletRequest request){
        Activities activity = activitiesService.findByTheme(theme);
        int leaderid = activity.getLeaderid();
        String leaderName = userService.findById(leaderid).getRealname();

        //查询act_user表中此活动的uid
        int actid = activity.getId();
        List<Integer> uids = userService.findIdByActid(actid);
        List<User> users = new ArrayList<User>();
        for (Integer uid : uids){
            users.add(userService.findById(uid));
        }
        //添加进session和model
        session.setAttribute("thisActivity",activity);
        session.setAttribute("leadername",leaderName);
        showActivities(model);
        model.addAttribute("users",users);
    }

    @Resource
    private ActivitiesService activitiesService;
    @Resource
    private UserService userService;

//    @RequestMapping("/index")
//    public String findAll(Model model,HttpServletRequest req,HttpSession session){
//        List<Activities> activities = activitiesService.findAll();
//
//        model.addAttribute("activities", activities);
//        session = req.getSession();
//        session.setAttribute("activities",activities);
//        return "index";
//    }

    @RequestMapping("/contact")
    public String contactinfo(Model model){
        showActivities(model);
        return "contact";
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
                        Model model) throws IOException {
//        System.out.println("传参test"+name+number+theme);
        int leaderid = userService.findIdByName(name);
        activitiesService.insert(subject,start,time,number,cost,message,leaderid);
        showActivities(model);
        return "index";
    }

    @RequestMapping("/about")
    public String activityDetial(Model model,
                                 HttpServletRequest request,
                                 HttpSession session,
                                 @RequestParam(value="actTheme",required = false)String theme){
//        Activities activity = activitiesService.findByTheme(theme);
//        int leaderid = activity.getLeaderid();
//        String leaderName = userService.findById(leaderid).getRealname();
//
//        //查询act_user表中此活动的uid
//        int actid = activity.getId();
//        List<Integer> uids = userService.findIdByActid(actid);
//        List<User> users = new ArrayList<User>();
//        for (Integer uid : uids){
//            users.add(userService.findById(uid));
//        }
//        //添加进session和model
//        session.setAttribute("thisActivity",activity);
//        session.setAttribute("leadername",leaderName);
//        showActivities(model);
//        model.addAttribute("users",users);
        aboutAct(model,session,theme,request);
        return "about";
    }

    @RequestMapping("/aboutAdd")
    public String addUser(Model model,
                          HttpServletRequest request,
                          HttpSession session,
                          @RequestParam(value="actid")int actid,
//                          @RequestParam(value = "actTheme",required = false)String theme,
                          @RequestParam(value = "userid")int userid
                          ){
//        aboutAct(model,session,theme,request);
//        System.out.println(theme);
        //将活动id和用户id存入act_user表中
//        session = request.getSession();
//        User user = (User)session.getAttribute("thisUser");
//        System.out.println(user.toString());
//        int uid = user.getId();
        int uid = userid;
        userService.addUser(actid,uid);
        Activities act = activitiesService.findActById(actid);
        String theme = act.getTheme();
        System.out.println(theme);
        aboutAct(model,session,theme,request);
        return "about";
    }

    @RequestMapping("/deleteAct")
    public String deleteAct(Model model,
                            HttpServletRequest request,
                            HttpSession session,
                            @RequestParam(value="actTheme")String theme){
        Activities activity = activitiesService.findByTheme(theme);
        int actid = activity.getId();
        System.out.println(actid);
        activitiesService.deleteById(actid);

        //1.将用户信息传入
        session = request.getSession();
        User user = (User)session.getAttribute("thisUser");
        System.out.println(user.toString());
        //2.通过用户信息查找数据库中的创建活动和参加活动
        String uName = user.getUsername();
        int uid = userService.findIdByName(uName);
        List<Activities> creAct = activitiesService.findByLid(uid);
        List<Integer> joiActId = activitiesService.findActidByUid(uid);
//        List<Activities> joiAct = new ArrayList<Activities>();
//        for (int actId:joiActId){
//            joiAct.add(activitiesService.findActById(actId));
//        }
        List<Activities> joiAct = activitiesService.findActByIds(joiActId);

        //3.将活动存入session传给前端
        model.addAttribute("creAct",creAct);
        model.addAttribute("joiAct",joiAct);

        return "personalCenter";
    }
}



//    @Autowired
//    private ActivitiesService activitiesService;
//
//    @RequestMapping("/index")
////    @ResponseBody
//    public String queryStudents(Model model){
//        List<Activities> students = activitiesService.findAll();
//        model.addAttribute("activities",students);
//        return "index";
//    }