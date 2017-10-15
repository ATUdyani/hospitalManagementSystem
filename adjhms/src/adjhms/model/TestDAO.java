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
public class TestDAO {
    //*******************************
    //SELECT an Test
    //*******************************
    public static Test searchTest (String admissionId,String patientId) throws SQLException, ClassNotFoundException {
        
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM treatment WHERE patientId='"+patientId+"'";
 
        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsTes = DBUtil.dbExecuteQuery(selectStmt);
 
            //Send ResultSet to the getTestFromResultSet method and get test object
            Test test = getTestFromResultSet(rsTes);
 
            //Return test object
            return test;
        } catch (SQLException e) {
            System.out.println("While searching an treatment with " + patientId + " id, an error occurred: " + e);
            //Return exception
            throw e;
        }
    }

   //Use ResultSet from DB as parameter and set Test Object's attributes and return test object.
    private static Test getTestFromResultSet(ResultSet rs) throws SQLException
    {
        Test test = null;
        if (rs.next()) {
            test = new Test();
            test.setTestId(rs.getInt("TestId"));
            test.setPatientId(rs.getString("PatientId"));
            test.setTestType(rs.getString("TestType"));
            test.setAdId(rs.getString("AdId"));
        }
        return test;
    }
    
    //*******************************
    //SELECT Tests
    //*******************************
    public static ObservableList<Test> searchTests () throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM test";
 
        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsTes = DBUtil.dbExecuteQuery(selectStmt);
 
            //Send ResultSet to the getTestList method and get test object
            ObservableList<Test> tesList = getTestList(rsTes);
            System.out.println("mn DAO ake");
            //Return test object
            return tesList;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            //Return exception
            throw e;
        }
    }

    //Select * from tests operation
    private static ObservableList<Test> getTestList(ResultSet rs) throws SQLException, ClassNotFoundException {
        //Declare a observable List which comprises of Test objects
        ObservableList<Test> tesList = FXCollections.observableArrayList();
 
        while (rs.next()) {
            Test tes = new Test();
            tes.setTestId(rs.getInt("TestId"));
            tes.setPatientId(rs.getString("PatientId"));
            tes.setTestType(rs.getString("TestType"));
            tes.setAdId(rs.getString("AdId"));
            
            
            //Add test to the ObservableList
            tesList.add(tes);
        }
        //return tesList (ObservableList of Tests)
        return tesList;
    }
    
     //*************************************
    //UPDATE an test
    //*************************************
    public static void updateTest (String testId,String colunmName, String arg) throws SQLException, ClassNotFoundException {
        //Declare a UPDATE statement
        String updateStmt =
                
                        "   UPDATE test\n" +
                        "      SET "+ colunmName+ " = '" + arg + "'\n" +
                        "    WHERE TesId = " + testId + ";\n";
                       
 
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
    //DELETE an test
    //*************************************
    public static void deleteTestWithId (String testId) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String updateStmt =
                        "   DELETE FROM test\n" +
                        "         WHERE TestId ="+testId +";\n";
 
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
    //INSERT an test
    //*************************************
    public static int insertTes (int PatientId, String TestType, int AdId) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String updateStmt =
               
                        "INSERT INTO test\n" +
                        "(PatientId,TestType, AdId)\n" +
                        "VALUES\n" +
                        "('"+PatientId+"','"+TestType+"','"+AdId+"');\n";
 
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
