package com.solvd.airport.DAO;

import com.solvd.airport.models.Route;

public interface IDAO<T> {
        Route getObjectById(int id);
        void create(T t);
        void update(T t);
        void delete(int id);
}
