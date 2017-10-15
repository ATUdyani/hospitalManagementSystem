/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adjhms.controller;

import adjhms.model.TreatmentDAO;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author User
 */
public class AddTreatmentController implements Initializable {

    @FXML
    private TextField descriptionTxt;
    @FXML
    private TextField patientIdTxt;
    @FXML
    private TextField adIdTxt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
     @FXML
    private void actionAdd(ActionEvent event) throws SQLException, ClassNotFoundException {
        int PatientId = Integer.parseInt(patientIdTxt.getText());
        int adId = Integer.parseInt(adIdTxt.getText());
        
        int r=TreatmentDAO.insertTre(PatientId,adId,descriptionTxt.getText());
        if(r==0){
            System.out.println("insert kare ne");
        }
        else{
            System.out.println("insert kara");
        }
        
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    private void actionCancel(ActionEvent event) {
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }
    
}

    

