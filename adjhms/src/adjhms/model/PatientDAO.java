/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adjhms.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import adjhms.util.DBUtil;

/**
 *
 * @author User
 */
public class PatientDAO {
    //*******************************
    //SELECT an Patient
    //*******************************
    public static Patient searchPatient (String patientId) throws SQLException, ClassNotFoundException {
        
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM patient WHERE PatientId = '"+patientId+"'";
 
        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsEmp = DBUtil.dbExecuteQuery(selectStmt);
 
            //Send ResultSet to the getPatientFromResultSet method and get patient object
            Patient patient = getPatientFromResultSet(rsEmp);
 
            //Return patient object
            return patient;
        } catch (SQLException e) {
            System.out.println("While searching an patient with " + patientId + " id, an error occurred: " + e);
            //Return exception
            throw e;
        }
    }

   //Use ResultSet from DB as parameter and set Patient Object's attributes and return patient object.
    private static Patient getPatientFromResultSet(ResultSet rs) throws SQLException
    {
        Patient pat = null;
        if (rs.next()) {
            pat = new Patient();
            pat.setPatientId(rs.getInt("PatientId"));
            pat.setFirstName(rs.getString("FirstName"));
            pat.setLastName(rs.getString("LastName"));
            pat.setGender(rs.getString("Gender"));
            pat.setAge(rs.getString("Age"));
            pat.setAddress1(rs.getString("Address1"));
            pat.setAddress2(rs.getString("Address2"));
            pat.setAddress3(rs.getString("Address3"));
            pat.setContactNumber(rs.getString("ContactNumber"));
            
        }
        return pat;
    }
    
    //*******************************
    //SELECT Patients
    //*******************************
    public static ObservableList<Patient> searchPatients () throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM patient";
 
        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsEmps = DBUtil.dbExecuteQuery(selectStmt);
 
            //Send ResultSet to the getPatientList method and get patient object
            ObservableList<Patient> empList = getPatientList(rsEmps);
            System.out.println("mn DAO ake");
            //Return patient object
            return empList;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            //Return exception
            throw e;
        }
    }

    //Select * from patients operation
    private static ObservableList<Patient> getPatientList(ResultSet rs) throws SQLException, ClassNotFoundException {
        //Declare a observable List which comprises of Patient objects
        ObservableList<Patient> patList = FXCollections.observableArrayList();
 
        while (rs.next()) {
            Patient pat = new Patient();
            pat.setPatientId(rs.getInt("PatientId"));
            pat.setFirstName(rs.getString("FirstName"));
            pat.setLastName(rs.getString("LastName"));
            pat.setGender(rs.getString("Gender"));
            pat.setAge(rs.getString("Age"));
            pat.setAddress1(rs.getString("Address1"));
            pat.setAddress2(rs.getString("Address2"));
            pat.setAddress3(rs.getString("Address3"));
            pat.setContactNumber(rs.getString("ContactNumber"));
            
            //Add patient to the ObservableList
            patList.add(pat);
        }
        //return empList (ObservableList of Patients)
        return patList;
    }
    
     //*************************************
    //UPDATE an patient
    //*************************************
    public static void updatePat (String patId,String colunmName, String arg) throws SQLException, ClassNotFoundException {
        //Declare a UPDATE statement
        String updateStmt =
                
                        "   UPDATE patient\n" +
                        "      SET "+ colunmName+ " = '" + arg + "'\n" +
                        "    WHERE PatientId = " + patId + ";\n";
                       
 
        //Execute UPDATE operation
        try {
            int res=DBUtil.dbExecuteUpdate(updateStmt);
            if(res==0){
                System.out.print("not success");
            }
            else{
                System.out.print("success");
            }
        } catch (SQLException e) {
            System.out.print("Error occurred while UPDATE Operation: " + e);
            throw e;
        }
    }
    
     //*************************************
    //DELETE an patient
    //*************************************
    public static void deletePatWithId (String patientId) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String updateStmt =
                        "   DELETE FROM patient\n" +
                        "         WHERE PatientId ="+ patientId +";\n";
 
        //Execute DELETE operation
        try {
            int res=DBUtil.dbExecuteUpdate(updateStmt);
            if(res==0){
                System.out.print("not successfully deleted");
            }
            else{
                System.out.print("successfully deleted");
            }
        } catch (SQLException e) {
            System.out.print("Error occurred while DELETE Operation: " + e);
            throw e;
        }
    }
     //*************************************
    //INSERT an patient
    //*************************************
    public static int insertpat (String FirstName, String LastName,String Gender,String Age,String Address1,String Address2,String Address3,String ContactNumber) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String updateStmt =
               
                        "INSERT INTO patient\n" +
                        "(FirstName, LastName, Gender, Age, Address1, Address2, Address3, ContactNumber)\n" +
                        "VALUES\n" +
                        "('"+FirstName+"', '"+LastName+"','"+Age+"','"+Gender+"','"+Address1+"','"+Address2+"','"+Address3+"','"+ContactNumber+"');\n";
 
        //Execute INSERT operation
        try {
            System.out.println(updateStmt);
            return DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while insert Operation: " + e);
            throw e;
        }
    }
}
