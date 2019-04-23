package com.uetcodecamp.jwb01;

public class User {
    private String name;
    private String email;
    private String phone;
    private int balance;

    /*public User(String name, String email, String phone, int balance)
    {
        this->name = name;
        this->email = email;
        this->phone = phone;
        this->balance = balance;
    }*/

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getBalance() {
        return balance;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

}

