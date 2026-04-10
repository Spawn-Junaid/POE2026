/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poe;
import java.util.Scanner;

/* * Student number: ST10529632
 * Name: Junaid Spawn
 * Task: POE Part 1 - Login System
 */

public class POE {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // --- REGISTRATION ---
        System.out.println("--- Registration ---");
        System.out.print("Enter First Name: ");
        String fName = input.nextLine();
        
        System.out.print("Enter Last Name: ");
        String lName = input.nextLine();

        // Username loop
        String user = "";
        while (true) {
            System.out.println("\n[Username: must have '_' and be 5 chars or less]");
            System.out.print("Enter Username: ");
            user = input.nextLine();

            Login testLogin = new Login(fName, lName, user, "", "");
            if (testLogin.checkUserName()) {
                System.out.println("Username captured.");
                break;
            } else {
                System.out.println("The username is incorrectly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.");
            }
        }

        // Password loop
        String pass = "";
        while (true) {
            System.out.println("\n[Password: 8+ chars, Capital, Number, Special]");
            System.out.print("Enter Password: ");
            pass = input.nextLine();

            Login testLogin = new Login(fName, lName, user, pass, "");
            if (testLogin.checkPasswordComplexity()) {
                System.out.println("Password captured.");
                break;
            } else {
                System.out.println("The password does not meet the complexity requirements.");
            }
        }

        System.out.print("\nEnter Phone: ");
        String phone = input.nextLine();

        // Create user account
        Login newUser = new Login(fName, lName, user, pass, phone);
        System.out.println("\n" + newUser.registerUser());

        // --- LOGIN ---
        System.out.println("\n--- Login ---");
        boolean loggedIn = false;
        
        while (!loggedIn) {
            System.out.print("Enter Username: ");
            String loginUser = input.nextLine();
            
            System.out.print("Enter Password: ");
            String loginPass = input.nextLine();

            // Verify typed credentials against saved ones
            if (newUser.loginUser(loginUser, loginPass)) {
                System.out.println(newUser.returnLoginStatus(loginUser, loginPass));
                loggedIn = true;
            } else {
                System.out.println("Login failed. Please try again.");
            }
        }
        input.close();
    }

    public static class Login {
        private String firstName, lastName, userName, password, phone;

        // Constructor fills the user data
        public Login(String f, String l, String u, String p, String n) {
            this.firstName = f;
            this.lastName = l;
            this.userName = u;
            this.password = p;
            this.phone = n;
        }

        // Checks for '_' and max 5 chars
        public boolean checkUserName() {
            return userName.contains("_") && userName.length() <= 5;
        }

        // Checks for length, uppercase, digits, and special chars
        public boolean checkPasswordComplexity() {
            boolean hasUpper = false, hasDigit = false, hasSpecial = false;
            
            if (password.length() < 8) return false;

            for (char c : password.toCharArray()) {
                if (Character.isUpperCase(c)) hasUpper = true;
                if (Character.isDigit(c)) hasDigit = true;
                if ("!@#$%^&*()-_=+[]{};:'\",.<>/?".indexOf(c) != -1) hasSpecial = true;
            }
            return hasUpper && hasDigit && hasSpecial;
        }

        public String registerUser() {
            if (!checkUserName()) return "Username incorrectly formatted.";
            if (!checkPasswordComplexity()) return "Password requirements not met.";
            return "The user has been registered successfully";
        }

        // Compares input strings to stored strings
        public boolean loginUser(String checkU, String checkP) {
            return this.userName.equals(checkU) && this.password.equals(checkP);
        }

        // Returns the success message
        public String returnLoginStatus(String u, String p) {
            if (loginUser(u, p)) {
                return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
            } else {
                return "Login failed.";
            }
        }
    }
}
