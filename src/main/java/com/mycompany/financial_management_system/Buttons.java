/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.financial_management_system;

import com.mycompany.financial_management_system.MySQL_Connection.CRUD;
import com.mycompany.financial_management_system.MySQL_Connection.CheckData;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author user
 */

public class Buttons {
    
    
    
    public void backButton() throws IOException{
    
        
        App.setRoot("expenses_navigation_page");
    
    
    }
    

       public void incomeAddButton(String username,double income) throws IOException, SQLException{
             
           LocalDate date = LocalDate.now();
           java.sql.Date mySqlDate = java.sql.Date.valueOf( date );
        try{
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","root");
            System.out.println("Connected with the database successfully");
            PreparedStatement preparedStatement = connection.prepareStatement("insert into income values(?,?,?)");
            
            
            preparedStatement.setString(1,username);
            preparedStatement.setDouble(2, income);
            preparedStatement.setDate(3, mySqlDate);
            
            preparedStatement.executeUpdate();
            System.out.println("Data inserted Successfully");
            
                    
         CheckData usernameCheckResult1 = new CheckData();
             usernameCheckResult1.CheckUsernameInCash(username);
       
             if(usernameCheckResult1.usernameCheckInCash.next()){
                 
                  System.out.println("Cannot");
                             
           CRUD change = new CRUD();
           double newValue = change.totalCashChanging(username,income);
                  
             }else{
             
                  Buttons input = new Buttons();
                  input.insertTotalCash(username,income);
                 
             
             
        }      
            
            
            
                       
            
            
                   
    }catch(SQLException e){
        
        System.out.println("Error while connecting to the database button");
        
    }
            
            
    }

       public void insertTotalCash(String username,double amount) throws IOException, SQLException{
           
           try{
                 Connection connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","root");
                 PreparedStatement preparedStatement2 = connection1.prepareStatement("insert into totalcash values(?,?)");
                 preparedStatement2.setString(1,username);
                 preparedStatement2.setDouble(2,amount);
                 preparedStatement2.executeUpdate();
                 System.out.println("Insert cash successfully");
                    }catch(SQLException e){
        
        System.out.println("Error while connecting to the database button");
        
    }

       }

}
  
        
        
        
