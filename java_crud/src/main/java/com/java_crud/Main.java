package com.java_crud;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws SQLException, IOException{
        
        Properties props = new Properties();
        FileInputStream inputStream = new FileInputStream("config.properties");
        props.load(inputStream);
        inputStream.close();
        
        String dbUrl = props.getProperty("db_url");
        String dbUser = props.getProperty("db_user");
        String dbPassword = props.getProperty("db_password");


        try (
            Connection myConnection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
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