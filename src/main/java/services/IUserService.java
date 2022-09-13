package services;

import people.User;

public interface IUserService {
    public User getUserByID(int id);
    public void createUser(User u);
    public void updateUser(User u);
}
