package com.solvd.airport.DAOclasses;

import com.solvd.airport.models.User;
import com.solvd.airport.utils.ConnectionPool;

import java.sql.Connection;

public class UserDAO {
    public User getUserByID(int id) {
        Connection c = ConnectionPool.getInstance().getConnection();
            ConnectionPool.getInstance().returnConnection(c);
        return null;
    }

    public void createUser(User u) {
        Connection c = ConnectionPool.getInstance().getConnection();
            ConnectionPool.getInstance().returnConnection(c);
    }

    public void updateUser(User u) {
        Connection c = ConnectionPool.getInstance().getConnection();
            ConnectionPool.getInstance().returnConnection(c);
    }
    public void deleteUser(User u) {
        Connection c = ConnectionPool.getInstance().getConnection();
        ConnectionPool.getInstance().returnConnection(c);
    }
}