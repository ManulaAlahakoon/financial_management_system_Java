/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.financial_management_system;

import java.io.IOException;
import javafx.fxml.FXML;


/**
 *
 * @author user
 */
public class expensess_navigation_page_controller {
    
   @FXML
    public void inputMealExpenses() throws IOException {
    
        App.setRoot("meal_expenses_page");
    
    }
    
   @FXML
   public void inputTransportExpenses() throws IOException {
   
       App.setRoot("transport_expenses_page");
   }
  
   @FXML
   public void inputOtherExpenses() throws IOException {
   
       App.setRoot("other_expenses_page");
   }
    
   public void back() throws IOException{
            
              App.setRoot("main_navigation_page");
              
       /* Buttons backButton1 = new Buttons();
        backButton1.backButton();
        */
    }
}
