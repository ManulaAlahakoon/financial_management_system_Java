/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.financial_management_system.MySQL_Connection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class CheckData {
    
    public ResultSet usernameCheckResult;
    public ResultSet usernameCheckInTotalCash;
    
    public CheckData(){
    }
            
    public  CheckData(String username)throws  SQLException{
        
           
         try{
            
            String sqlQuery = "select username from registration  where username = (?)";
            
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","root");
            System.out.println("Connected with the database successfully");
                
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1,username);
            ResultSet usernameCheckResultSet =  preparedStatement.executeQuery();
            
            
            
            usernameCheckResult = usernameCheckResultSet; 
            
                        
            }catch(SQLException e){
                    
                System.out.println("Error while connecting to the database");    
                    
                    }
    
           // return passwordCheckResult;
            
        
    }
    
    public void CheckUsernameInCash(String username) throws SQLException{
    
    
              
         try{
            
            String sqlQuery = "select username from totalcash  where username = (?)";
            
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","root");
            System.out.println("Connected with the database successfully");
                
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1,username);
            ResultSet usernameCheckResultSet =  preparedStatement.executeQuery();
            
            
            
            usernameCheckInTotalCash = usernameCheckResultSet; 
            
                        
            }catch(SQLException e){
                    
                System.out.println("Error while connecting to the database");    
                    
                    }
    
    }


    
}
