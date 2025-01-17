package com.mycompany.flightbookingsystem;

import javax.swing.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class Customer extends Person {

    private String name;
    private String gender;
    private String address;
    private String phoneNo;
    private String email;
    private String passportNo;
    private String password;
    private String role;

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
        this.password = passportno;
        this.role = "Customer";

    }

    private void validateFields() throws Exception {
        if (name.isEmpty() || email.isEmpty() || gender.isEmpty() || address.isEmpty() || passportNo.isEmpty() || phoneNo.isEmpty()) {
            throw new Exception("Please fill out all the required fields!");
        } else if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new Exception("Invalid email format.");
        } else if (!phoneNo.matches("\\d{11}")) {
            throw new Exception("Phone number must be 11 digits.");
        } else if (!passportNo.matches("[A-Za-z0-9]{6,9}")) {
            throw new Exception("Passport number must be alphanumeric and 6-9 characters long.");
        }
    }

    public void register() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            validateFields();

            connection = DatabaseConnection.openConnection();

            String sql = "INSERT INTO Users (role, username, email, passport_number, password, gender, address) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "Customer");
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, passportNo);
            preparedStatement.setString(5, password);
            preparedStatement.setString(6, gender);
            preparedStatement.setString(7, address);

            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Customer registered successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                new Login("Passenger").setVisible(true);
                new customerRegistration().setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Failed to register customer. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "MySQL JDBC Driver not found. Please add the driver to your classpath.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            DatabaseConnection.closeResources(connection, preparedStatement);
        }
    }

    public void login() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Check if fields are empty
            if (email.isEmpty() || passportNo.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill out the required fields", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            connection = DatabaseConnection.openConnection();

            String sql = "SELECT * FROM Users WHERE email = ? AND passport_number = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, passportNo);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                //JOptionPane.showMessageDialog(null, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                new CustomerDashboard().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid email or passport number!", "Login Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            DatabaseConnection.closeResources(connection, preparedStatement);
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void display() {
        
    }
}
