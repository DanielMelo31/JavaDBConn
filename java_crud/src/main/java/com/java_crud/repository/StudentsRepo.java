package com.java_crud.repository;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.java_crud.model.Student;
import com.java_crud.util.DBConnection;

public class StudentsRepo implements Repository<Student>{
    

    private Connection getConnection() throws SQLException, IOException{
        return DBConnection.getInstace();
    }

    @Override
    public List<Student> findAll() throws SQLException{
        List<Student> students = new ArrayList<>();

        try (
            Statement myStatement = getConnection().createStatement();
            ResultSet myResultSet = myStatement.executeQuery("Select * from students");
        ){
            while(myResultSet.next()){
                Student student = createStudents(myResultSet);
                students.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Students error");
        }

        return students;
    }

    @Override
    public Student getByID(Integer id) throws SQLException{
        Student student = null;
        
        try (
            PreparedStatement myStatement = getConnection().prepareStatement("Select * from students where students_id = ?");
        ){
            myStatement.setInt(1, id);
            try (ResultSet myResultSet = myStatement.executeQuery()) {
                if(myResultSet.next()){
                    student = createStudents(myResultSet);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return student;
    }

    @Override
    public void save(Student student) throws SQLException {
        try {
            PreparedStatement myStatement = 
                getConnection().prepareStatement(
                    "INSERT INTO students (name, lastname, age, email, load_date, update_date)VALUES (?,?,?,?,?,?)");
            
            myStatement.setString(1, student.getName());
            myStatement.setString(2, student.getLastname());
            myStatement.setInt(3, student.getAge());
            myStatement.setString(4, student.getEmail());
            myStatement.setDate(5, new Date(System.currentTimeMillis()));
            myStatement.setDate(6, new Date(System.currentTimeMillis()));

            myStatement.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error while adding a new user.");
        }
    }

    @Override
    public void update(int id, Student student) throws SQLException, IOException {
        String sql = "update students set name=?, lastname=?, age=?, email=?,update_date=? where students_id =" + id;
        try(
            PreparedStatement myStatement = getConnection().prepareStatement(sql);
        ) {
            myStatement.setString(1, student.getName());
            myStatement.setString(2, student.getLastname());
            myStatement.setInt(3, student.getAge());
            myStatement.setString(4, student.getEmail());
            myStatement.setDate(5, new Date(System.currentTimeMillis()));

            myStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error while updating a user.");
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try {
            PreparedStatement myStatement = getConnection().prepareStatement("Delete from students where students_id=?");
            myStatement.setInt(1, id);

            myStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error while deleting a user.");
        }
    }

    public Student createStudents(ResultSet myResultSet) throws SQLException {
        Student student = new Student();
        student.setStudents_id(myResultSet.getInt("students_id"));
        student.setName(myResultSet.getString("name"));
        student.setLastname(myResultSet.getString("lastname"));
        student.setAge(myResultSet.getInt("age"));
        student.setEmail(myResultSet.getString("email"));
        student.setLoad_date(myResultSet.getDate("load_date"));
        student.setUpdate_date(myResultSet.getDate("update_date"));
        
        return student;

    }
    
}
