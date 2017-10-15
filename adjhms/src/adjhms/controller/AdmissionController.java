/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.patdata
 */
package adjhms.controller;

import adjhms.model.Admission;
import adjhms.model.AdmissionDAO;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class AdmissionController implements Initializable {

    @FXML
    private TableColumn<Admission,String> adIdColumn;
    @FXML
    private TableColumn<Admission,String> patientIdColumn;
    @FXML
    private TableColumn<Admission,String> adDateColumn;
    @FXML
    private TableColumn<Admission,String> disDateColumn;
    @FXML
    private TableColumn<Admission,String> wardNoColumn;
    @FXML
    private TextField patientIdTxt;
    @FXML
    private TableView<Admission> admissionTable;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        adIdColumn.setCellValueFactory(new PropertyValueFactory<Admission,String>("adId"));        
        patientIdColumn.setCellValueFactory(new PropertyValueFactory<Admission,String>("patId"));
        adDateColumn.setCellValueFactory(new PropertyValueFactory<Admission,String>("adDate"));
        disDateColumn.setCellValueFactory(new PropertyValueFactory<Admission,String>("disDate"));
        wardNoColumn.setCellValueFactory(new PropertyValueFactory<Admission,String>("wardNo"));
        
         try {
            //Get all Employees information
            ObservableList<Admission> patData = AdmissionDAO.searchAdmissions();
            //Populate Employees on TableView
            System.out.println("populate karamu");
            populateAdmissions(patData);
        } catch (SQLException e){
            System.out.println("Error occurred while getting employees information from DB.\n" + e);
            try {
                throw e;
            } catch (SQLException ex) {
                Logger.getLogger(PatientController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PatientController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    


    @FXML
    private void actionAll(ActionEvent event) {
    }

    @FXML
    private void actionAdmit(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/adjhms/view/Admit2.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Admit");
        stage.show();
    }

    @FXML
    private void actionDischarge(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/adjhms/view/Discharge.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Discharge");
        stage.show();
    }
    
    @FXML
    private void tableRefresh(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
         //Get all Employees information
            ObservableList<Admission> adData = AdmissionDAO.searchAdmissions();
            //Populate Employees on TableView
            System.out.println("refresh karamu");
            populateAdmissions(adData);
    }
    @FXML
    private void searchAdmission(ActionEvent event) throws ClassNotFoundException, SQLException {
        try {
            //Get Employee information
            Admission ad = AdmissionDAO.searchAdmission(patientIdTxt.getText());
            //Populate Employee on TableView and Display on TextArea
            populateAndShowAdmission(ad);
        } catch (SQLException e) {
            System.out.println("Error occurred while getting employee information from DB.\n" + e);
            throw e;
        }
    }
    
    //Populate Employee for TableView and Display Employee on TextArea
    private void populateAndShowAdmission(Admission ad) throws ClassNotFoundException {
        if (ad != null) {
            populateAdmission(ad);
           
        } else {
           System.out.println("This patient does not exist!\n");
           populateAdmission(ad);
           Alert alert = new Alert(AlertType.INFORMATION);
           alert.setTitle("Alert");
           alert.setHeaderText("Information Alert");
           String s ="NO Search Result";
           alert.setContentText(s);
           alert.show();
        }
    }
    
    //Populate Employee
    private void populateAdmission (Admission ad) throws ClassNotFoundException {
        //Declare and ObservableList for table view
        ObservableList<Admission> adData = FXCollections.observableArrayList();
        //Add employee to the ObservableList
        adData.add(ad);
        //Set items to the employeeTable
        admissionTable.setItems(adData);
    }

    
    //Search all employees
    private void searchAdmissions(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            //Get all Employees information
            ObservableList<Admission> empData = AdmissionDAO.searchAdmissions();
            //Populate Employees on TableView
            System.out.println("populate karamu");
            populateAdmissions(empData);
        } catch (SQLException e){
            System.out.println("Error occurred while getting employees information from DB.\n" + e);
            throw e;
        }
    }
    //Populate Employees for TableView
    private void populateAdmissions (ObservableList<Admission> adData) throws ClassNotFoundException {
        //Set items to the employeeTable
        System.out.println(adData.size());
        admissionTable.setItems(adData);
    }
    
}
