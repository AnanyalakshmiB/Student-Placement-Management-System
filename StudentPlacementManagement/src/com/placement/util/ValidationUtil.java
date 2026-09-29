package com.placement.util;

import java.util.Scanner;

public class ValidationUtil {

    // Name validation
	public static String getValidName(Scanner sc) {

	    while (true) {

	        System.out.print("Enter your name: ");

	        String name = sc.nextLine().trim();

	        if (name.isEmpty()) {

	            System.out.println("Name cannot be empty.");

	        } else if (!name.matches("[a-zA-Z ]+")) {

	            System.out.println(
	                    "Name should contain only letters."
	            );

	        } else {

	            return name;
	        }
	    }
	}

    // Email validation
    public static String getValidEmail(Scanner sc) {

        while (true) {

            System.out.print("Enter your email: ");

            String email = sc.nextLine().trim();

            if (email.matches(
                    "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {

                return email;

            } else {

                System.out.println(
                        "Please enter a valid email address."
                );
            }
        }
    }

    // Branch validation
    public static String getValidBranch(Scanner sc) {

        while (true) {

            System.out.print("Enter your branch: ");
            String branch = sc.nextLine();

            if (!branch.trim().isEmpty()) {
                return branch;
            }

            System.out.println("Branch cannot be empty.");
        }
    }

    // CGPA validation
    public static double getValidCgpa(Scanner sc) {

        while (true) {

            System.out.print("Enter your CGPA (0 - 10): ");

            try {

                double cgpa = sc.nextDouble();
                sc.nextLine();

                if (cgpa >= 0 && cgpa <= 10) {
                    return cgpa;
                }

                System.out.println(
                    "Invalid CGPA! Enter a value between 0 and 10."
                );

            } catch (Exception e) {

                System.out.println("Please enter a number.");
                sc.nextLine();
            }
        }
    }

    // Phone validation
    public static String getValidPhone(Scanner sc) {

        while (true) {

            System.out.print("Enter your phone number: ");
            String phone = sc.nextLine();

            if (phone.matches("[0-9]{10}")) {
                return phone;
            }

            System.out.println(
                "Invalid phone number! Enter exactly 10 digits."
            );
        }
    }

    // Menu choice validation
    public static int getValidChoice(Scanner sc) {

        while (true) {

            System.out.print("Enter your choice: ");

            try {

                int choice = sc.nextInt();
                sc.nextLine();

                return choice;

            } catch (Exception e) {

                System.out.println("Please enter a number.");
                sc.nextLine();
            }
        }
     
    }
    
    public static String getValidCompanyName(Scanner sc) {

        while (true) {

            System.out.print("Enter company name: ");
            String companyName = sc.nextLine();

            if (!companyName.trim().isEmpty()) {
                return companyName;
            }

            System.out.println("Company name cannot be empty.");
        }
    }
    
    public static String getValidLocation(Scanner sc) {

        while (true) {

            System.out.print("Enter company location: ");
            String location = sc.nextLine();

            if (!location.trim().isEmpty()) {
                return location;
            }

            System.out.println("Location cannot be empty.");
        }
    }
    
    public static String getValidJobTitle(Scanner sc) {

        while (true) {

            System.out.print("Enter job title: ");
            String jobTitle = sc.nextLine();

            if (!jobTitle.trim().isEmpty()) {
                return jobTitle;
            }

            System.out.println("Job title cannot be empty.");
        }
    }
    
    public static double getValidSalary(Scanner sc) {

        while (true) {

            System.out.print("Enter salary in LPA: ");

            try {

                double salary = sc.nextDouble();
                sc.nextLine();

                if (salary > 0) {
                    return salary;
                }

                System.out.println("Salary must be greater than 0.");

            } catch (Exception e) {

                System.out.println("Please enter a valid number.");
                sc.nextLine();
            }
        }
    }
    
    public static double getValidMinimumCgpa(Scanner sc) {

        while (true) {

            System.out.print("Enter minimum CGPA (0 - 10): ");

            try {

                double cgpa = sc.nextDouble();
                sc.nextLine();

                if (cgpa >= 0 && cgpa <= 10) {
                    return cgpa;
                }

                System.out.println("CGPA must be between 0 and 10.");

            } catch (Exception e) {

                System.out.println("Please enter a valid number.");
                sc.nextLine();
            }
        }
    }
    
    public static int getValidPositiveInteger(Scanner sc, String message) {

        while (true) {

            System.out.print(message);

            try {

                int value = sc.nextInt();
                sc.nextLine();

                if (value > 0) {
                    return value;
                }

                System.out.println("ID must be greater than 0.");

            } catch (Exception e) {

                System.out.println("Please enter a valid number.");
                sc.nextLine();
            }
        }
    }
    public static String getValidWebsite(Scanner sc) {

        while (true) {

            System.out.print("Enter company website: ");

            String website = sc.nextLine().trim();

            if (website.isEmpty()) {

                System.out.println(
                        "Website cannot be empty."
                );

            } else if (
                    website.matches(
                            "^(https?://)?([\\w-]+\\.)+[\\w-]{2,}(/.*)?$"
                    )
            ) {

                return website;

            } else {

                System.out.println(
                        "Please enter a valid website."
                );
            }
        }
    }
    
    
    
}