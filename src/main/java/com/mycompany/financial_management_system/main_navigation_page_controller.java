/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.financial_management_system;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    
   
    
    
}
