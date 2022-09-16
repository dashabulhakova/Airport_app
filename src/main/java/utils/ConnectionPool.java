package utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class ConnectionPool {

        private static ConnectionPool pool;
        private static List<Connection> connectionPool = new ArrayList<>(5);

        private ConnectionPool() {

        }
        public static ConnectionPool getInstance() {
            if (pool == null) {
                pool = new ConnectionPool();
                for(int i = 0; i < 5; i++) {
                    try {
                        connectionPool.add(createConnection("jdbc:mysql://localhost:3306/airport", "root", "nedasha1b"));
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            return pool;
        }

        public static Connection createConnection(String url, String user, String password) throws SQLException {
            return DriverManager.getConnection(url, user, password);
        }
        public synchronized Connection getConnection() {
            return connectionPool.remove(connectionPool.size() - 1);
        }

        public synchronized void returnConnection(Connection connection) {
            connectionPool.add(connection);
        }
    }
