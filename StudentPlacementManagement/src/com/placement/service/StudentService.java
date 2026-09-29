
package com.placement.service;

import java.util.Scanner;

import com.placement.dao.StudentDAO;
import com.placement.model.Student;
import com.placement.util.ValidationUtil;

public class StudentService {

    // ========================================
    // DISPLAY STUDENT
    // ========================================

    public void displayStudent(Student student) {

        System.out.println("\n----- STUDENT DETAILS -----");

        System.out.println("Name   : " + student.getName());
        System.out.println("Email  : " + student.getEmail());
        System.out.println("Branch : " + student.getBranch());
        System.out.println("CGPA   : " + student.getCgpa());
        System.out.println("Phone  : " + student.getPhone());
    }


    // ========================================
    // REGISTER STUDENT
    // ========================================

    public void registerStudent(
            Scanner sc,
            StudentDAO studentDAO) {

        String name =
                ValidationUtil.getValidName(sc);

        String email =
                ValidationUtil.getValidEmail(sc);

        String branch =
                ValidationUtil.getValidBranch(sc);

        double cgpa =
                ValidationUtil.getValidCgpa(sc);

        String phone =
                ValidationUtil.getValidPhone(sc);

        // Check duplicate student
        if (studentDAO.studentExists(email, phone)) {

            System.out.println("Student already exists!");

            System.out.println(
                    "Email or phone number is already registered."
            );

            return;
        }

        Student student =
                new Student(
                        name,
                        email,
                        branch,
                        cgpa,
                        phone
                );

        studentDAO.saveStudent(student);

        displayStudent(student);
    }


    // ========================================
    // SEARCH STUDENT
    // ========================================

    public void searchStudent(
            Scanner sc,
            StudentDAO studentDAO) {

        int id =
                ValidationUtil.getValidPositiveInteger(
                        sc,
                        "Enter student ID: "
                );

        if (!studentDAO.studentExistsById(id)) {

            System.out.println(
                    "Student ID " + id + " does not exist."
            );

            return;
        }

        // Only search.
        // DO NOT delete here.
        studentDAO.searchStudent(id);
    }


    // ========================================
    // UPDATE STUDENT
    // ========================================

    public void updateStudent(
            Scanner sc,
            StudentDAO studentDAO) {

        int id =
                ValidationUtil.getValidPositiveInteger(
                        sc,
                        "Enter student ID to update: "
                );

        if (!studentDAO.studentExistsById(id)) {

            System.out.println(
                    "Student ID " + id + " does not exist."
            );

            return;
        }

        String name =
                ValidationUtil.getValidName(sc);

        String email =
                ValidationUtil.getValidEmail(sc);

        String branch =
                ValidationUtil.getValidBranch(sc);

        double cgpa =
                ValidationUtil.getValidCgpa(sc);

        String phone =
                ValidationUtil.getValidPhone(sc);

        // Check whether another student
        // already uses the email or phone
        if (studentDAO.studentExistsForUpdate(
                id,
                email,
                phone)) {

            System.out.println(
                    "Another student already uses this email or phone."
            );

            return;
        }

        studentDAO.updateStudent(
                id,
                name,
                email,
                branch,
                cgpa,
                phone
        );
    }


    // ========================================
    // DELETE STUDENT
    // ========================================

    public void deleteStudent(
            Scanner sc,
            StudentDAO studentDAO) {

        int id =
                ValidationUtil.getValidPositiveInteger(
                        sc,
                        "Enter student ID to delete: "
                );

        if (!studentDAO.studentExistsById(id)) {

            System.out.println(
                    "Student ID " + id + " does not exist."
            );

            return;
        }

        // Confirmation before deleting
        System.out.print(
                "Are you sure you want to delete this student? (yes/no): "
        );

        String confirmation =
                sc.nextLine().trim();

        if (confirmation.equalsIgnoreCase("yes")) {

            studentDAO.deleteStudent(id);

        } else {

            System.out.println(
                    "Delete operation cancelled."
            );
        }
    }
}

