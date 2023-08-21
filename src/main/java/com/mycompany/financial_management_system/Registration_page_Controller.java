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
import com.mycompany.financial_management_system.MySQL_Connection.CRUD;
import com.mycompany.financial_management_system.MySQL_Connection.CheckData;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
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
    
    @FXML
    private Label labelMessage;
    
    @FXML
    private Button registerBtn;
    
  
    
    public void check() throws SQLException, IOException{
         
    
        String name = txt1.getText();
        String username = txt2.getText();
        String password = txt3.getText();
        String re_password = txt4.getText();
        CheckData usernameCheckResult = new CheckData(username);
        
        if(!"".equals(name) && !"".equals(username) && !"".equals(password)){ 
            
        if( usernameCheckResult.usernameCheckResult.next()){
            
            labelMessage.setText("Username already taken.");
            
        }else{
            labelMessage.setText("");
            if(password.equals(re_password) && !"".equals(password)){
                CRUD newMember = new CRUD();
                newMember.create(name,username,password);
                
                App.setRoot("login_page");
                
                /*
                Stage stage = (Stage) registerBtn.getScene().getWindow();
                stage.close();
                
                Stage primaryStage = new Stage();
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("login_page.fxml"));
                    primaryStage.setTitle("Login page");
                    primaryStage.setScene(new Scene(root,600,400));
                    primaryStage.show();
                } catch (IOException ex) {
                    Logger.getLogger(Registration_page_Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
                */
                
                
                
            }else{
                labelMessage.setText("Write the same password correctly.");
            }
            
        }
        }else{
        
            labelMessage.setText("Fill all the textfields.");
        
        }
    }
  
 

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


  
}
