package com.solvd.airport.services;

import com.solvd.airport.models.Passenger;

public interface IPassengerInterface {
    public Passenger getPassengerByID(int id);
    public void createPassenger(Passenger p);
    public void updatePassenger(Passenger p);
    public void deletePassenger(Passenger p);
}
