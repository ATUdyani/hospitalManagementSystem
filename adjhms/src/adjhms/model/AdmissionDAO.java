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
public class AdmissionDAO {
    //*******************************
    //SELECT an Admission
    //*******************************
    public static Admission searchAdmission(String patId) throws SQLException, ClassNotFoundException {
        String selectStmt = null;
        selectStmt = "SELECT * FROM admission WHERE PatientId='"+patId+"'";
             
            

        
        
 
        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsAd = DBUtil.dbExecuteQuery(selectStmt);
 
            //Send ResultSet to the getAdmissionFromResultSet method and get admission object
            Admission admission = getAdmissionFromResultSet(rsAd);
 
            //Return admission object
            return admission;
        } catch (SQLException e) {
            System.out.println("While searching an admission with " + patId + " id, an error occurred: " + e);
            //Return exception
            throw e;
        }
    }

   //Use ResultSet from DB as parameter and set Admission Object's attributes and return admission object.
    private static Admission getAdmissionFromResultSet(ResultSet rs) throws SQLException
    {
        Admission ad = null;
        if (rs.next()) {
            ad = new Admission();
            ad.setAdId(rs.getInt("AdId"));
            ad.setAdDate(rs.getString("DateAdmitted"));
            ad.setDisDate(rs.getString("DateDischarged"));
            ad.setPatId(rs.getString("PaitentId"));
            ad.setWardNo(rs.getString("WardNo"));

            
        }
        return ad;
    }
    
    //*******************************
    //SELECT Admission
    //*******************************
    public static ObservableList<Admission> searchAdmissions () throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM admission";
 
        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsAds = DBUtil.dbExecuteQuery(selectStmt);
 
            //Send ResultSet to the getAdmissionList method and get admission object
            ObservableList<Admission> admList = getAdmissionList(rsAds);
            System.out.println("mn DAO ake");
            //Return admission object
            return admList;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            //Return exception
            throw e;
        }
    }

    //Select * from admission operation
    private static ObservableList<Admission> getAdmissionList(ResultSet rs) throws SQLException, ClassNotFoundException {
        //Declare a observable List which comprises of Admission objects
        ObservableList<Admission> admList = FXCollections.observableArrayList();
        Admission ad=null;
        while (rs.next()) {
            ad = new Admission();
            ad.setAdId(rs.getInt("AdId"));
            ad.setAdDate(rs.getString("DateAdmitted"));
            ad.setDisDate(rs.getString("DateDischarged"));
            ad.setPatId(rs.getString("PaitentId"));
            ad.setWardNo(rs.getString("WardNo"));
            
            
            //Add admission to the ObservableList
            admList.add(ad);
        }
        //return admList (ObservableList of Admissions)
        return admList;
    }
    
     //*************************************
    //UPDATE an admission
    //*************************************
    public static void updateAd (String adId,String colunmName, String arg) throws SQLException, ClassNotFoundException {
        //Declare a UPDATE statement
        String updateStmt =
                
                        "   UPDATE admission\n" +
                        "      SET "+ colunmName+ " = '" + arg + "'\n" +
                        "    WHERE AdId = " + adId + ";\n";
                       
 
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
    //DELETE an admission
    //*************************************
    public static void deleteAdWithId (String adId) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String updateStmt =
                        "   DELETE FROM admission\n" +
                        "         WHERE AdId ="+ adId +";\n";
 
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
    //INSERT an admission
    //*************************************
    public static int insertAd (int PatId,String AdDate,int WardNo) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String updateStmt =
               
                        "INSERT INTO admission\n" +
                        "(DateAdmitted,PaitentId,WardNo)\n" +
                        "VALUES\n" +
                        "( '"+AdDate+"','"+PatId+"','"+WardNo+"');\n";
 
        //Execute INSERT operation
        try {
            System.out.println(updateStmt);
            return DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while insert Operation: " + e);
            throw e;
        }
    }
    
        public static int updateDis (int adId,String DateDischarged) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String updateStmt =
               
                    
                        "   UPDATE admission\n" +
                        "      SET DateDischarged = '" + DateDischarged + "'\n" +
                        "    WHERE AdId = " + adId + ";\n";
 
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
