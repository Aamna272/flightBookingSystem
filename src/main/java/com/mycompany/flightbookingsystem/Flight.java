/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.flightbookingsystem;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import java.sql.*;

/**
 *
 * @author PMYLS
 */
public class Flight {

    private String flightNo;
    private String departure;
    private String arrival;
    private String departureTime;
    private String arrivalTime;
    private Integer totalSeats;
    private Integer availableSeats;
    private String date;

    Flight(String flightNo, String departure, String arrival, String departureTime, String arrivalTime, Integer totalSeats, String date) {
        this.flightNo = flightNo;
        this.departure = departure;
        this.arrival = arrival;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
        this.date = date;
    }

    public boolean validateFlightDetails() {
        if (flightNo == null) {
            showError("Flight number cannot be empty.");
            return false;
        }

        if (departure == null || departure.toString().trim().isEmpty()) {
            showError("Departure cannot be empty.");
            return false;
        }
        if (arrival == null || arrival.toString().trim().isEmpty()) {
            showError("Arrival cannot be empty.");
            return false;
        }
        if (departureTime == null) {
            showError("Departure time cannot be empty.");
            return false;
        }
        if (arrivalTime == null) {
            showError("Arrival time cannot be empty.");
            return false;
        }
        if (totalSeats <= 0) {
            showError("Total seats must be greater than zero.");
            return false;
        }
        if (date == null) {
            showError("Date cannot be empty");
        }
        return true;
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(null, message, "Validation Error", JOptionPane.ERROR_MESSAGE);
    }

    public void displayFlight() {

    }

public void addFlight() {
    boolean b = validateFlightDetails();
    if (b) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Use DatabaseConnection to open the connection
            connection = DatabaseConnection.openConnection();

            System.out.println("Connection Established");

            // Prepare the SQL INSERT query
            String sql = "INSERT INTO Flights (flight_number, origin, destination, departure_time, arrival_time, total_seats, available_seats, flight_date)"
                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, flightNo);
            preparedStatement.setString(2, departure);
            preparedStatement.setString(3, arrival);
            preparedStatement.setString(4, departureTime);
            preparedStatement.setString(5, arrivalTime);
            preparedStatement.setInt(6, totalSeats);
            preparedStatement.setInt(7, availableSeats);
            preparedStatement.setString(8, date);

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Flight added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Failed to add flight. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Use DatabaseConnection to close resources
            DatabaseConnection.closeResources(connection, preparedStatement);
        }
    }
}

    public void updateFlight() {

    }

    public void deleteFlight() {

    }
}
