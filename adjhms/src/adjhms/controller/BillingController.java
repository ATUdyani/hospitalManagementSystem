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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class BillingController implements Initializable {

    @FXML
    private TableColumn<?, ?> billIdColumn;
    @FXML
    private TableColumn<?, ?> patientIdColumn;
    @FXML
    private TableColumn<?, ?> adIdColumn;
    @FXML
    private TableColumn<?, ?> descriptionColumn;
    @FXML
    private TableColumn<?, ?> amountColumn;
    @FXML
    private TextField patientIdTxt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addBill(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/adjhms/view/AddBill.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Billing");
        stage.show();
        
    }

    @FXML
    private void searchBill(ActionEvent event) {
    }

    @FXML
    private void refreshBill(ActionEvent event) {
    }

    @FXML
    private void totalBill(ActionEvent event) {
    }
    
}
