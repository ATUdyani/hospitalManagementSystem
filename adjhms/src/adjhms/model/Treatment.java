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
public class Treatment {
    private IntegerProperty  treatmentId;
    private StringProperty  patientId;
    private StringProperty description;
    private StringProperty  adId;


    public Treatment() {
        this.treatmentId = new SimpleIntegerProperty(0);
        this.patientId = new SimpleStringProperty("");
        this.adId = new SimpleStringProperty("");
        this.description = new SimpleStringProperty("");
    }

    public Integer getTreatmentId() {
        return treatmentId.get();
    }
    
    public IntegerProperty getTreatmentIdProperty() {
        return treatmentId;
    }

    public void setTreatmentId(Integer TreatmentId) {
        this.treatmentId.set(TreatmentId);
    }
    
     public String getDescription() {
        return description.get();
    }
    
    public StringProperty getDescriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
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
