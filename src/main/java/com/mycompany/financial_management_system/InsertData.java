/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.financial_management_system;

import java.sql.*;
import java.util.Scanner;
/**
 *
 * @author user
 */
public class InsertData {
    
     public void Insert(String txt){
        
        // TODO code application logic here
        //Scanner scan = new Scanner(System.in);
        
        //int rollNo = scan.nextInt();
        
        
        try{
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","root");
            System.out.println("Connected with the database successfully");
            PreparedStatement preparedStatement = connection.prepareStatement("insert into student values(?,?,?,?)");
            
            preparedStatement.setInt(1, 4);
            preparedStatement.setString(2,txt);
            preparedStatement.setString(3, "Engineering Technology");
            preparedStatement.setString(4, "Colombo");
            
            preparedStatement.executeUpdate();
            System.out.println("Data inserted Successfully");
                   
    }catch(SQLException e){
            System.out.println("Error while connecting to the database");
    }
    }
    
    
}
