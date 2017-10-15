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
import adjhms.model.Treatment;
import adjhms.model.TreatmentDAO;

/**
 * FXML Controller class
 *
 * @author User
 */
public class TreatmentController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField patientIdText;
    @FXML
    private TextField treatmentIdText;
    
   
    @FXML
    private TableView<Treatment> treatmentTable;
    @FXML
    private TableColumn<Treatment,String> TreatmentIdColumn;
    @FXML
    private TableColumn<Treatment,String> DescriptionColumn;
    @FXML
    private TableColumn<Treatment,String> PatientIdColumn;
    @FXML
    private TableColumn<Treatment,String> AdIdColumn;
    
   
   
    
    public static Treatment selectedTre;

    public static Treatment getTre() {
        return selectedTre;
    }

    public static void setTre(Treatment selectedTre) {
        TreatmentController.selectedTre = selectedTre;
    }
    
    @FXML
    private void addTreatment(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/adjhms/view/AddTreatment.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Insert Treatment");
        stage.show();
    }
    
    @FXML
    private void tableRefresh(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
         //Get all Employees information
            ObservableList<Treatment> patData = TreatmentDAO.searchTreatments();
            //Populate Employees on TableView
            System.out.println("refresh karamu");
            populateTreatments(patData);
    }
    @FXML
    private void searchTreatment(ActionEvent event) throws ClassNotFoundException, SQLException {
        try {
            //Get Employee information
            Treatment tre = TreatmentDAO.searchTreatment(treatmentIdText.getText(),patientIdText.getText());
            //Populate Employee on TableView and Display on TextArea
            populateAndShowTreatment(tre);
        } catch (SQLException e) {
            System.out.println("Error occurred while getting Treatment information from DB.\n" + e);
            throw e;
        }
    }
    
    //Populate Employee for TableView and Display Employee on TextArea
    private void populateAndShowTreatment(Treatment tre) throws ClassNotFoundException {
        if (tre != null) {
            populateTreatment(tre);
           
        } else {
           System.out.println("This Treatment does not exist!\n");
           populateTreatment(tre);
           Alert alert = new Alert(AlertType.INFORMATION);
           alert.setTitle("Alert");
           alert.setHeaderText("Information Alert");
           String s ="NO Search Result";
           alert.setContentText(s);
           alert.show();
        }
    }
    
    //Populate Employee
    private void populateTreatment (Treatment tre) throws ClassNotFoundException {
        //Declare and ObservableList for table view
        ObservableList<Treatment> treData = FXCollections.observableArrayList();
        //Add employee to the ObservableList
        treData.add(tre);
        //Set items to the employeeTable
        treatmentTable.setItems(treData);
    }

    
    //Search all employees
    private void searchTreatments(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            //Get all Employees information
            ObservableList<Treatment> empData = TreatmentDAO.searchTreatments();
            //Populate Employees on TableView
            System.out.println("populate karamu");
            populateTreatments(empData);
        } catch (SQLException e){
            System.out.println("Error occurred while getting Treatment information from DB.\n" + e);
            throw e;
        }
    }
    //Populate Employees for TableView
    private void populateTreatments (ObservableList<Treatment> treData) throws ClassNotFoundException {
        //Set items to the employeeTable
        System.out.println(treData.size());
        treatmentTable.setItems(treData);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        treatmentTable.setRowFactory( (TableView<Treatment> tv) -> {
        TableRow<Treatment> row = new TableRow<>();
        row.setOnMouseClicked((MouseEvent event) -> {
            if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                Treatment rowData = row.getItem();
                System.out.println(rowData);
                
                Stage st = new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/adjhms/view/PatientDelUp.fxml"));
                //Region root = null;
                TreatmentController.setTre(rowData);
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
        
        TreatmentIdColumn.setCellValueFactory(new PropertyValueFactory<Treatment,String>("treatmentId"));
        DescriptionColumn.setCellValueFactory(new PropertyValueFactory<Treatment,String>("description"));
        PatientIdColumn.setCellValueFactory(new PropertyValueFactory<Treatment,String>("patientId"));
        AdIdColumn.setCellValueFactory(new PropertyValueFactory<Treatment,String>("adId"));
        
      
        
        try {
            //Get all Employees information
            ObservableList<Treatment> patData = TreatmentDAO.searchTreatments();
            //Populate Employees on TableView
            System.out.println("populate karamu");
            populateTreatments(patData);
        } catch (SQLException e){
            System.out.println("Error occurred while getting Treatments information from DB.\n" + e);
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


