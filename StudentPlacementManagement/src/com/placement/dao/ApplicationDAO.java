package com.placement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.placement.model.Application;
import com.placement.util.DBConnection;

public class ApplicationDAO {

    // =====================================================
    // 1. SAVE APPLICATION
    // =====================================================

    public void saveApplication(Application application) {

        String sql = "INSERT INTO applications "
                + "(student_id, job_id, application_date, status) "
                + "VALUES (?, ?, ?, ?)";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, application.getStudentId());

            ps.setInt(2, application.getJobId());

            ps.setDate(
                    3,
                    java.sql.Date.valueOf(
                            application.getApplicationDate()
                    )
            );

            ps.setString(4, application.getStatus());

            ps.executeUpdate();

            System.out.println(
                    "Application submitted successfully!"
            );

            ps.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }


    // =====================================================
    // 2. VIEW ALL APPLICATIONS
    // =====================================================

    public void getAllApplications() {

        String sql =
                "SELECT a.id, "
                + "s.name AS student_name, "
                + "c.name AS company_name, "
                + "j.job_title, "
                + "a.application_date, "
                + "a.status "
                + "FROM applications a "
                + "JOIN students s ON a.student_id = s.id "
                + "JOIN jobs j ON a.job_id = j.id "
                + "JOIN companies c ON j.company_id = c.id";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            System.out.println(
                    "\n----- ALL APPLICATIONS -----"
            );

            while (rs.next()) {

                System.out.println(
                        "Application ID : "
                        + rs.getInt("id")
                );

                System.out.println(
                        "Student        : "
                        + rs.getString("student_name")
                );

                System.out.println(
                        "Company        : "
                        + rs.getString("company_name")
                );

                System.out.println(
                        "Job            : "
                        + rs.getString("job_title")
                );

                System.out.println(
                        "Date           : "
                        + rs.getDate("application_date")
                );

                System.out.println(
                        "Status         : "
                        + rs.getString("status")
                );

                System.out.println(
                        "----------------------------"
                );
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }


    // =====================================================
    // 3. UPDATE APPLICATION STATUS
    // =====================================================

    public void updateApplicationStatus(
            int applicationId,
            String status) {

        String sql =
                "UPDATE applications "
                + "SET status = ? "
                + "WHERE id = ?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, status);

            ps.setInt(2, applicationId);

            int rows = ps.executeUpdate();

            if (rows > 0) {

                System.out.println(
                        "Application status updated successfully!"
                );

            } else {

                System.out.println(
                        "Application not found!"
                );
            }

            ps.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }


    // =====================================================
    // 4. CHECK DUPLICATE APPLICATION
    // =====================================================

    public boolean applicationExists(
            int studentId,
            int jobId) {

        String sql =
                "SELECT id "
                + "FROM applications "
                + "WHERE student_id = ? "
                + "AND job_id = ?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, studentId);

            ps.setInt(2, jobId);

            ResultSet rs = ps.executeQuery();

            boolean exists = rs.next();

            rs.close();
            ps.close();
            con.close();

            return exists;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }


    // =====================================================
    // 5. CHECK APPLICATION BY ID
    // =====================================================

    public boolean applicationExistsById(
            int applicationId) {

        String sql =
                "SELECT id "
                + "FROM applications "
                + "WHERE id = ?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, applicationId);

            ResultSet rs = ps.executeQuery();

            boolean exists = rs.next();

            rs.close();
            ps.close();
            con.close();

            return exists;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }


    // =====================================================
    // 6. VIEW APPLICATIONS OF ONE STUDENT
    // =====================================================

    public void getApplicationsByStudent(
            int studentId) {

        String sql =
                "SELECT a.id, "
                + "a.application_date, "
                + "a.status, "
                + "j.job_title, "
                + "c.name AS company_name "
                + "FROM applications a "
                + "JOIN jobs j "
                + "ON a.job_id = j.id "
                + "JOIN companies c "
                + "ON j.company_id = c.id "
                + "WHERE a.student_id = ?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, studentId);

            ResultSet rs = ps.executeQuery();

            System.out.println(
                    "\n----- MY APPLICATIONS -----"
            );

            boolean found = false;

            while (rs.next()) {

                found = true;

                System.out.println(
                        "Application ID : "
                        + rs.getInt("id")
                );

                System.out.println(
                        "Job            : "
                        + rs.getString("job_title")
                );

                System.out.println(
                        "Company        : "
                        + rs.getString("company_name")
                );

                System.out.println(
                        "Applied Date   : "
                        + rs.getDate("application_date")
                );

                System.out.println(
                        "Status         : "
                        + rs.getString("status")
                );

                System.out.println(
                        "---------------------------"
                );
            }

            if (!found) {

                System.out.println(
                        "No applications found for this student."
                );
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}