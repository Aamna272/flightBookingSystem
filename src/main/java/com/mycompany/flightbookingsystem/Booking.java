/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.flightbookingsystem;
import java.sql.Date;
import javax.swing.JOptionPane;
/**
 *
 * @author PMYLS
 */
public class Booking {
    private String bookingId;
    private Date bookingDate;
    private String bookingStatus;
    private String seatNo;
    
    public void confirmBooking(){
        JOptionPane.showMessageDialog(null,
                "Your booking has been successfully confirmed!",
                "Booking Confirmation",
                JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void cancelBooking(){
        
    }
    
    public void viewBookings(){
    
    }
    
    public void display(){
        
    }
}
