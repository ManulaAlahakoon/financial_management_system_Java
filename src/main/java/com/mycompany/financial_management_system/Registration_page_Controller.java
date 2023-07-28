/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.financial_management_system;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author user
 */
public class Registration_page_Controller implements Initializable {

    /**
     * Initializes the controller class.
     *
     */
    
    @FXML
    private TextField txt1;
    
    @FXML
    private TextField txt2;
    
    @FXML
    private TextField txt3;
    
    @FXML
    private TextField txt4;
    
    public void check(){
         
        String name = txt1.getText();
        String username = txt2.getText();
        String password = txt3.getText();
        String re_password = txt4.getText();
        
        System.out.println(password);
    
    }
    
    
    
   

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
  
}
