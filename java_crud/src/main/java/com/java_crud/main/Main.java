package com.java_crud.main;

import java.io.IOException;
import java.sql.SQLException;

import com.java_crud.repository.InstructorRepo;
import com.java_crud.repository.Repository;

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

        
        
        // Repository<Student> repo = new StudentsRepo();

        // repo.findAll().forEach(System.out::println);
        
        //     JFrame frame = new JFrame("My First GUI");
        //     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //     frame.setSize(300,300);
        //    JButton button1 = new JButton("Press");
        //    frame.getContentPane().add(button1);
        //    frame.setVisible(true);
        

        Repository repository = new InstructorRepo();

        // repository.findAll().forEach(System.out::println);
        System.out.println(repository.getByID(2));

    }
}