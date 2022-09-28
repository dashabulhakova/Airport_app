package com.solvd.airport.DAOclasses;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface IDAO<T> {

        void create(T t);
        void update(T t);
        void delete(T t);
}
