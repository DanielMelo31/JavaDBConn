package com.java_crud.main;

import java.io.IOException;
import java.sql.SQLException;

import com.java_crud.model.Student;
import com.java_crud.repository.Repository;
import com.java_crud.repository.StudentsRepo;

public class Main {
    public static void main(String[] args) throws SQLException, IOException{

        // try (
        //     Connection myConnection = DBConnection.getInstace();
        //     Statement myStatement = myConnection.createStatement();
        //     ResultSet myResultSet = myStatement.executeQuery("Select * from students");
        // ){

        //     System.out.println("Connection succeded");


        //     while (myResultSet.next()) {
        //         System.out.println(myResultSet.getString("name"));
        //     }
            
        // } catch (Exception e) {
        //     e.printStackTrace();
        //     System.out.println("Upss, something went wrong.");
        // }

        
        
        Repository<Student> repo = new StudentsRepo();

        repo.findAll().forEach(System.out::println);
        
    }
}