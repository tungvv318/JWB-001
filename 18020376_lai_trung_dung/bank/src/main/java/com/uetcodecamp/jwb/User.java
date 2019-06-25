package com.uetcodecamp.jwb;

public class User {
    private int id;
    private String name;
    private String email;
    private String phone;
    private long balance;

    public User(int id, String name, String email, String phone, long balance) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.balance = balance;
    }

    public boolean TranBalance(long TranBalance) {
        if(this.balance < TranBalance) {
            return false;
        }
        this.balance -= TranBalance;
        return true;
    }

    public boolean PlusBalance(long PlusBalance) {
        this.balance += PlusBalance;
        return true;
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

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public  long getBalance() {
        return balance;
    }
    public int getId() { return id;}
    public void setId(int id) { this.id = id; }
}
