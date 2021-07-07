package com.zzh.domain;

import java.io.Serializable;

/**
 *
 * @author 22505
 */
public class Students implements Serializable {

    private int id;
    private String studentno;
    private String name;
    private String sex;
    private String date;
    private String classid;
    private String mobile;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentno() {
        return studentno;
    }

    public void setStudentno(String studentno) {
        this.studentno = studentno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getClassid() {
        return classid;
    }

    public void setClassid(String classid) {
        this.classid = classid;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", studentno='" + studentno + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", date='" + date + '\'' +
                ", classid='" + classid + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
