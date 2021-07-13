function submit_t(vs){
    var theme = document.getElementById("actTheme_"+vs).value;
    var url = "about";
    url += "?actTheme="+theme;
    window.location = url;
}
//主页中的”团队详情“的跳转
function submit_team(vs) {
    var team = document.getElementById("teamName_" + vs).value;
    var url = "GroupAbout";
    url += "?teamName=" + team;
    window.location = url;
}
//个人主页下”团队详情“的跳转
function submit_myteam(vs) {
    var team = document.getElementById("teamName_" + vs).value;
    var url = "GroupAct";
    url += "?teamName=" + team;
    window.location = url;
}

function sendMail(){
    // var team = document.getElementById("teamName_"+vs).value;
    var url = "Email";
    // url += "?teamName="+team;
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
    var url = "deleteAct";
    url += "?actTheme="+theme;
    window.location = url;
}

function addAct_t(){
    var actid = document.getElementById("addUseract").value;
    // alert(actid);
    var uid = document.getElementById("addUseruser").value;
    // alert(uid);
    // var theme = document.getElementById("thisTheme").value;
    // alert(theme);
    var url = "aboutAdd";
    // url += "?actTheme="+theme+"&actid"+actid+"&userid"+uid;
    url += "?actid="+actid+"&userid="+uid;
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
