package utils;

import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.apache.log4j.Logger;

public class ConnectionPool {
    private static final Logger LOGGER = Logger.getLogger(ConnectionPool.class.getName());
        private static ConnectionPool pool;
        private static List<Connection> connectionPool = new ArrayList<>(5);

        private ConnectionPool() {
        try {
            InputStream input = new FileInputStream("src/main/resources/database.properties");
            Properties p = new Properties();
            p.load(input);
            String url = p.getProperty("url");
            String user = p.getProperty("username");
            String password = p.getProperty("password");
            for (int i = 0; i < 5; i++) {
                connectionPool.add(DriverManager.getConnection(url, user, password));
            }
        } catch (SQLException e) {
            LOGGER.error("");
        } catch (FileNotFoundException e) {
                LOGGER.error("");;
        } catch (IOException e) {
                LOGGER.error("");;
        }
        }
            public static ConnectionPool getInstance() {
            if (pool == null) {
                pool = new ConnectionPool();
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
