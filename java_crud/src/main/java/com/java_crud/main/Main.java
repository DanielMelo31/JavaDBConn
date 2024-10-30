package com.java_crud.main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.java_crud.util.DBConnection;

public class Main {
    public static void main(String[] args){

        try (
            Connection myConnection = DBConnection.getInstace();
            Statement myStatement = myConnection.createStatement();
            ResultSet myResultSet = myStatement.executeQuery("Select * from students");
        ){

            System.out.println("Connection succeded");


            while (myResultSet.next()) {
                System.out.println(myResultSet.getString("name"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Upss, something went wrong.");
        }
    }
}