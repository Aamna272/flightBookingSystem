package com.mycompany.flightbookingsystem;

import javax.swing.*;

public class Customer extends Person {

    private String name;
    private String gender;
    private String address;
    private String phoneNo;
    private String email;
    private String passportNo;

    Customer(String email, String passportNo) {
        this.email = email;
        this.passportNo = passportNo;

    }

    Customer(String name, String email, String gender, String passportno, String phoneno, String address) {
        this.email = email;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.passportNo = passportno;
        this.phoneNo = phoneno;

    }

    public void register() {
        try {
            if (name.isEmpty() || email.isEmpty() || gender.isEmpty() || address.isEmpty() || passportNo.isEmpty() || phoneNo.isEmpty()) {
                throw new Exception("Please fill out all the required fields!");
            } else if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                throw new Exception("Invalid email format.");
            } else if (!phoneNo.matches("\\d{11}")) {
                throw new Exception("Phone number must be 10 digits.");
            } else if (!passportNo.matches("[A-Za-z0-9]{6,9}")) {
                throw new Exception("Passport number must be alphanumeric and 6-9 characters long.");

            } else {
                new Login("Passanger").setVisible(true);
            }
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(this,e);
            e.printStackTrace();
        }
    }

    public void login() {
        try {
            if (email.isEmpty() || passportNo.isEmpty()) {
                //JOptionPane.showMessageDialog(this, "Please fill out the required fields");
            } else if (email.equals("customer@gmail.com") && passportNo.equals("1234567890")) {
                new CustomerDashboard().setVisible(true);
            } else {
                System.out.println("Username or password is incorrect!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void display() {

    }
}
