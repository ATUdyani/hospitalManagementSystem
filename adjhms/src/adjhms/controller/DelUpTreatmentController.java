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
public class DelUpTreatmentController implements Initializable {

    @FXML
    private TextField treatmentIdTxt;
    @FXML
    private TextField descriptionTxt;
    @FXML
    private TextField patientIdTxt;
    @FXML
    private TextField adIdTxt;
    @FXML
    private TextField billIdTxt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void actionUpdate(ActionEvent event) {
    }

    @FXML
    private void actionDelete(ActionEvent event) {
    }

    @FXML
    private void actionCancel(ActionEvent event) {
    }
    
}
