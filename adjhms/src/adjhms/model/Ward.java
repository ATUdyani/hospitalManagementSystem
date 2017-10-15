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
public class Ward {
    private IntegerProperty  wardNo;
    private StringProperty  wardType;
    private StringProperty  noBed;
    private StringProperty  noPatient; 

    public Ward(IntegerProperty wardNo, StringProperty wardType, StringProperty noBed, StringProperty noPatient) {
        this.wardNo = new SimpleIntegerProperty(0);;
        this.wardType = new SimpleStringProperty("");
        this.noBed = new SimpleStringProperty("");
        this.noPatient = new SimpleStringProperty("");
    }

    public Integer getWardNo() {
        return wardNo.get();
    }
    public IntegerProperty getWardNoProperty() {
        return wardNo;
    }
    public void setWardNo(Integer wardNo) {
        this.wardNo.set(wardNo);
    }

    public String getWardType() {
        return wardType.get();
    }
    public StringProperty getWardTypeProperty() {
        return wardType;
    }
    public void setWardType(String wardType) {
        this.wardType.set(wardType);
    }

    public String getNoBed() {
        return noBed.get();
    }
    public StringProperty getNoBedProperty() {
        return noBed;
    }
    public void setNoBed(String noBed) {
        this.noBed.set(noBed);
    }

    public String getNoPatient() {
        return noPatient.get();
    }
    public StringProperty getNoPatientProperty() {
        return noPatient;
    }
    public void setNoPatient(String noPatient) {
        this.noPatient.set(noPatient);
    }
    
    
    
    
}
