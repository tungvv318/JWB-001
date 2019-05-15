package com.uetcodecamp.model;

public class UserInfo {
    private int ID;
    private String name;
    private String email;
    private String phone;
    private int balanace;
    private String password;

    final private String defaultPassword = "123456";

    public UserInfo(int ID, String name, String email, String phone, int balanace) {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.balanace = balanace;
        this.password = defaultPassword;
    }

    public boolean subMoney(int money) {
        if (this.balanace < money) return false;
        this.balanace -= money; return true;
    }

    public boolean addMoney(int money) {
        this.balanace += money; return true;
    }

    public int getID() { return ID; }
    public void setID(int ID) { this.ID = ID; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public int getBalance() { return balanace; }
    public void setBalanace(int balanace) { this.balanace = balanace; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
