/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.financial_management_system;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


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
    public void click(){
        InsertData name1 = new InsertData();
        
        String txt1 = tf1.getText();
        String txt2 = tf2.getText();
        
        lb.setText(txt2);
        name1.Insert(txt1);
    }
    
    @FXML
    public void openRegistrationPage(){

        try {
            App.setRoot("registration_page");
        } catch (IOException ex) {
        }
}
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
