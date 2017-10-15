/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adjhms.controller;

import adjhms.model.PatientDAO;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author User
 */
public class PatientRegController implements Initializable {

    @FXML
    private TextField firstNameTxt;
    @FXML
    private TextField lastNameTxt;
    @FXML
    private RadioButton maleRadio;
    @FXML
    private ToggleGroup group;
    @FXML
    private RadioButton femaleRadio;
    @FXML
    private TextField ageTxt;
    @FXML
    private TextField address1Txt;
    @FXML
    private TextField address2Txt;
    @FXML
    private TextField address3Txt;
    @FXML
    private TextField contactNoTxt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void actionSave(ActionEvent event) throws SQLException, ClassNotFoundException {
        RadioButton rb = (RadioButton) group.getSelectedToggle() ;
        
        int r=PatientDAO.insertpat(firstNameTxt.getText(),lastNameTxt.getText(),ageTxt.getText(),rb.getText(),address1Txt.getText(),address2Txt.getText(),address3Txt.getText(),contactNoTxt.getText());
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
