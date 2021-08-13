package com.example.Rafael_300300098.Connection;

import java.sql.SQLException;
import java.util.List;

public interface IDatabase<T> {
    public void add(T entity) throws ClassNotFoundException, SQLException;
    public T edit(T entity) throws SQLException, ClassNotFoundException;
    public void delete(String id) throws SQLException;
    public List<T> display() throws ClassNotFoundException, SQLException;
}
