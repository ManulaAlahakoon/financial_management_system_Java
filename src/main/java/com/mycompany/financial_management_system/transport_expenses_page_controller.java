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
public class transport_expenses_page_controller {
    
     @FXML
    private TextField from;
    
    @FXML
    private TextField to;
    
    @FXML
    private TextField price;
    
    @FXML
    private TextArea description;
     
    public void insertTransportData(String username){
    
     LocalDate date = LocalDate.now();
         java.sql.Date mySqlDate = java.sql.Date.valueOf( date );
         
         String t_fromStr = from.getText();
         String t_toStr = to.getText();
         String t_priceStr = price.getText();
         String t_desStr = description.getText();
         
         double t_price = Double.parseDouble(t_priceStr);
      
     try{
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","root");
            System.out.println("Connected with the database successfully");
            PreparedStatement preparedStatement = connection.prepareStatement("insert into transport values(?,?,?,?,?,?)");
            
            
            preparedStatement.setString(1,username);
            preparedStatement.setDate(2, mySqlDate);
            preparedStatement.setString(3,t_fromStr );
            preparedStatement.setString(4,t_toStr);
            preparedStatement.setDouble(5, t_price);
            preparedStatement.setString(6, t_desStr);
           
            
            preparedStatement.executeUpdate();
            System.out.println("Data inserted Successfully");
                   
    }catch(SQLException e){
            System.out.println("Error while connecting to the database");
    }
    
    
    }
    
  
      public void reducingTRansportExpence(String username){
     
         double finalTotalAmount = 0;
         String t_priceStr = price.getText();
         
         double t_price = Double.parseDouble(t_priceStr);
        // int meal_quantity = Integer.parseInt(meal_quantityStr);
        // double total_price = meal_price * (double)meal_quantity;
     
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
                finalTotalAmount = totalAmount - t_price;
            
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
    
        insertTransportData("you");
        reducingTRansportExpence("you");
        
    
    }
    
 
        public void back() throws IOException{
            
              App.setRoot("expenses_navigation_page");
              
      
    }

    
}
