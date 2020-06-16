package com.example.mediapembelajarandbms;

public class User {
    private String mail, pwd;

    public User() {

    }

    public User(String mail, String pwd) {
        this.mail = mail;
        this.pwd = pwd;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
