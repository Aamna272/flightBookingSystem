/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.flightbookingsystem;
import javax.swing.JOptionPane;
import java.sql.*;
/**
 *
 * @author PMYLS
 */
public class AirlineAdmin extends Person {
    private String username;
    private String password;
    AirlineAdmin (String username, String password){
        this.username=username;
        this.password=password;
    }
    
    public void login(){
    try{
        if(username.equals("admin") && password.equals("admin")){
            new AdminDashboard().setVisible(true);
        }
        else if(username.isEmpty()|| password.isEmpty()||username==null||password==null){
            System.out.println("enter your credentials");
        }
        else{
            System.out.println("wrong username or password! ");
        }
    }catch(Exception e){
        //e.printStackTrace();
        JOptionPane.showMessageDialog(null, e, "Validation Error", JOptionPane.ERROR_MESSAGE);

    }
        
    }
}
