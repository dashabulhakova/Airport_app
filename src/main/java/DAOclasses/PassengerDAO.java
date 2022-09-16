package DAOclasses;

import models.Passenger;
import utils.ConnectionPool;

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
