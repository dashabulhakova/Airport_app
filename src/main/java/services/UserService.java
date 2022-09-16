package services;

import DAOclasses.UserDAO;
import models.User;

public class UserService implements IUserService {
    private UserDAO userDAO;

@Override
    public User getUserByID(int id) {
        try {
            return userDAO.getUserByID(id);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

@Override
    public void createUser(User u) {
        try {
            userDAO.createUser(u);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
@Override
    public void updateUser(User u) {
        try {
            userDAO.updateUser(u);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteUser(User u) {
        try {
            userDAO.deleteUser(u);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
