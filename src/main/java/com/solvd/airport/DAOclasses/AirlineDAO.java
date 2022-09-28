package com.solvd.airport.DAOclasses;
import com.solvd.airport.models.Airline;
import com.solvd.airport.utils.ConnectionPool;

import java.sql.Connection;

public class AirlineDAO {
    public Airline getAirlineByID(int id) {
        Connection c = ConnectionPool.getInstance().getConnection();
        ConnectionPool.getInstance().returnConnection(c);
        return null;
    }
    public void createAirline(Airline a) {
        Connection c = ConnectionPool.getInstance().getConnection();
        ConnectionPool.getInstance().returnConnection(c);
    }
    public void updateAirline(Airline a) {
        Connection c = ConnectionPool.getInstance().getConnection();
        ConnectionPool.getInstance().returnConnection(c);
    }
    public void deleteAirline(Airline a) {
        Connection c = ConnectionPool.getInstance().getConnection();
        ConnectionPool.getInstance().returnConnection(c);
    }
}
