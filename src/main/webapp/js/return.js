function submit_t(vs){
    var theme = document.getElementById("actTheme_"+vs).value;
    var teamid = document.getElementById("teamId").value;
    var url = "about";
    url += "?actTheme="+theme+"&teamId="+teamid;
    window.location = url;
}

function submit_ta(vs){
    var theme = document.getElementById("actTheme_"+vs).value;
    var url = "aboutJoi";
    url += "?actTheme="+theme;
    window.location = url;
}
//主页中的”团队详情“的跳转
function submit_team(vs) {
    var team = document.getElementById("teamId_" + vs).value;
    var url = "GroupAbout";
    url += "?teamId=" + team;
    window.location = url;
}
//个人主页下”团队详情“的跳转
function submit_myteam(vs) {
    var team = document.getElementById("teamId_" + vs).value;
    var url = "GroupAct";
    url += "?teamId=" + team;
    window.location = url;
}

function sendMail(){
    // var team = document.getElementById("teamName_"+vs).value;
    var url = "Email";
    // url += "?teamName="+team;
    window.location = url;
}

function closeAct(vs){
    var theme = document.getElementById("actTheme_"+vs).value;
    var teamId = document.getElementById("teamId").value;
    var url = "closeAct";
    url += "?actTheme="+theme+"&teamId="+teamId;
    alert("活动已结束");
    window.location = url;
}

function actReport(vs){
    var theme = document.getElementById("actTheme_"+vs).value;
    var teamid = document.getElementById("teamId").value;
    var url = "actReport";
    url += "?actTheme="+theme+"&teamId="+teamid;
    window.location = url;
}

// function submit_g(vs){
//     var theme = document.getElementById("teamName_"+vs).value;
//     var url = "";
//     url += "?actTheme="+theme;
//     window.location = url;
// }

function delete_t(vs){
    var theme = document.getElementById("actTheme_"+vs).value;
    var teamId = document.getElementById("teamId").value;
    var url = "deleteAct";
    url += "?actTheme="+theme+"&teamId="+teamId;
    alert("删除成功");
    window.location = url;
}

function addAct_t(){
    var actid = document.getElementById("addUseract").value;
    // alert(actid);
    var uid = document.getElementById("addUseruser").value;
    // alert(uid);
    var teamId = document.getElementById("teamId").value;
    // alert(theme);
    var url = "aboutAdd";
    // url += "?actTheme="+theme+"&actid"+actid+"&userid"+uid;
    url += "?actid="+actid+"&userid="+uid+"&teamid="+teamId;
    window.location=url;
}

function addTeam_t(){
    var teamid = document.getElementById("addUserteam").value;
    // alert(actid);
    var uid = document.getElementById("addUseruser").value;
    // alert(uid);
    // var theme = document.getElementById("thisTheme").value;
    // alert(theme);
    var url = "GroupaboutAdd";
    // url += "?actTheme="+theme+"&actid"+actid+"&userid"+uid;
    url += "?teamid="+teamid+"&userid="+uid;
    window.location=url;
}

function editAct(vs){
    var theme = document.getElementById("actTheme_"+vs).value;
    var teamId = document.getElementById("teamId").value;
    var url = "edit";
    url += "?actTheme="+theme+"&teamId="+teamId;
    window.location = url;
}

function setup(vs){
    var theme = document.getElementById("actTheme_"+vs).value;
    var teamId = document.getElementById("teamId").value;
    var url = "setup";
    url += "?actTheme="+theme+"&teamId="+teamId;
    window.location = url;
}

//追加费用
function  add_zjperfee(){
    var addUseract = document.getElementById("addUseract1").value;
    // alert(addUseract);
    var addUseruser = document.getElementById("addUseruser1").value;
    // alert(addUseruser);
    var zj_perfee = document.getElementById("zj_perfee").value;
    // alert(zj_perfee);
    var teamId = document.getElementById("teamId1").value;
    // alert(teamId);
    var thisActTheme = document.getElementById("thisActTheme1").value;
    // alert(thisActTheme);
    var url = "add_zjperfee";
    url += "?addUseract="+addUseract+"&addUseruser="+addUseruser+"&zj_perfee="+zj_perfee+"&teamId="+teamId+"&thisActTheme="+thisActTheme;
    window.location = url;
}
