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
import adjhms.model.Test;
import adjhms.model.TestDAO;
import adjhms.model.Treatment;
import adjhms.model.TreatmentDAO;

/**
 * FXML Controller class
 *
 * @author User
 */
public class TestController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private TextField patientIdText;
    private TextField treatmentIdText;
    
   
    @FXML
    private TableView<Test> testTable;
    @FXML
    private TableColumn<Test,String> TestIdColumn;
    @FXML
    private TableColumn<Test,String> TestTypeColumn;
    @FXML
    private TableColumn<Test,String> PatientIdColumn;
    @FXML
    private TableColumn<Test,String> AdIdColumn;
    @FXML
    private TableColumn<Test,String> BillIdColumn;
   
   
    
    public static Test selectedTest;

    public static Test getTest() {
        return selectedTest;
    }

    public static void setTest(Test selectedTes) {
        TestController.selectedTest = selectedTes;
    }
    @FXML
    private TextField patientIdTxt;
    @FXML
    private TextField testIdTxt;
    
    @FXML
    private void addTest(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/adjhms/view/AddTest.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Insert Test");
        stage.show();
    }
    
    @FXML
    private void tableRefresh(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
         //Get all Employees information
            ObservableList<Test> patData = TestDAO.searchTests();
            //Populate Employees on TableView
            System.out.println("refresh karamu");
            populateTests(patData);
    }
    @FXML
    private void searchTest(ActionEvent event) throws ClassNotFoundException, SQLException {
        try {
            //Get Employee information
            Test tre = TestDAO.searchTest(treatmentIdText.getText(),patientIdText.getText());
            //Populate Employee on TableView and Display on TextArea
            populateAndShowTest(tre);
        } catch (SQLException e) {
            System.out.println("Error occurred while getting Treatment information from DB.\n" + e);
            throw e;
        }
    }
    
    //Populate Employee for TableView and Display Employee on TextArea
    private void populateAndShowTest(Test tre) throws ClassNotFoundException {
        if (tre != null) {
            populateTest(tre);
           
        } else {
           System.out.println("This Treatment does not exist!\n");
           populateTest(tre);
           Alert alert = new Alert(AlertType.INFORMATION);
           alert.setTitle("Alert");
           alert.setHeaderText("Information Alert");
           String s ="NO Search Result";
           alert.setContentText(s);
           alert.show();
        }
    }
    
    //Populate Employee
    private void populateTest (Test test) throws ClassNotFoundException {
        //Declare and ObservableList for table view
        ObservableList<Test> testData = FXCollections.observableArrayList();
        //Add employee to the ObservableList
        testData.add(test);
        //Set items to the employeeTable
        testTable.setItems(testData);
    }

    
    //Search all employees
    private void searchTests(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            //Get all Employees information
            ObservableList<Test> empData = TestDAO.searchTests();
            //Populate Employees on TableView
            System.out.println("populate karamu");
            populateTests(empData);
        } catch (SQLException e){
            System.out.println("Error occurred while getting Treatment information from DB.\n" + e);
            throw e;
        }
    }
    //Populate Employees for TableView
    private void populateTests (ObservableList<Test> treData) throws ClassNotFoundException {
        //Set items to the employeeTable
        System.out.println(treData.size());
        testTable.setItems(treData);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        /*  testTable.setRowFactory( (TableView<Test> tv) -> {
        TableRow<Test> row = new TableRow<>();
        row.setOnMouseClicked((MouseEvent event) -> {
        if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
        Test rowData = row.getItem();
        System.out.println(rowData);
        
        Stage st = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/adjhms/view/PatientDelUp.fxml"));
        //Region root = null;
        TestController.setTest(rowData);
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
        });*/
        
        TestIdColumn.setCellValueFactory(new PropertyValueFactory<Test,String>("testId"));
        PatientIdColumn.setCellValueFactory(new PropertyValueFactory<Test,String>("patientId"));
        TestTypeColumn.setCellValueFactory(new PropertyValueFactory<Test,String>("testType"));
        AdIdColumn.setCellValueFactory(new PropertyValueFactory<Test,String>("adId"));      
        
        try {
            //Get all Employees information
            ObservableList<Test> patData = TestDAO.searchTests();
            //Populate Employees on TableView
            System.out.println("populate karamu");
            populateTests(patData);
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


