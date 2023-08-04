/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.financial_management_system;

import java.io.IOException;
import java.net.URL;
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

    
    
    public void signIn() throws IOException{
        InsertData name1 = new InsertData();
        
        String txt1 = tf1.getText();
        String txt2 = tf2.getText();
        
        lb.setText(txt2);
        name1.Insert(txt1);
        
        App.setRoot("main_navigation_page");
    }
    
    @FXML
    public void openRegistrationPage(){

       /* try {
            App.setRoot("registration_page");
        } catch (IOException ex) {
        }*/
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
               }
}
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
