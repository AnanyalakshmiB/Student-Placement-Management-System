package com.placement.model;

public class Company {

    private int id;
    private String name;
    private String location;
    private String website;

    public Company() {

    }

    public Company(String name, String location, String website) {

        this.name = name;
        this.location = location;
        this.website = website;
    }

    public Company(int id, String name, String location, String website) {

        this.id = id;
        this.name = name;
        this.location = location;
        this.website = website;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}