package com.example.friendsapp.com;

import java.io.Serializable;

public class friend implements Serializable {

    //bean is necessary when we use multiple attribute of class

    private String name,phone;


    @Override
    public String toString() {
        return name+"\n"+phone;
    }

    public friend(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
