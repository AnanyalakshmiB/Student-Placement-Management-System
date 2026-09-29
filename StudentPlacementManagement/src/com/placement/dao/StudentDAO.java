package com.placement.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

import com.placement.model.Student;
import com.placement.util.DBConnection;

public class StudentDAO {

    public void saveStudent(Student student) {

        String sql = "INSERT INTO students (name, email, branch, cgpa, phone) VALUES (?, ?, ?, ?, ?)";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getBranch());
            ps.setDouble(4, student.getCgpa());
            ps.setString(5, student.getPhone());

            ps.executeUpdate();

            System.out.println("Student saved successfully!");

            ps.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();

        }
    }
    
    public void getAllStudents() {

        String sql = "SELECT * FROM students";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            java.sql.ResultSet rs = ps.executeQuery();

            System.out.println("\n----- ALL STUDENTS -----");

            while (rs.next()) {

                System.out.println("ID     : " + rs.getInt("id"));
                System.out.println("Name   : " + rs.getString("name"));
                System.out.println("Email  : " + rs.getString("email"));
                System.out.println("Branch : " + rs.getString("branch"));
                System.out.println("CGPA   : " + rs.getDouble("cgpa"));
                System.out.println("Phone  : " + rs.getString("phone"));

                System.out.println("------------------------");
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();

        }
    }
    
    public void searchStudent(int id) {

        String sql = "SELECT * FROM students WHERE id = ?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            java.sql.ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("\n----- STUDENT FOUND -----");

                System.out.println("ID     : " + rs.getInt("id"));
                System.out.println("Name   : " + rs.getString("name"));
                System.out.println("Email  : " + rs.getString("email"));
                System.out.println("Branch : " + rs.getString("branch"));
                System.out.println("CGPA   : " + rs.getDouble("cgpa"));
                System.out.println("Phone  : " + rs.getString("phone"));

                System.out.println("-------------------------");

            } else {

                System.out.println("Student not found!");

            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();

        }
    }
    
    public void updateStudent(int id, String name, String email, String branch, double cgpa, String phone) {

        String sql = "UPDATE students SET name = ?, email = ?, branch = ?, cgpa = ?, phone = ? WHERE id = ?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, branch);
            ps.setDouble(4, cgpa);
            ps.setString(5, phone);
            ps.setInt(6, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {

                System.out.println("Student updated successfully!");

            } else {

                System.out.println("Student not found!");

            }

            ps.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();

        }
    }
    
    public void deleteStudent(int id) {

        String sql = "DELETE FROM students WHERE id = ?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {

                System.out.println("Student deleted successfully!");

            } else {

                System.out.println("Student not found!");

            }

            ps.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();

        }
    }
    
    public boolean studentExists(String email, String phone) {

        String sql = "SELECT id FROM students WHERE email = ? OR phone = ?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, email);
            ps.setString(2, phone);

            java.sql.ResultSet rs = ps.executeQuery();

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
    
    public boolean studentExistsById(int studentId) {

        String sql = "SELECT id FROM students WHERE id = ?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, studentId);

            java.sql.ResultSet rs = ps.executeQuery();

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
    
    public boolean studentExistsForUpdate(
            int studentId,
            String email,
            String phone) {

        String sql =
                "SELECT id FROM students " +
                "WHERE (email = ? OR phone = ?) " +
                "AND id <> ?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, email);
            ps.setString(2, phone);
            ps.setInt(3, studentId);

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
}