package com.placement.model;

public class Job {

    private int id;
    private int companyId;
    private String jobTitle;
    private double salary;
    private double minimumCgpa;
    private String location;

    public Job() {

    }

    public Job(int companyId, String jobTitle, double salary,
               double minimumCgpa, String location) {

        this.companyId = companyId;
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.minimumCgpa = minimumCgpa;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getMinimumCgpa() {
        return minimumCgpa;
    }

    public void setMinimumCgpa(double minimumCgpa) {
        this.minimumCgpa = minimumCgpa;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}