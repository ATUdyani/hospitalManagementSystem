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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author User
 */
public class WardController implements Initializable {

    @FXML
    private TableColumn<?, ?> wardIdColumn;
    @FXML
    private TableColumn<?, ?> wardTypeColumn;
    @FXML
    private TableColumn<?, ?> noBedColumn;
    @FXML
    private TableColumn<?, ?> noPatientColumn;
    @FXML
    private TextField wardNoTxt;
    @FXML
    private TextField wardTypeTxt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void searchWard(ActionEvent event) {
    }

    @FXML
    private void refreshWard(ActionEvent event) {
    }

    @FXML
    private void addWard(ActionEvent event) {
    }
    
}
