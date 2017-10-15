/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adjhms.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class HomeController implements Initializable {

    @FXML
    private AnchorPane homePane;
    @FXML
    private Button homePatient;
    @FXML
    private Button homeStaff;
    @FXML
    private Button homeTreatment;
    @FXML
    private Button homeTest;
    @FXML
    private Button homeBilling;
    @FXML
    private Button homeLogout;
    @FXML
    private Button homeAdmit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void actionPatient(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/adjhms/view/Patient.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Patient");
        stage.show();
    }
    
    @FXML
    private void actionWard(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/adjhms/view/Ward.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Ward");
        stage.show();
    }

    @FXML
    private void actionStaff(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/adjhms/view/Staff.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Staff");
        stage.show();
    }

    @FXML
    private void actionTreatment(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/adjhms/view/Treatment.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Treatment");
        stage.show();
    }
    
    @FXML
    private void actionAdmit(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/adjhms/view/Admission.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Admit");
        stage.show();
    }
    
    
    
    @FXML
    private void actionTest(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/adjhms/view/Test.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Test");
        stage.show();
    }

    @FXML
    private void actionBilling(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/adjhms/view/Billing.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Billing");
        stage.show();
    }

    @FXML
    private void actionLogout(ActionEvent event) throws IOException{
        /*AnchorPane pane = FXMLLoader.load(getClass().getResource("/adjhms/view/StaffReg.fxml"));
        homePane.getChildren().setAll(pane);*/
    }
    
}
