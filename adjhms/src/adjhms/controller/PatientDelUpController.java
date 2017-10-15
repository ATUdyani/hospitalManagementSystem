/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adjhms.controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import adjhms.model.PatientDAO;
import adjhms.model.Patient;

/**
 * FXML Controller class
 *
 * @author User
 */
public class PatientDelUpController implements Initializable {

    @FXML
    private RadioButton maleRadio;
    @FXML
    private ToggleGroup group;
    @FXML
    private RadioButton femaleRadio;
   
    //private TextField patientIdTxt;
    @FXML
    private TextField firstNameTxt;
    @FXML
    private TextField lastNameTxt;
    @FXML
    private TextField ageTxt;
    @FXML
    private TextField address1Txt;
    @FXML
    private TextField address2Txt;
    @FXML
    private TextField address3Txt;
    @FXML
    private TextField phoneNumberTxt;
   
    
    public Patient pat;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        pat =PatientController.getPat();
        
        maleRadio.setToggleGroup(group);  
        femaleRadio.setToggleGroup(group);
        
        //patientIdTxt.setText(Integer.toString(pat.getPatientId()));
        firstNameTxt.setText(pat.getFirstName());
        lastNameTxt.setText(pat.getLastName());
        ageTxt.setText(pat.getAge());
        address1Txt.setText(pat.getAddress1());
        address2Txt.setText(pat.getAddress2());
        address3Txt.setText(pat.getAddress3());
        phoneNumberTxt.setText(pat.getContactNumber());
      
        
        if("male".equals(pat.getGender())){
            group.selectToggle(maleRadio);
        }
        else{
        group.selectToggle(femaleRadio);
        }
      
        
        
        
    }    
    
   
    
    @FXML
    private void updatePatient(ActionEvent event) throws SQLException, ClassNotFoundException {
        
        System.out.println("update");
        RadioButton rb = (RadioButton) group.getSelectedToggle() ;
       
        if(!firstNameTxt.getText().equals(pat.getFirstName())){
            System.out.println("firtname");
            PatientDAO.updatePat(Integer.toString(pat.getPatientId()),"FirstName",firstNameTxt.getText());
        }
        if(!lastNameTxt.getText().equals(pat.getLastName())){
            System.out.println("lastname");
            PatientDAO.updatePat(Integer.toString(pat.getPatientId()),"LastName",lastNameTxt.getText());
        }
        
        if(!rb.getText().equals(pat.getGender())){
            PatientDAO.updatePat(Integer.toString(pat.getPatientId()),"Gender",rb.getText());
        }
        if(!ageTxt.getText().equals(pat.getAge())){
            PatientDAO.updatePat(Integer.toString(pat.getPatientId()),"Age",ageTxt.getText());
        }
        if(!address1Txt.getText().equals(pat.getAddress1())){
            PatientDAO.updatePat(Integer.toString(pat.getPatientId()),"Address1",address1Txt.getText());
        }
        if(!address2Txt.getText().equals(pat.getAddress2())){
            PatientDAO.updatePat(Integer.toString(pat.getPatientId()),"Address2",address2Txt.getText());
        }
        if(!address3Txt.getText().equals(pat.getAddress3())){
            PatientDAO.updatePat(Integer.toString(pat.getPatientId()),"Address3",address3Txt.getText());
        }
        if(!phoneNumberTxt.getText().equals(pat.getContactNumber())){
            PatientDAO.updatePat(Integer.toString(pat.getPatientId()),"ContactNumber",phoneNumberTxt.getText());
        }
        
        ((Node) (event.getSource())).getScene().getWindow().hide();
        
     
    }

    @FXML
    private void cancel(ActionEvent event) {
       ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    private void deletePatient(ActionEvent event) throws SQLException, ClassNotFoundException {
        Alert alert = new Alert(AlertType.CONFIRMATION, "Are you sure you want to delete?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES) {
            PatientDAO.deletePatWithId(Integer.toString(pat.getPatientId()));
        }
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

      
}
