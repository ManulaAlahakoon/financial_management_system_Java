package com.mycompany.financial_management_system;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class SecondaryController {

    /*@FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }*/
    @FXML
    private TextField tf1;
    @FXML
    private TextField tf2;
    @FXML
    private Label lb;
    
     @FXML
    public void click(){
    
        String txt1 = tf1.getText();
        String txt2 = tf2.getText();
        
        lb.setText(txt2 + txt1);
    }

    
}