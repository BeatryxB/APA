package com.example.apa.Controller.Index;

public class User {

    private String id, Mail;

    public User(String id, String role) {
        this.id = id;
        Mail = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }
}
