package com.solvd.airport.DAO;

public interface IDAO<T> {

        void create(T t);
        void update(T t);
        void delete(T t);
}
