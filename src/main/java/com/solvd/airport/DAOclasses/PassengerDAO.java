package com.solvd.airport.DAOclasses;

import com.solvd.airport.models.Passenger;
import com.solvd.airport.utils.ConnectionPool;

import java.sql.Connection;

public class PassengerDAO {
    public Passenger getPassengerByID(int id) {
        Connection c = ConnectionPool.getInstance().getConnection();
        ConnectionPool.getInstance().returnConnection(c);
        return null;
    }

    public void createPassenger(Passenger p) {
        Connection c = ConnectionPool.getInstance().getConnection();
        ConnectionPool.getInstance().returnConnection(c);
    }

    public void updatePassenger(Passenger p) {
        Connection c = ConnectionPool.getInstance().getConnection();
        ConnectionPool.getInstance().returnConnection(c);
    }
    public void deletePassenger(Passenger p) {
        Connection c = ConnectionPool.getInstance().getConnection();
        ConnectionPool.getInstance().returnConnection(c);
    }
}
