package com.example.enquiryapp.com;

import java.io.Serializable;

public class EnquiryData implements Serializable {

    private String name,date,email,phone,courseSelected;

    public EnquiryData() {
    }

    public EnquiryData(String name, String date, String email, String phone, String courseSelected) {
        this.name = name;
        this.date = date;
        this.email = email;
        this.phone = phone;
        this.courseSelected = courseSelected;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public String getCourseSelected() {
        return courseSelected;
    }

    public void setCourseSelected(String courseSelected) {
        this.courseSelected = courseSelected;
    }
}
