package DAOclasses;

import models.Bag;
import org.apache.log4j.Logger;
import utils.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BagDAO implements IDAO<Bag>{
    private static final Logger LOGGER = Logger.getLogger(BagDAO.class.getName());
    private static final String INSERT = "INSERT INTO bags (id, size, weight) VALUES (?, ?, ?);";
    private static final String UPDATE = "UPDATE bags SET  = ?, size = ?, weight = ?, WHERE id = ?;";

    @Override
    public void create(Bag b) {
        Connection c = ConnectionPool.getInstance().getConnection();
        PreparedStatement ps = null;
        try {
            ps = c.prepareStatement(INSERT);
            ps.setInt(1, b.getId());
            ps.setInt(2, b.getSize());
            ps.setInt(3, b.getWeight());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage() + "bag was not created");
        } finally {
            ConnectionPool.getInstance().returnConnection(c);
            assert ps != null;
            try {
                ps.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    @Override
    public void update(Bag b){};
    @Override
    public void delete(Bag b) {};
}
