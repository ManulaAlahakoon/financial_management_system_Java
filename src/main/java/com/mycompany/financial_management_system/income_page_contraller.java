/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.financial_management_system;


import com.mycompany.financial_management_system.MySQL_Connection.CheckData;
import java.io.IOException;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *FXML Controller class
 * @author user
 */
public class income_page_contraller {
    
     Login_page_Controller user = new Login_page_Controller();
    

      @FXML
      private TextField incomeTf;
            
    
    public void add() throws IOException, SQLException{
    
        String income2 = incomeTf.getText();
        double income1 = Double.parseDouble(income2);
        Buttons addIncome = new Buttons();
        
        addIncome.incomeAddButton(user.returnUsername(),income1);
         
    
        
      // main_navigation_page_controller addTotalCash = new main_navigation_page_controller();
       //addTotalCash.changeTotalChash("you3");
    
    }
    
    public void back() throws IOException{
    
        
                App.setRoot("main_navigation_page");

    }
    
}
