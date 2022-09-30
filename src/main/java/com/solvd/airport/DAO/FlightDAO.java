package com.solvd.airport.DAO;
import com.solvd.airport.models.Flight;
import com.solvd.airport.utils.ConnectionPool;
import java.sql.Connection;

public class FlightDAO {
    public Flight getFlightByID(int id) {
        Connection c = ConnectionPool.getInstance().getConnection();
        ConnectionPool.getInstance().returnConnection(c);
        return null;
    }
    public void createFlight(Flight f) {
        Connection c = ConnectionPool.getInstance().getConnection();
        ConnectionPool.getInstance().returnConnection(c);
    }
    public void updateFlight(Flight f) {
        Connection c = ConnectionPool.getInstance().getConnection();
        ConnectionPool.getInstance().returnConnection(c);
    }
    public void deleteFlight(Flight f) {
        Connection c = ConnectionPool.getInstance().getConnection();
        ConnectionPool.getInstance().returnConnection(c);
    }
}
