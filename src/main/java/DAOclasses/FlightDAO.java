package DAOclasses;
import flightInfo.Flight;
import flightInfo.MemberCard;
import utils.ConnectionPool;
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
