/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.financial_management_system;

import com.mycompany.financial_management_system.MySQL_Connection.CRUD;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class main_navigation_page_controller {

 
    /**
     * @throws java.io.IOException
     */
    @FXML 
    private Label totalCash;
    
    
            
    @FXML
    public void income() throws IOException {
        
                            Stage primaryStage = new Stage();
               try {
                   Parent root = FXMLLoader.load(getClass().getResource("income_page.fxml"));
                               primaryStage.setTitle("Income page");
            primaryStage.setScene(new Scene(root,600,400));
            primaryStage.show();
               } catch (IOException ex) {
                   Logger.getLogger(Registration_page_Controller.class.getName()).log(Level.SEVERE, null, ex);
               }
        
    }
    
    @FXML
    public void expenses() throws IOException {
    
    
             App.setRoot("expenses_navigation_page");
             
    }
    
   @FXML
    public String getTotalChash(String username) throws SQLException{
    
            //String cash1 = totalCash.getText();
            //double cash2 = Double.parseDouble(cash1);

           
            
         
          double totalAmount = 0;
         // double finalTotalAmount = 0;
          Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","root");
          
                      
           String sqlQuery = "select amount from totalcash  where username = (?)";
            PreparedStatement preparedStatement2 = connection.prepareStatement(sqlQuery);
            preparedStatement2.setString(1,username);
            ResultSet amount =  preparedStatement2.executeQuery();
           
                    
            while(amount.next()){
            
                 totalAmount = amount.getDouble("amount");
               // finalTotalAmount += totalAmount;
            
            }
              String txtValue = Double.toString(totalAmount);
              
               return txtValue;
                 
       
      }
    
            @FXML
    public void initialize() throws SQLException{
            
        String value = getTotalChash("ttt");
        String value = getTotalChash(user.returnUsername());
        totalCash.setText(value);
    }

    
   
    
    
}
