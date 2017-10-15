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
public class EmployeeDAO {
    //*******************************
    //SELECT an Employee
    //*******************************
    public static Employee searchEmployee (String nicN,String empId) throws SQLException, ClassNotFoundException {
        String selectStmt = null;
       
        if(empId.trim().isEmpty()){
            //Declare a SELECT statement
           selectStmt = "SELECT * FROM employee WHERE NICNumber LIKE '%"+nicN+"%'";
            
        }
        else if(nicN.trim().isEmpty()){
            //Declare a SELECT statement
            
             selectStmt = "SELECT * FROM employee WHERE EmpId='"+empId+"'";
             
            
        }
        else if(!empId.trim().isEmpty() && !nicN.trim().isEmpty()){
            selectStmt = "SELECT * FROM employee WHERE NICNumber LIKE '%"+nicN+"%' AND EmpId='"+empId+"'";
            
        }
        
 
        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsEmp = DBUtil.dbExecuteQuery(selectStmt);
 
            //Send ResultSet to the getEmployeeFromResultSet method and get employee object
            Employee employee = getEmployeeFromResultSet(rsEmp);
 
            //Return employee object
            return employee;
        } catch (SQLException e) {
            System.out.println("While searching an employee with " + empId + " id, an error occurred: " + e);
            //Return exception
            throw e;
        }
    }

   //Use ResultSet from DB as parameter and set Employee Object's attributes and return employee object.
    private static Employee getEmployeeFromResultSet(ResultSet rs) throws SQLException
    {
        Employee emp = null;
        if (rs.next()) {
            emp = new Employee();
            emp.setEmpId(rs.getInt("EmpId"));
            emp.setFirstName(rs.getString("FirstName"));
            emp.setLastName(rs.getString("LastName"));
            emp.setSex(rs.getString("Gender"));
            emp.setNicNumber(rs.getString("NICNumber"));
            emp.setAddress1(rs.getString("Address1"));
            emp.setAddress2(rs.getString("Address2"));
            emp.setAddress3(rs.getString("Address3"));
            emp.setContactNumber(rs.getString("ContactNumber"));
            emp.setSalary(rs.getString("Salary"));
            emp.setDesignation(rs.getString("Designation"));
        }
        return emp;
    }
    
    //*******************************
    //SELECT Employees
    //*******************************
    public static ObservableList<Employee> searchEmployees () throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM employee";
 
        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsEmps = DBUtil.dbExecuteQuery(selectStmt);
 
            //Send ResultSet to the getEmployeeList method and get employee object
            ObservableList<Employee> empList = getEmployeeList(rsEmps);
            System.out.println("mn DAO ake");
            //Return employee object
            return empList;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            //Return exception
            throw e;
        }
    }

    //Select * from employees operation
    private static ObservableList<Employee> getEmployeeList(ResultSet rs) throws SQLException, ClassNotFoundException {
        //Declare a observable List which comprises of Employee objects
        ObservableList<Employee> empList = FXCollections.observableArrayList();
 
        while (rs.next()) {
            Employee emp = new Employee();
            emp.setEmpId(rs.getInt("EmpId"));
            emp.setFirstName(rs.getString("FirstName"));
            emp.setLastName(rs.getString("LastName"));
            emp.setSex(rs.getString("Gender"));
            emp.setNicNumber(rs.getString("NICNumber"));
            emp.setAddress1(rs.getString("Address1"));
            emp.setAddress2(rs.getString("Address2"));
            emp.setAddress3(rs.getString("Address3"));
            emp.setContactNumber(rs.getString("ContactNumber"));
            emp.setSalary(rs.getString("Salary"));
            emp.setDesignation(rs.getString("Designation"));
            
            //Add employee to the ObservableList
            empList.add(emp);
        }
        //return empList (ObservableList of Employees)
        return empList;
    }
    
     //*************************************
    //UPDATE an employee
    //*************************************
    public static void updateEmp (String empId,String colunmName, String arg) throws SQLException, ClassNotFoundException {
        //Declare a UPDATE statement
        String updateStmt =
                
                        "   UPDATE employee\n" +
                        "      SET "+ colunmName+ " = '" + arg + "'\n" +
                        "    WHERE EmpId = " + empId + ";\n";
                       
 
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
    //DELETE an employee
    //*************************************
    public static void deleteEmpWithId (String empId) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String updateStmt =
                        "   DELETE FROM employee\n" +
                        "         WHERE EmpId ="+ empId +";\n";
 
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
    //INSERT an employee
    //*************************************
    public static int insertEmp (String FirstName, String LastName,String Gender,String NICNumber,String Address1,String Address2,String Address3,String ContactNumber,String Designation) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String updateStmt =
               
                        "INSERT INTO employee\n" +
                        "(FirstName, LastName, Gender, NICNumber, Address1, Address2, Address3, ContactNumber,Designation)\n" +
                        "VALUES\n" +
                        "( '"+FirstName+"', '"+LastName+"','"+Gender+"','"+NICNumber+"','"+Address1+"','"+Address2+"','"+Address3+"','"+ContactNumber+"','"+Designation+"');\n";
 
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
