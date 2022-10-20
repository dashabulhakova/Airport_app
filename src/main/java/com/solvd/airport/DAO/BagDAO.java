package com.solvd.airport.DAO;

import com.solvd.airport.models.Bag;
import com.solvd.airport.models.Route;
import org.apache.log4j.Logger;
import com.solvd.airport.utils.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BagDAO implements IDAO<Bag> {
    private static final Logger LOGGER = Logger.getLogger(BagDAO.class.getName());
    private static final String INSERT = "INSERT INTO bags (id, amount, size, weight) VALUES (?, ?, ?, ?);";
    private static final String UPDATE = "UPDATE bags SET  amount = ?, size = ?, weight = ?, WHERE id = ?;";
    private static final String DELETE = "DElETE FROM bags WHERE id = ?";

    @Override
    public Route getObjectById(int id) {
        return null;
    }
    @Override
    public void create(Bag b) {
        Connection c = ConnectionPool.getInstance().getConnection();
        PreparedStatement ps = null;
        try {
            ps = c.prepareStatement(INSERT);
            ps.setInt(1, b.getId());
            ps.setInt(2, b.getAmount());
            ps.setInt(3, b.getSize());
            ps.setInt(4, b.getWeight());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage() + "bag was not created");
        } finally {
            ConnectionPool.getInstance().returnConnection(c);
            assert ps != null;
        }
    }

    @Override
    public void update(Bag b) {
        Connection c = ConnectionPool.getInstance().getConnection();
        PreparedStatement ps = null;
        try {
            ps = c.prepareStatement(UPDATE);
            ps.setInt(1, b.getId());
            ps.setInt(2, b.getAmount());
            ps.setInt(3, b.getSize());
            ps.setInt(4, b.getWeight());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage() + "Cannot update staff");
        } finally {
            assert ps != null;
            ConnectionPool.getInstance().returnConnection(c);
        }
    }

    @Override
    public void delete(int id) {
        Connection c = ConnectionPool.getInstance().getConnection();
        PreparedStatement ps = null;
        try {
            ps = c.prepareStatement(DELETE);
            ps.setInt(1,id);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage() + "Could not delete");
        } finally {
            ConnectionPool.getInstance().returnConnection(c);
        }
    }
}
