package com.solvd.airport.DAOclasses;
import com.solvd.airport.models.MemberCard;
import org.apache.log4j.Logger;
import com.solvd.airport.utils.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MemberDAO {
    private static final Logger LOGGER = Logger.getLogger(MemberDAO.class.getName());
    private static final String INSERT = "INSERT INTO discounts (name, rate) VALUES (?, ?);";

    public MemberCard getByID(int id) {
        Connection c = ConnectionPool.getInstance().getConnection();
        ConnectionPool.getInstance().returnConnection(c);
        return null;
    }
    public void createMember(MemberCard m) throws SQLException {
            Connection c = ConnectionPool.getInstance().getConnection();
            PreparedStatement ps = null;
            try {
                ps = c.prepareStatement(INSERT);
                ps.setString(1, m.getLevel());
                ps.setInt(2, m.getYearsAsMember());
                ps.executeUpdate();
            } catch (SQLException e) {
                LOGGER.error(e.getMessage());
            } finally {
                assert ps != null;
                ps.close();
                ConnectionPool.getInstance().returnConnection(c);
            }
    }
}
