package com.solvd.airport.DAO;

import com.solvd.airport.models.Staff;

public interface IStaffDAO extends IDAO<Staff>{
    Staff getObjectByID(int id);
    void create(Staff s);
    void update(Staff s);
    void delete(int id);
}
