package com.uetcodecamp.jwb.Model;

import com.uetcodecamp.jwb.User;

import java.util.ArrayList;
import java.util.List;

public class MockUser {
    private int id;
    private List<User> users;

    public MockUser() {
        this.users = new ArrayList<User>();
        this.users.add(new User(1, "Lai Trung Dung","laidung29022000@gmail.com", "0917311594", 299));
        this.users.add(new User(2, "Dung","laidung2902@gmail.com", "0917311594", 299));
        this.users.add(new User(3, "Lai","laidung29@gmail.com", "0917311594", 299));
        this.users.add(new User(4, "Trung","laidung@gmail.com", "0917311594", 299));

        this.id = 4;
    }

    public void addUser(String name, String email, String phone, long balance) {
        this.id++;
        users.add(new User(this.id, name, email, phone, balance));
    }

    public List<User> getUsers() {
        return users;
    }

    public User getUser(int id) {
        User user = new User(0,"","","",0);
        for(User temp: this.users) {
            if(temp.getId() == id) {
                user = temp;
            }
        }
        return user;
    }

    public int login(String email, String password) {
        for(User user: this.users) {
            if(user.getEmail().equals(email) && password.equals("123456")) {
                return user.getId();
            }
        }
        return 0;
    }

    public boolean Transfer(int fromId, int toId, long balance) {
        if (toId > id || toId < 1 || fromId == toId) {
            return false;
        }
        for (User temp : this.users) {
            if (temp.getId() == fromId) {
                if (!temp.TranBalance(balance)) {
                    return false;
                }
            } else if (temp.getId() == toId) {
                temp.PlusBalance(balance);
            }
        }
        return true;
    }

    public boolean DeleteUser(int id) {
        for(User temp: this.users) {
            if(temp.getId() == id) {
                users.remove(temp);
                return true;
            }
        }
        return false;
    }

}
