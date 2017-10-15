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
public class TreatmentDAO {
    //*******************************
    //SELECT an Treatment
    //*******************************
    public static Treatment searchTreatment (String nicN,String patientId) throws SQLException, ClassNotFoundException {
        
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM treatment WHERE NIC_Number LIKE '%"+nicN+"%' OR patientId='"+patientId+"'";
 
        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsTre = DBUtil.dbExecuteQuery(selectStmt);
 
            //Send ResultSet to the getTreatmentFromResultSet method and get treatment object
            Treatment treatment = getTreatmentFromResultSet(rsTre);
 
            //Return treatment object
            return treatment;
        } catch (SQLException e) {
            System.out.println("While searching an treatment with " + patientId + " id, an error occurred: " + e);
            //Return exception
            throw e;
        }
    }

   //Use ResultSet from DB as parameter and set Treatment Object's attributes and return treatment object.
    private static Treatment getTreatmentFromResultSet(ResultSet rs) throws SQLException
    {
        Treatment tre = null;
        if (rs.next()) {
            tre = new Treatment();
            tre.setTreatmentId(rs.getInt("TreId"));
            tre.setPatientId(rs.getString("PatientId"));
            tre.setAdId(rs.getString("AdId"));
            tre.setDescription(rs.getString("Description"));
            
        }
        return tre;
    }
    
    //*******************************
    //SELECT Treatments
    //*******************************
    public static ObservableList<Treatment> searchTreatments () throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM treatment";
 
        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsTres = DBUtil.dbExecuteQuery(selectStmt);
 
            //Send ResultSet to the getTreatmentList method and get treatment object
            ObservableList<Treatment> treList = getTreatmentList(rsTres);
            System.out.println("mn DAO ake");
            //Return treatment object
            return treList;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            //Return exception
            throw e;
        }
    }

    //Select * from treatments operation
    private static ObservableList<Treatment> getTreatmentList(ResultSet rs) throws SQLException, ClassNotFoundException {
        //Declare a observable List which comprises of Treatment objects
        ObservableList<Treatment> treList = FXCollections.observableArrayList();
 
        while (rs.next()) {
            Treatment tre = new Treatment();
            tre.setTreatmentId(rs.getInt("TreatmentId"));
            tre.setPatientId(rs.getString("PatientId"));
            tre.setAdId(rs.getString("AdId"));
            tre.setDescription(rs.getString("Description"));
            
            
            //Add treatment to the ObservableList
            treList.add(tre);
        }
        //return TreList (ObservableList of Treatments)
        return treList;
    }
    
     //*************************************
    //UPDATE an treatment
    //*************************************
    public static void updateTre (String treId,String colunmName, String arg) throws SQLException, ClassNotFoundException {
        //Declare a UPDATE statement
        String updateStmt =
                
                        "   UPDATE treatment\n" +
                        "      SET "+ colunmName+ " = '" + arg + "'\n" +
                        "    WHERE TreId = " + treId + ";\n";
                       
 
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
    //DELETE an treatment
    //*************************************
    public static void deleteTreWithId (String treId) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String updateStmt =
                        "   DELETE FROM treatment\n" +
                        "         WHERE TreId ="+treId +";\n";
 
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
    //INSERT an treatment
    //*************************************
    public static int insertTre (int PatientId, int AdId,String Description) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String updateStmt =
               
                        "INSERT INTO treatment\n" +
                        "( PatientId, AdId,Description)\n" +
                        "VALUES\n" +
                        "('"+PatientId+"', '"+AdId+"','"+Description+"');\n";
 
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
