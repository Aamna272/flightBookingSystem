/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.flightbookingsystem;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author PMYLS
 */
public class Flight {

    private int flightNo;
    private Object departure;
    private Object arrival;
    private Time departureTime;
    private Time arrivalTime;
    private int totalSeats;
    private int availableSeats;

    Flight(int flightNo, Object departure, Object arrival, Time departureTime, Time arrivalTime, int totalSeats) {
        this.flightNo = flightNo;
        this.departure = departure;
        this.arrival = arrival;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.totalSeats = totalSeats;

    }
    
    
    
    public boolean validateFlightDetails() {
    if (flightNo <=0) {
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
    return true; 
}

private void showError(String message) {
    JOptionPane.showMessageDialog(null, message, "Validation Error", JOptionPane.ERROR_MESSAGE);
}

    public void displayFlight() {
        
    }

    public void addFlight() {
    boolean b=validateFlightDetails();
    if(b==true){
    System.out.println("Flight added successfully");
    }
    }

    public void updateFlight() {

    }

    public void deleteFlight() {

    }
}
