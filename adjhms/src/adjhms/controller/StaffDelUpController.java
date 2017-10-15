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
import adjhms.model.Employee;
import adjhms.model.EmployeeDAO;

/**
 * FXML Controller class
 *
 * @author User
 */
public class StaffDelUpController implements Initializable {

    @FXML
    private RadioButton maleRadio;
    @FXML
    private ToggleGroup group;
    @FXML
    private RadioButton femaleRadio;
    @FXML
    private ChoiceBox<String> designationTxt;
    //private TextField empIdTxt;
    @FXML
    private TextField firstNameTxt;
    @FXML
    private TextField lastNameTxt;
    @FXML
    private TextField nicNumberTxt;
    @FXML
    private TextField address1Txt;
    @FXML
    private TextField address2Txt;
    @FXML
    private TextField address3Txt;
    @FXML
    private TextField phoneNumberTxt;
   
    
    public Employee emp;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        emp =StaffController.getEmp();
        
        maleRadio.setToggleGroup(group);  
        femaleRadio.setToggleGroup(group);
        designationTxt.setItems(FXCollections.observableArrayList("Doctor", "Nurse","Attendent", "C"));
        
        //empIdTxt.setText(Integer.toString(emp.getEmpId()));
        firstNameTxt.setText(emp.getFirstName());
        lastNameTxt.setText(emp.getLastName());
        nicNumberTxt.setText(emp.getNicNumber());
        address1Txt.setText(emp.getAddress1());
        address2Txt.setText(emp.getAddress2());
        address3Txt.setText(emp.getAddress3());
        phoneNumberTxt.setText(emp.getContactNumber());
        designationTxt.setValue(emp.getDesignation());
        
        if("male".equals(emp.getGender())){
            group.selectToggle(maleRadio);
        }
        else{
        group.selectToggle(femaleRadio);
        }
        //salaryTxt.setText(emp.getSalary());
        
        
        
    }    
    
   
    
    @FXML
    private void updateEmployee(ActionEvent event) throws SQLException, ClassNotFoundException {
        
        System.out.println("update");
        RadioButton rb = (RadioButton) group.getSelectedToggle() ;
       
        if(!firstNameTxt.getText().equals(emp.getFirstName())){
            System.out.println("firtname");
            EmployeeDAO.updateEmp(Integer.toString(emp.getEmpId()),"FirstName",firstNameTxt.getText());
        }
        if(!lastNameTxt.getText().equals(emp.getLastName())){
            System.out.println("lastname");
            EmployeeDAO.updateEmp(Integer.toString(emp.getEmpId()),"LastName",lastNameTxt.getText());
        }
        
        if(!rb.getText().equals(emp.getGender())){
            EmployeeDAO.updateEmp(Integer.toString(emp.getEmpId()),"Gender",rb.getText());
        }
        if(!nicNumberTxt.getText().equals(emp.getNicNumber())){
            EmployeeDAO.updateEmp(Integer.toString(emp.getEmpId()),"NICNumber",nicNumberTxt.getText());
        }
        if(!address1Txt.getText().equals(emp.getAddress1())){
            EmployeeDAO.updateEmp(Integer.toString(emp.getEmpId()),"Address1",address1Txt.getText());
        }
        if(!address2Txt.getText().equals(emp.getAddress2())){
            EmployeeDAO.updateEmp(Integer.toString(emp.getEmpId()),"Address2",address2Txt.getText());
        }
        if(!address3Txt.getText().equals(emp.getAddress3())){
            EmployeeDAO.updateEmp(Integer.toString(emp.getEmpId()),"Address3",address3Txt.getText());
        }
        if(!phoneNumberTxt.getText().equals(emp.getContactNumber())){
            EmployeeDAO.updateEmp(Integer.toString(emp.getEmpId()),"ContactNumber",phoneNumberTxt.getText());
        }
        if(!designationTxt.getSelectionModel().getSelectedItem().equals(emp.getDesignation())){
            EmployeeDAO.updateEmp(Integer.toString(emp.getEmpId()),"Designation",designationTxt.getSelectionModel().getSelectedItem());
        }
     
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    private void cancelEmp(ActionEvent event) {
       ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    private void deleteEmployee(ActionEvent event) throws SQLException, ClassNotFoundException {
        Alert alert = new Alert(AlertType.CONFIRMATION, "Are you sure you want to delete?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES) {
            EmployeeDAO.deleteEmpWithId(Integer.toString(emp.getEmpId()));
        }
        
        ((Node) (event.getSource())).getScene().getWindow().hide();
        
        
    }

      
}
