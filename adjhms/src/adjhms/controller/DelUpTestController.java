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
public class DelUpTestController implements Initializable {

    @FXML
    private TextField testIdTxt;
    @FXML
    private TextField testTypeTxt;
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
