package com.placement.model;

public class Student {

    private int id;
    private String name;
    private String email;
    private String branch;
    private double cgpa;
    private String phone;

    public Student(String name, String email, String branch, double cgpa, String phone) {

        this.name = name;
        this.email = email;
        this.branch = branch;
        this.cgpa = cgpa;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getBranch() {
        return branch;
    }

    public double getCgpa() {
        return cgpa;
    }

    public String getPhone() {
        return phone;
    }
}