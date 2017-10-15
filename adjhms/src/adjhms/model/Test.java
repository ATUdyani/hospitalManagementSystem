/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adjhms.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author User
 */
public class Test {
    private IntegerProperty  testId;
    private StringProperty  patientId;
    private StringProperty  testType;
    private StringProperty  adId;
    

    public Test() {
        this.testId = new SimpleIntegerProperty(0);
        this.patientId = new SimpleStringProperty("");
        this.testType = new SimpleStringProperty("");
        this.adId = new SimpleStringProperty("");
        
    }

    public Integer getTestId() {
        return testId.get();
    }
    public IntegerProperty getTestIdProperty() {
        return testId;
    }
    public void setTestId(Integer TestId) {
        this.testId.set(TestId);
    }

    public String getPatientId() {
        return patientId.get();
    }
    public StringProperty getPatientIdProperty() {
        return patientId;
    }
    public void setPatientId(String patientId) {
        this.patientId.set(patientId);
    }

    public String getTestType() {
        return testType.get();
    }
    public StringProperty getTestTypeProperty() {
        return testType;
    }
    public void setTestType(String TestType) {
        this.testType.set(TestType);
    }

    public String getAdId() {
        return adId.get();
    }
    public StringProperty getAdIdProperty() {
        return adId;
    }
    public void setAdId(String adId) {
        this.adId.set(adId);
    }  
    
}
