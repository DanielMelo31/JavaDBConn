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

import com.java_crud.model.Instructor;
import com.java_crud.util.DBConnection;

public class InstructorRepo implements Repository<Instructor>{

    private Connection getConnection() throws SQLException, IOException {
        return DBConnection.getInstace();
    }

    @Override
    public List<Instructor> findAll() throws SQLException {
        List<Instructor> instructorList = new ArrayList<>();

        try (
            Statement myStatement = getConnection().createStatement();
            ResultSet myResultSet = myStatement.executeQuery("Select * from instructor");
        ){
            while (myResultSet.next()){
                Instructor instructor = createInstructor(myResultSet);
                instructorList.add(instructor);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error listing instructors");
        }

        return instructorList;
    }

    @Override
    public Instructor getByID(Integer id) throws SQLException, IOException {
        Instructor instructor = null;
        try (
            PreparedStatement myPreparedStatement = getConnection().prepareStatement("Select * from instructor where instructor_id=?"
            )
        ){
            myPreparedStatement.setInt(1, id);
            try (
                ResultSet myResultSet = myPreparedStatement.executeQuery()
            ){
                if(myResultSet.next()){
                    instructor = createInstructor(myResultSet);
                }
                
            } catch (Exception e) {
            }

        }
        return instructor;
    }

    @Override
    public void save(Instructor instructor) throws SQLException {
        try(
            PreparedStatement myPreparedStatement = getConnection().prepareCall(
                "insert into instructor(name, lastname, age, email, load_date, update_date) values (?, ?, ?, ?, ?, ?)"
            )
        ) {
            myPreparedStatement.setString(1, instructor.getName());
            myPreparedStatement.setString(2, instructor.getLastname());
            myPreparedStatement.setInt(3, instructor.getAge());
            myPreparedStatement.setString(4, instructor.getEmail());
            myPreparedStatement.setDate(5, new Date(System.currentTimeMillis()));
            myPreparedStatement.setDate(6, new Date(System.currentTimeMillis()));

            myPreparedStatement.executeUpdate();
            
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("Error creating a new Instructor");
        }
    }

    @Override
    public void update(int id, Instructor instructor) throws SQLException, IOException {
        try (
            PreparedStatement myPreparedStatement = getConnection().prepareStatement(
                "update instructor set name=?, lastname=?, age=?, email=?, update_date=? where instructor_id =" + id);
        ){
            myPreparedStatement.setString(1, instructor.getName());
            myPreparedStatement.setString(2, instructor.getLastname());
            myPreparedStatement.setInt(3, instructor.getAge());
            myPreparedStatement.setString(4, instructor.getEmail());
            myPreparedStatement.setDate(5, new Date(System.currentTimeMillis()));

            myPreparedStatement.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error updating an instructor");
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (
            PreparedStatement myPreparedStatement = getConnection().prepareStatement(
                "Delete from instructor where instructor_id = ?"
            )
        ) {
            myPreparedStatement.setInt(1, id);
            myPreparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error deleting an instructor");
        }
    }

    private Instructor createInstructor(ResultSet resultSet) throws SQLException{
        Instructor instructor = new Instructor();
        instructor.setInstructor_id(resultSet.getInt("instructor_id"));
        instructor.setName(resultSet.getString("name"));
        instructor.setLastname(resultSet.getString("lastname"));
        instructor.setAge(resultSet.getInt("age"));
        instructor.setEmail(resultSet.getString("email"));
        instructor.setLoad_date(resultSet.getDate("load_date"));
        instructor.setUpdate_date(resultSet.getDate("update_date"));

        return instructor;
    }
    
}
