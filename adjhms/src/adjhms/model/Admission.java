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
public class Admission {
    private IntegerProperty  adId;
    private StringProperty  adDate;
    private StringProperty  disDate;
    private StringProperty  patId;
    private StringProperty  wardNo;

    public Admission() {
        this.adId = new SimpleIntegerProperty(0);
        this.adDate = new SimpleStringProperty("");
        this.disDate = new SimpleStringProperty("");
        this.patId = new SimpleStringProperty("");
        this.wardNo = new SimpleStringProperty("");
    }

  
    public Integer getAdId() {
        return adId.get();
    }
    public IntegerProperty getAdIdProperty() {
        return adId;
    }
    public void setAdId(Integer adId) {
        this.adId.set(adId);
    }

    public String getAdDate() {
        return adDate.get();
    }
    public StringProperty getAdDateProperty() {
        return adDate;
    }
    public void setAdDate(String adDate) {
        this.adDate.set(adDate);
    }

    public String getDisDate() {
        return disDate.get();
    }
    public StringProperty getDisDateProperty() {
        return disDate;
    }
    public void setDisDate(String disDate) {
        this.disDate.set(disDate);
    }

    public String getPatId() {
        return patId.get();
    }
    public StringProperty getPatIdProperty() {
        return patId;
    }
    public void setPatId(String patId) {
        this.patId.set(patId);
    }

    public String getWardNo() {
        return wardNo.get();
    }
    public StringProperty getWardNoProperty() {
        return wardNo;
    }
    public void setWardNo(String wardNo) {
        this.wardNo.set(wardNo);
    }   
    
}
