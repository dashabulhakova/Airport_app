package com.solvd.airport.services;

import com.solvd.airport.DAO.PassengerDAO;
import com.solvd.airport.models.Passenger;

public class PassengerService implements IPassengerInterface {
    private PassengerDAO passengerDAO;

    @Override
    public Passenger getPassengerByID(int id) {
        try {
            return passengerDAO.getPassengerByID(id);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createPassenger(Passenger p) {
        try {
            passengerDAO.createPassenger(p);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void updatePassenger(Passenger p) {
        try {
            passengerDAO.updatePassenger(p);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
    public void deletePassenger(Passenger p) {
        try {
            passengerDAO.deletePassenger(p);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
