package com.solvd.airport.services.jdbcImpl;

import com.solvd.airport.DAO.UserDAO;
import com.solvd.airport.models.User;
import com.solvd.airport.services.IUserService;

import java.util.List;

public class UserService implements IUserService {
    private UserDAO userDAO = new UserDAO();

@Override
    public User getUserByID(int id) {
            return userDAO.getUserByID(id);
    }

@Override
    public void createUser(User u) {
            userDAO.createUser(u);
    }
@Override
    public void updateUser(User u) {
            userDAO.updateUser(u);
    }
    @Override
    public void deleteUser(int id) {
            userDAO.deleteUser(id);
    }
    @Override
    public List<User> getAllUsers() {
        List<User> usersList = null;
        usersList = userDAO.getAllUsers();
        return usersList;
    }

}
