package com.zzh.domain;

import java.util.List;

public class Teams {
    private int leaderid;
    private String name;
    private String message;

    private List<User> user;

    public Teams() {
    }

    public int getLeaderid() {
        return leaderid;
    }

    public void setLeaderid(int leaderid) {
        this.leaderid = leaderid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Teams{" +
                "leaderid=" + leaderid +
                ", name='" + name + '\'' +
                ", message='" + message + '\'' +
                ", user=" + user +
                '}';
    }
}
