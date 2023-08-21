/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.financial_management_system;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author user
 */
public class Other_expenses_page {
    
        @FXML
        private TextField priceTf; 
        
        @FXML
        private TextArea descriptionTf; 
        
     public void insertOtherData(String username){
    
         LocalDate date = LocalDate.now();
         java.sql.Date mySqlDate = java.sql.Date.valueOf( date );
         
         String priceStr = priceTf.getText();
         String descriptionStr = descriptionTf.getText();
        
         
         double price = Double.parseDouble(priceStr);
      
     try{
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","root");
            System.out.println("Connected with the database successfully");
            PreparedStatement preparedStatement = connection.prepareStatement("insert into other values(?,?,?,?)");
            
            
            preparedStatement.setString(1,username);
            preparedStatement.setDate(2, mySqlDate);
            preparedStatement.setDouble(3, price);
            preparedStatement.setString(4, descriptionStr);
           
            
            preparedStatement.executeUpdate();
            System.out.println("Data inserted Successfully");
                   
    }catch(SQLException e){
            System.out.println("Error while connecting to the database");
    }
    
    
    }
     
     
      public void reducingOtherExpence(String username){
     
         double finalTotalAmount = 0;
         String priceStr = priceTf.getText();
         
         double price = Double.parseDouble(priceStr);
   
     
          try{
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","root");
            System.out.println("Connected with the database successfully");
            PreparedStatement preparedStatement = connection.prepareStatement("update totalcash set amount = (?) where username =(?)");
            
           
           
           String sqlQuery = "select amount from totalcash  where username = (?)";
            PreparedStatement preparedStatement2 = connection.prepareStatement(sqlQuery);
            preparedStatement2.setString(1,username);
            ResultSet amount =  preparedStatement2.executeQuery();
            
            
            
                
                    
            while(amount.next()){
            
                double totalAmount = amount.getDouble("amount");
                finalTotalAmount = totalAmount - price;
            
            }
                   
            preparedStatement.setDouble(1,finalTotalAmount);
            preparedStatement.setString(2, username);
           
            preparedStatement.executeUpdate();
            System.out.println("Data inserted Successfully");
                   
    }catch(SQLException e){
        
        System.out.println("Error while connecting to the database");
        
    }
     
     }
         
         public void add(){
         
             insertOtherData("you");
             reducingOtherExpence("you");
             insertOtherData(user.returnUsername());
             reducingOtherExpence(user.returnUsername());
         
         }
  
        public void back() throws IOException{
            
              App.setRoot("expenses_navigation_page");
              
       /* Buttons backButton1 = new Buttons();
        backButton1.backButton();
        */
    }
    
}
