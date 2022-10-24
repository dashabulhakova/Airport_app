package com.solvd.airport.DAO;

import com.solvd.airport.models.User;

import java.util.List;

public interface IUserDAO extends IDAO<User>{
    User getObjectByID(int id);
    void create(User u);
    void update(User u);
    void delete(int id);
    List<User> getAllUsers();
}
