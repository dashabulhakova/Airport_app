package com.solvd.airport.DAO;

import com.solvd.airport.models.Route;

public interface IRouteDAO extends IDAO<Route>{
    Route getObjectByID(int id);

    void create(Route r);

    void update(Route r);

    void delete(int id);

}
