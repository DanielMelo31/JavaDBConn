package com.java_crud.repository;

import java.io.IOException;
import java.sql.Connection;
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
    public void save(Instructor t) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void update(int id, Instructor t) throws SQLException, IOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Integer id) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
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
