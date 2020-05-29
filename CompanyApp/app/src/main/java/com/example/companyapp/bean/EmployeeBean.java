package com.example.companyapp.bean;

public class EmployeeBean {

    private int empid;
    private String name,phone,email;

    public EmployeeBean() {

    }
    @Override
    public String toString() {
        return  empid+"\t"+name+"\t"+phone+"\t"+email;
    }
    public EmployeeBean(int empid, String name, String phone, String email) {
        this.empid = empid;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
