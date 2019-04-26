package com.jwb.bankservice;

public class Customer {

    private String name, email, phoneNumber, password = "123456";
    private int id, balance, login = 0;

    public Customer() {

    }

    public Customer(int id, String name, String email, String phoneNumber, int balance) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getLogin(){
        return login;
    }

    public void setLogin(int isLogin){
        this.login = isLogin;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String newPw){
        this.password = newPw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void transferMoney(int amount){
        balance -= amount;
    }

    public void receiveMoney(int amount){
        balance += amount;
    }
}