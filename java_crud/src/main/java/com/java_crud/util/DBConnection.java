package com.java_crud.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection extends IOException{
              
        private static String dbUrl;
        private static String dbUser; 
        private static String dbPassword;
        private static Connection myConnection;
        
        public static Connection getInstace() throws SQLException, IOException{
            Properties props = new Properties();
            FileInputStream inputStream = new FileInputStream("config.properties");
            props.load(inputStream);
            inputStream.close();
            
            dbUrl = props.getProperty("db_url");
            dbUser = props.getProperty("db_user");
            dbPassword = props.getProperty("db_password");
            
            if(myConnection == null) {
                myConnection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            }
            return myConnection;
        }
}
