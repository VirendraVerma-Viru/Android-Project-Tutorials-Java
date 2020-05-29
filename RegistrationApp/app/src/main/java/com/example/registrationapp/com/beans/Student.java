package com.example.registrationapp.com.beans;

import java.io.Serializable;

public class Student implements Serializable { //Serializable is a marker interface which means it is an empty

    private String name,phone,city,gender,course;

    public Student() {

    }

    public Student(String name, String phone, String city, String gender, String course) {
        this.name = name;
        this.phone = phone;
        this.city = city;
        this.gender = gender;
        this.course = course;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
