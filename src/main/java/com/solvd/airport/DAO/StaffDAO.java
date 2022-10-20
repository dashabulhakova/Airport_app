package com.solvd.airport.DAO;

import com.solvd.airport.models.Route;
import com.solvd.airport.models.Staff;
import com.solvd.airport.utils.ConnectionPool;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StaffDAO implements IStaffDAO{
    private static final Logger LOGGER = Logger.getLogger(StaffDAO.class.getName());
    private static final String READ = "SELECT * FROM Staff where id = ?";
    private static final String INSERT = "INSERT INTO Staff (id, position, staff_member_id) VALUES (?, ?, ?);";
    private static final String UPDATE = "UPDATE Staff SET  position = ?, staff_member_id = ?, WHERE id = ?;";
    private static final String DELETE = "DElETE FROM Staff WHERE id = ?";

    @Override
    public Staff getObjectByID(int id) {
        Connection c = ConnectionPool.getInstance().getConnection();
        try (PreparedStatement ps = c.prepareStatement(READ)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String position = rs.getString("position");
                Integer staffMemberId = rs.getInt("staff_member_id");
                Staff staff = new Staff(id, position, staffMemberId);
                return staff;
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
    public Route getObjectById(int id) {
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

    public void update(Staff s) {
        Connection c = ConnectionPool.getInstance().getConnection();
        PreparedStatement ps = null;
        try {
            ps = c.prepareStatement(UPDATE);
            ps.setInt(1, s.getId());
            ps.setString(2, s.getPosition());
            ps.setInt(3, s.getStaffMemberId());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage() + "Cannot update bags");
        } finally {
            assert ps != null;
            ConnectionPool.getInstance().returnConnection(c);
        }
    }
    public void delete(int id) {
        Connection con = ConnectionPool.getInstance().getConnection();
        try(PreparedStatement ps =con.prepareStatement(DELETE)) {
            ps.setInt(1,id);
            if (ps.executeUpdate()>0) {
                String message = String.format("Staff with ID: %d was removed successfully", id);
                LOGGER.info(message);
            }
        } catch (SQLException e) {
            String message = String.format("Staff with ID: %d was not removed", id);
            LOGGER.error(message);
        } finally {
            ConnectionPool.getInstance().returnConnection(con);
        }
    }
}
