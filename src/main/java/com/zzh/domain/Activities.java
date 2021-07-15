package com.zzh.domain;

public class Activities {
    private int id;
    private String theme;
    private String start;
    private String date;
    private String number;
    private String fee;
    private String message;
    private int leaderid;
    private int status;
    //状态码：0 - 正在进行；1 - 成立；2 - 结束；3 - 删除

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLeaderid() {
        return leaderid;
    }

    public void setLeaderid(int leaderid) {
        this.leaderid = leaderid;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Activities{" +
                "id=" + id +
                ", theme='" + theme + '\'' +
                ", start='" + start + '\'' +
                ", date='" + date + '\'' +
                ", number='" + number + '\'' +
                ", fee='" + fee + '\'' +
                ", message='" + message + '\'' +
                ", leaderid=" + leaderid +
                ", status=" + status +
                '}';
    }
}
