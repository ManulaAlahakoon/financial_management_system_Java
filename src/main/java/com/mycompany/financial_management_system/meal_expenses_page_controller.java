/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author user
 */
public class meal_expenses_page_controller {

    /**
     * @throws java.io.IOException
     */
    Login_page_Controller user = new Login_page_Controller();
    @FXML
    private TextField mealName;
    
    @FXML
    private TextField price;
    
    @FXML
    private TextField quantity;
    
    @FXML
    private TextArea description;
    
 public void inputMealData(String username){
     
     
         LocalDate date = LocalDate.now();
         java.sql.Date mySqlDate = java.sql.Date.valueOf( date );
         
         String meal_Name = mealName.getText();
         String meal_priceStr = price.getText();
         String meal_quantityStr = quantity.getText();
         String meal_des = description.getText();
         
        /* String str = meal_quantityStr;
         if("".equals(str)){
             
             str = "1";
         }
         */
         double meal_price = Double.parseDouble(meal_priceStr);
         int meal_quantity = Integer.parseInt(meal_quantityStr);
         double total_price = meal_price * (double)meal_quantity;
     
     try{
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","root");
            System.out.println("Connected with the database successfully");
            PreparedStatement preparedStatement = connection.prepareStatement("insert into meal values(?,?,?,?,?,?,?)");
            
            
            preparedStatement.setString(1,username);
            preparedStatement.setDate(2, mySqlDate);
            preparedStatement.setString(3,meal_Name );
            preparedStatement.setDouble(4,meal_price);
            preparedStatement.setInt(5, meal_quantity);
            preparedStatement.setDouble(6, total_price);
            preparedStatement.setString(7, meal_des);
            
            preparedStatement.executeUpdate();
            System.out.println("Data inserted Successfully");
                   
    }catch(SQLException e){
            System.out.println("Error while connecting to the database");
    }
    }
 
 
 
       
     public void reducingMealExpence(String username){
     
         double finalTotalAmount = 0;
         String meal_priceStr = price.getText();
         String meal_quantityStr = quantity.getText();
         double meal_price = Double.parseDouble(meal_priceStr);
         int meal_quantity = Integer.parseInt(meal_quantityStr);
         double total_price = meal_price * (double)meal_quantity;
     
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
                finalTotalAmount = totalAmount - total_price;
            
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
 
 inputMealData(user.returnUsername());
 reducingMealExpence(user.returnUsername());
 
 }
     
 
 public void back() throws IOException{
            
              App.setRoot("expenses_navigation_page");
              
       /* Buttons backButton1 = new Buttons();
        backButton1.backButton();
        */
    }
    
    
}
