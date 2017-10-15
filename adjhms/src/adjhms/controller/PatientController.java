/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adjhms.controller;

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
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import adjhms.model.Patient;
import adjhms.model.PatientDAO;

/**
 * FXML Controller class
 *
 * @author User
 */
public class PatientController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField patientIdText;
    
   
    @FXML
    private TableView<Patient> patientTable;
    @FXML
    private TableColumn<Patient,String> PatientIdColumn;
    @FXML
    private TableColumn<Patient,String> FirstNameColumn;
    @FXML
    private TableColumn<Patient,String> LastNameColumn;
    @FXML
    private TableColumn<Patient,String> GenderColumn;
    @FXML
    private TableColumn<Patient,String> AgeColumn;
    @FXML
    private TableColumn<Patient,String> Address1Column;
    @FXML
    private TableColumn<Patient,String> Address2Column;
    @FXML
    private TableColumn<Patient,String> Address3Column;
    @FXML
    private TableColumn<Patient,String> ContactNumberColumn;
    
   
    
    public static Patient selectedPat;

    public static Patient getPat() {
        return selectedPat;
    }

    public static void setPat(Patient selectedPat) {
        PatientController.selectedPat = selectedPat;
    }
    
    @FXML
    private void addPatient(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/adjhms/view/PatientReg.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Add");
        stage.show();
    }
    
    @FXML
    private void tableRefresh(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
         //Get all Employees information
            ObservableList<Patient> patData = PatientDAO.searchPatients();
            //Populate Employees on TableView
            System.out.println("refresh karamu");
            populatePatients(patData);
    }
    @FXML
    private void searchPatient(ActionEvent event) throws ClassNotFoundException, SQLException {
        try {
            //Get Employee information
            Patient pat = PatientDAO.searchPatient(patientIdText.getText());
            //Populate Employee on TableView and Display on TextArea
            populateAndShowPatient(pat);
        } catch (SQLException e) {
            System.out.println("Error occurred while getting employee information from DB.\n" + e);
            throw e;
        }
    }
    
    //Populate Employee for TableView and Display Employee on TextArea
    private void populateAndShowPatient(Patient pat) throws ClassNotFoundException {
        if (pat != null) {
            populatePatient(pat);
           
        } else {
           System.out.println("This patient does not exist!\n");
           populatePatient(pat);
           Alert alert = new Alert(AlertType.INFORMATION);
           alert.setTitle("Alert");
           alert.setHeaderText("Information Alert");
           String s ="NO Search Result";
           alert.setContentText(s);
           alert.show();
        }
    }
    
    //Populate Employee
    private void populatePatient (Patient pat) throws ClassNotFoundException {
        //Declare and ObservableList for table view
        ObservableList<Patient> patData = FXCollections.observableArrayList();
        //Add employee to the ObservableList
        patData.add(pat);
        //Set items to the employeeTable
        patientTable.setItems(patData);
    }

    
    //Search all employees
    @FXML
    private void searchpatients(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            //Get all Employees information
            ObservableList<Patient> empData = PatientDAO.searchPatients();
            //Populate Employees on TableView
            System.out.println("populate karamu");
            populatePatients(empData);
        } catch (SQLException e){
            System.out.println("Error occurred while getting employees information from DB.\n" + e);
            throw e;
        }
    }
    //Populate Employees for TableView
    private void populatePatients (ObservableList<Patient> patData) throws ClassNotFoundException {
        //Set items to the employeeTable
        System.out.println(patData.size());
        patientTable.setItems(patData);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        patientTable.setRowFactory( (TableView<Patient> tv) -> {
        TableRow<Patient> row = new TableRow<>();
        row.setOnMouseClicked((MouseEvent event) -> {
            if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                Patient rowData = row.getItem();
                System.out.println(rowData);
                
                Stage st = new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/adjhms/view/PatientDelUp.fxml"));
                //Region root = null;
                PatientController.setPat(rowData);
                try {
                    loader.load();
                } catch (IOException ex) {
                    Logger.getLogger(PatientController.class.getName()).log(Level.SEVERE, null, ex);
                }
               
                
                
                Parent p = loader.getRoot();
                
                Scene scene = new Scene(p);
                st.setScene(scene);


                st.showAndWait();
                    }
        });
        return row ;
        });
        PatientIdColumn.setCellValueFactory(new PropertyValueFactory<Patient,String>("patientId"));
        FirstNameColumn.setCellValueFactory(new PropertyValueFactory<Patient,String>("firstName"));
        LastNameColumn.setCellValueFactory(new PropertyValueFactory<Patient,String>("lastName"));
        GenderColumn.setCellValueFactory(new PropertyValueFactory<Patient,String>("gender"));
        AgeColumn.setCellValueFactory(new PropertyValueFactory<Patient,String>("age"));
        Address1Column.setCellValueFactory(new PropertyValueFactory<Patient,String>("address1"));
        Address2Column.setCellValueFactory(new PropertyValueFactory<Patient,String>("address2"));
        Address3Column.setCellValueFactory(new PropertyValueFactory<Patient,String>("address3"));
        ContactNumberColumn.setCellValueFactory(new PropertyValueFactory<Patient,String>("contactNumber"));
       
        
        try {
            //Get all Employees information
            ObservableList<Patient> patData = PatientDAO.searchPatients();
            //Populate Employees on TableView
            System.out.println("populate karamu");
            populatePatients(patData);
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
        
        
        //EmpIdColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("empId"));
        
        /*
        FirstNameColumn.setCellValueFactory(cellData -> cellData.getValue().FirstNameProperty());
        LastNameColumn.setCellValueFactory(cellData -> cellData.getValue().LastNameProperty());
        SexColumn.setCellValueFactory(cellData -> cellData.getValue().SexProperty());
        Address1Column.setCellValueFactory(cellData -> cellData.getValue().Address1Property());
        Address2Column.setCellValueFactory(cellData -> cellData.getValue().Address2Property());
        Address3Column.setCellValueFactory(cellData -> cellData.getValue().Address3Property());
        ContactNumberColumn.setCellValueFactory(cellData -> cellData.getValue().ContactNumberProperty());
        */
    }    
    
}
