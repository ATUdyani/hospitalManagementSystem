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
public class Patient {
    private IntegerProperty  patientId;
    private StringProperty  firstName;
    private StringProperty  lastName;
    private StringProperty  gender;
    private StringProperty  age;
    private StringProperty  address1;
    private StringProperty  address2;
    private StringProperty  address3;
    private StringProperty  contactNumber;
    
    public Patient() {
        this.patientId = new SimpleIntegerProperty(0);
        this.firstName = new SimpleStringProperty("");
        this.lastName = new SimpleStringProperty("");
        this.gender = new SimpleStringProperty("");
        this.age = new SimpleStringProperty("");
        this.address1 = new SimpleStringProperty("");
        this.address2 = new SimpleStringProperty("");
        this.address3 = new SimpleStringProperty("");
        this.contactNumber = new SimpleStringProperty("");
    }
    
    

    public int getPatientId() {
        return patientId.get();
    }
    
    public IntegerProperty PatientIdProperty() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId.set(patientId);
    }

    
    
    public String getFirstName() {
        return firstName.get();
    }
    
     public StringProperty getFirstNameProperty() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    
    public String getLastName() {
        return lastName.get();
    }
    
     public StringProperty getLastNameProperty() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getGender() {
        return gender.get();
    }
    
    public StringProperty getGenderProperty() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender.set(gender);
    }

    public String getAge() {
        return age.get();
    }
    
    public StringProperty getAgeProperty() {
        return age;
    }

    public void setAge(String age) {
        this.age.set(age);
    }

    public String getAddress1() {
        return address1.get();
    }
    
    public StringProperty getAddress1Property() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1.set(address1);
    }
    
    public String getAddress2() {
        return address2.get();
    }
    
    public StringProperty getAddress2Property() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2.set(address2);
    }
    
    public String getAddress3() {
        return address3.get();
    }
    
    public StringProperty getAddress3Property() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3.set(address3);
    }
    
    public String getContactNumber() {
        return contactNumber.get();
    }
    
    public StringProperty getContactNumberProperty() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber.set(contactNumber);
    }
    
    
   
}
