package com.uetcodecamp.model;

import org.apache.catalina.User;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private int recentID;
    private List<UserInfo> members;

    public Database() {
        this.members = new ArrayList<UserInfo>();
        this.members.add(new UserInfo(1, "Nguyen Quang Vinh", "hakuno2000@gmail.com", "0911482412", 1000));
        this.members.add(new UserInfo(2, "Nguyen Tat Thanh", "yeunuoc@gmail.com", "0969123969", 0));
        this.members.add(new UserInfo(3, "Nguyen Manh Nguyen", "nguyenngao@gmail.com", "0123456789", 500000));
        this.recentID = 1;
    }

    public UserInfo getUser(int ID) {
        for (UserInfo temp : this.members)
            if (temp.getID() == ID) return temp;
        UserInfo fake = new UserInfo(0, "", "", "", 0);
        return fake;
    }

    public void addUser(String name, String email, String phone, int balance) {
        ++recentID;
        members.add(new UserInfo(recentID, name, email, phone, balance));
    }

    public boolean deleteUser(int ID) {
        for (UserInfo temp : this.members)
            if (temp.getID() == ID) {
                members.remove(temp); return true;
            }
        return false;
    }

    public boolean editUser(int ID, String name, String email, String phone, int balance) {
        for (UserInfo temp : this.members)
            if (temp.getID() == ID) {
                temp.setName(name);
                temp.setEmail(email);
                temp.setPhone(phone);
                temp.setBalanace(balance);
                return true;
            }
        return false;
    }

    public boolean transferMoney(int fromID, int toID, int money) {
        if (fromID == toID) return false;
        //if (fromID > recentID || fromID < 1) return false;
        //if (toID > recentID || toID < 1) return false;

        for (UserInfo temp : this.members)
            if (temp.getID() == fromID) temp.subMoney(money);
            else if (temp.getID() == toID) temp.addMoney(money);
        return true;
    }

    public int validateLogin(String email, String password) {
        for (UserInfo temp : this.members)
            if (temp.getEmail().equals(email) && temp.getPassword().equals(password)) return temp.getID();
        return 0;
    }

    public List<UserInfo> getMembers() { return members; }
    public void setMembers(List<UserInfo> members) { this.members = members; }
}
