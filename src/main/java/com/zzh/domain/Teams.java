package com.zzh.domain;

public class Teams {
    private int leaderid;
    private String name;
    private String message;

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

    @Override
    public String toString() {
        return "Teams{" +
                "leaderid=" + leaderid +
                ", name='" + name + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
