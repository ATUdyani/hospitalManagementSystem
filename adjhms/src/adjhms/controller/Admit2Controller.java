/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adjhms.controller;

import adjhms.model.AdmissionDAO;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author User
 */
public class Admit2Controller implements Initializable {

    @FXML
    private DatePicker dateAdmitTxt;
    @FXML
    private TextField patientIdTxt;
    @FXML
    private TextField wardNoTxt;
    private TextField consIdTxt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void actionAdd(ActionEvent event) throws SQLException, ClassNotFoundException {
        String date = dateAdmitTxt.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        int pId = Integer.parseInt(patientIdTxt.getText());
        int wNo = Integer.parseInt(wardNoTxt.getText());
        int r=AdmissionDAO.insertAd(pId,date,wNo);
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
