package com.uas.tahajudapps.modal;

import java.util.Date;

public class Login {
    private int id;
    private String username, fullname, status;

    public Login(int id, String username, String fullname, String status) {
        this.id = id;
        this.username = username;
        this.fullname = fullname;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}