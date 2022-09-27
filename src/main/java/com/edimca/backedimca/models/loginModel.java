package com.edimca.backedimca.models;

public class loginModel {

    public int id;
    public String user;
    public String password;
    public loginModel(int id, String user, String password) {
        this.id =id;
        this.user = user;
        this.password = password;
    }
    public loginModel() {
    }
    public void setUser(String user) {
        this.user = user;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUser() {
        return user;
    }
    public String getPassword() {
        return password;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
}
