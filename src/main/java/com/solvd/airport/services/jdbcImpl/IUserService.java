package com.solvd.airport.services.jdbcImpl;

import com.solvd.airport.models.User;

public interface IUserService {
    public User getUserByID(int id);
    public void createUser(User u);
    public void updateUser(User u);
}