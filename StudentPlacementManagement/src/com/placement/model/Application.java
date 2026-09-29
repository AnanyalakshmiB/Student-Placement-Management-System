package com.placement.model;

import java.time.LocalDate;

public class Application {

    private int id;
    private int studentId;
    private int jobId;
    private LocalDate applicationDate;
    private String status;

    public Application() {

    }

    public Application(int studentId, int jobId,
                       LocalDate applicationDate, String status) {

        this.studentId = studentId;
        this.jobId = jobId;
        this.applicationDate = applicationDate;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public LocalDate getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(LocalDate applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}