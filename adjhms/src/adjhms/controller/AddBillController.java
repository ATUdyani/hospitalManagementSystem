/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adjhms.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author User
 */
public class AddBillController implements Initializable {

    @FXML
    private TextField patientIdTxt;
    @FXML
    private TextField adIdTxt;
    @FXML
    private TextField descriptionTxt;
    @FXML
    private TextField amountTxt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void actionAdd(ActionEvent event) {
    }

    @FXML
    private void actionCancel(ActionEvent event) {
    }
    
}
