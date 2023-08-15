/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.financial_management_system;

import com.mycompany.financial_management_system.MySQL_Connection.CheckData;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Button;


/**
 * FXML Controller class
 *
 * @author user
 */
public class Login_page_Controller implements Initializable {

    @FXML
    private TextField tf1;
    @FXML
    private TextField tf2;
    @FXML
    private Label lb;
    @FXML
    private Hyperlink link;
    @FXML 
    private Button signInBtn;
    
    /**
     *
     */
    public static String username = "";
    //public String enteredUsername;
    
    public void signIn() throws IOException, SQLException{
        //InsertData name1 = new InsertData();
        
        String enteredUsername = tf1.getText();
        String password = tf2.getText();
        String savedPassword = "";
        CheckData checkUsername = new CheckData(enteredUsername);
        
        if( checkUsername.usernameCheckResult.next()){
        
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","root");
            String sqlQuery = "select password from registration  where username = (?)";
            PreparedStatement preparedStatement2 = connection.prepareStatement(sqlQuery);
            preparedStatement2.setString(1,enteredUsername);
            ResultSet passwordResult =  preparedStatement2.executeQuery();
        
             while(passwordResult.next()){
            
                savedPassword = passwordResult.getString("password");
                
            }
             
             if(password.equals(savedPassword)){
                       
                       username = enteredUsername;
                      System.out.println("This is the user name   == "+username);
                      App.setRoot("main_navigation_page");
                      
                      
             }
        
        }
        
        //lb.setText(txt2);
        //name1.Insert(txt1);
        
      
    }
    
    @FXML
    public void openRegistrationPage() throws IOException{

       /* try {
            App.setRoot("registration_page");
        } catch (IOException ex) {
        }*//*
        Stage stage = (Stage) link.getScene().getWindow();
            stage.close();
            
            Stage primaryStage = new Stage();
               try {
                   Parent root = FXMLLoader.load(getClass().getResource("registration_page.fxml"));
                               primaryStage.setTitle("Registration page");
            primaryStage.setScene(new Scene(root,600,400));
            primaryStage.show();
               } catch (IOException ex) {
                   Logger.getLogger(Registration_page_Controller.class.getName()).log(Level.SEVERE, null, ex);
               }*/
        
        App.setRoot("registration_page");
}
    
    public String returnUsername(){
    
        return this.username;
    
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
