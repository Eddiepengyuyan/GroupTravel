package com.zzh.domain;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class DetialReportVo {
    @Excel(name = "活动主题", orderNum = "0")
    private int theme;
    @Excel(name = "参与人员", orderNum = "1")
    private String users;
    @Excel(name = "AA费用", orderNum = "2")
    private String aa_PerFee;
    @Excel(name = "个人追加费用", orderNum = "3")
    private String zj_PerFee;
    @Excel(name = "总费用", orderNum = "4")
    private String perFee;

    public DetialReportVo() {
    }

    public int getTheme() {
        return theme;
    }

    public void setTheme(int theme) {
        this.theme = theme;
    }

    public String getUsers() {
        return users;
    }

    public void setUsers(String users) {
        this.users = users;
    }

    public String getAa_PerFee() {
        return aa_PerFee;
    }

    public void setAa_PerFee(String aa_PerFee) {
        this.aa_PerFee = aa_PerFee;
    }

    public String getZj_PerFee() {
        return zj_PerFee;
    }

    public void setZj_PerFee(String zj_PerFee) {
        this.zj_PerFee = zj_PerFee;
    }

    public String getPerFee() {
        return perFee;
    }

    public void setPerFee(String perFee) {
        this.perFee = perFee;
    }

    @Override
    public String toString() {
        return "DetialReportVo{" +
                "theme=" + theme +
                ", users='" + users + '\'' +
                ", aa_PerFee='" + aa_PerFee + '\'' +
                ", zj_PerFee='" + zj_PerFee + '\'' +
                ", perFee='" + perFee + '\'' +
                '}';
    }
}
