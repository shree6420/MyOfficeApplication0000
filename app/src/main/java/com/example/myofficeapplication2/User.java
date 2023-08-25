package com.example.myofficeapplication2;

import android.widget.EditText;

public class User {
    private String username;
    private String password;
    private int id;
    private String email;

    // Constructor
    public User(String username, String password,int id) {
        this.username = username;
        this.password = password;
        this.id=id;
        this.email=email;
    }

    public User(EditText editTextName, EditText editTextPassword,EditText editTextEmail) {

    }

    // Getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() { return email;}
    public void setEmail(String email) {this.email =email;}



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void displayUserInfo() {
        System.out.println("Username: " + username);
        System.out.println("password: " + password);
        System.out.println("email: " + email);
        System.out.println("id: " + id);
    }
}




