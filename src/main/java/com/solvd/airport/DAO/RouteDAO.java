package com.solvd.airport.DAO;

import com.solvd.airport.models.Route;
import com.solvd.airport.models.Staff;
import com.solvd.airport.utils.ConnectionPool;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RouteDAO implements IStaffDAO {
    private static final Logger LOGGER = Logger.getLogger(RouteDAO.class.getName());
    private static final String READ = "SELECT * FROM Routes where id = ?";
    private static final String INSERT = "INSERT INTO Routes (id, position, staff_member_id) VALUES (?, ?, ?);";
    private static final String UPDATE = "UPDATE Staff SET  position = ?, staff_member_id = ?, WHERE id = ?;";
    private static final String DELETE = "DElETE FROM Staff WHERE id = ?";

    @Override
    public Route getObjectById(int id) {
        Connection c = ConnectionPool.getInstance().getConnection();
        try (PreparedStatement ps = c.prepareStatement(READ)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String origin = rs.getString("origin");
                String destination = rs.getString("destination");
                Route route = new Route(id, origin, destination);
                return route;
            }
        } catch (SQLException e) {
            String message = String.format("Getting user with ID:%d wasn't successful", id);
            LOGGER.error(message, e);
        } finally {
            ConnectionPool.getInstance().returnConnection(c);
        }
        return null;
    }

    @Override
    public Staff getObjectByID(int id) {
        return null;
    }

    @Override
    public void create(Staff s) {
        Connection c = ConnectionPool.getInstance().getConnection();
        PreparedStatement ps = null;
        try {
            ps = c.prepareStatement(INSERT);
            ps.setInt(1, s.getId());
            ps.setString(2, s.getPosition());
            ps.setInt(3, s.getStaffMemberId());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage() + "staff was not created");
        } finally {
            ConnectionPool.getInstance().returnConnection(c);
            assert ps != null;
        }
    }

    @Override
    public void update(Staff s) {

    }

    @Override
    public void delete(int id) {

    }
}
