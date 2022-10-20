package com.solvd.airport.DAO;

import com.solvd.airport.models.User;
import com.solvd.airport.utils.ConnectionPool;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    private static final Logger LOGGER = Logger.getLogger(UserDAO.class.getName());
    private static final String READ = "SELECT * FROM Users where id = ?";
    private static final String INSERT = "INSERT INTO Users (id, first_name, last_name, email) VALUES (?, ?, ?, ?);";
    private static final String UPDATE = "UPDATE Users SET  amount = ?, size = ?, weight = ?, WHERE id = ?;";
    private static final String DELETE = "DElETE FROM Users WHERE id = ?";
    public User getUserByID(int id) {
            Connection c = ConnectionPool.getInstance().getConnection();
            try(PreparedStatement ps = c.prepareStatement(READ)) {
                ps.setLong(1,id);
                ResultSet rs = ps.executeQuery();
                if(rs.next()) {
                    String firstName = rs.getString("first_name");
                    String lastName = rs.getString("last_name");
                    String email = rs.getString("email");
                    User user = new User(id, firstName, lastName, email);
                    return user;
                }
            } catch (SQLException e) {
                String message = String.format("Getting user with ID:%d wasn't successful", id);
                LOGGER.error(message, e);
            } finally {
                ConnectionPool.getInstance().returnConnection(c);
            }
            return null;
    }

    public void createUser(User u) {
        Connection con = ConnectionPool.getInstance().getConnection();
        try (PreparedStatement ps = con.prepareStatement(INSERT)) {
            ps.setInt(1, u.getId());
            ps.setString(2, u.getFirstName());
            ps.setString(3, u.getLastName());
            ps.setString(4, u.getEmail());
            ps.executeUpdate();
        }
        catch (SQLException e) {
            LOGGER.error("Can't create a user",e);
        }
        finally {
            ConnectionPool.getInstance().returnConnection(con);
        }
    }

    public void updateUser(User u) {
        Connection con = ConnectionPool.getInstance().getConnection();
        try (PreparedStatement ps = con.prepareStatement(UPDATE)) {
            ps.setString(1,u.getEmail());
            ps.setLong(2,u.getId());
            if (ps.executeUpdate()>0) {
                LOGGER.info("User with ID: %d was updated successfully");
            }
        } catch (SQLException e) {
            String message = String.format("User with ID: %d was not updated successfully",u.getId());
            LOGGER.error(message);
        } finally {
            ConnectionPool.getInstance().returnConnection(con);
        }
    }
    public void deleteUser(int id) {
        Connection con = ConnectionPool.getInstance().getConnection();
        try(PreparedStatement ps =con.prepareStatement(DELETE)) {
            ps.setInt(1,id);
            if (ps.executeUpdate()>0) {
                String message = String.format("User with ID: %d was removed successfully", id);
                LOGGER.info(message);
            }
        } catch (SQLException e) {
            String message = String.format("User with ID: %d was not removed", id);
            LOGGER.error(message);
        } finally {
            ConnectionPool.getInstance().returnConnection(con);
        }
    }
}
