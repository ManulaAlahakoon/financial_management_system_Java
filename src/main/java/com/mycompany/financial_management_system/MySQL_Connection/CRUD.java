/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.financial_management_system.MySQL_Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class CRUD {
  
/**
 *
 * @author user
     * @param name
     * @param username
     * @param password
 */
    
     public void create(String name,String username,String password){
        
        // TODO code application logic here
        //Scanner scan = new Scanner(System.in);
        
        //int rollNo = scan.nextInt();
        
        
        try{
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","root");
            System.out.println("Connected with the database successfully");
            PreparedStatement preparedStatement = connection.prepareStatement("insert into registration values(?,?,?)");
            
            
            preparedStatement.setString(1,username);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, password);
            
            preparedStatement.executeUpdate();
            System.out.println("Data inserted Successfully");
                   
    }catch(SQLException e){
            System.out.println("Error while connecting to the database");
    }
    }


}
    
    

    

