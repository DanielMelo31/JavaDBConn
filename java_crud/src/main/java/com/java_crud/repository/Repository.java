package com.java_crud.repository;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface Repository<T> {
    List<T> findAll() throws SQLException;
    T getByID(Integer id) throws SQLException;
    void save(T t) throws SQLException;
    void update(int id, T t) throws SQLException, IOException;
    void delete(Integer id) throws SQLException;
}
