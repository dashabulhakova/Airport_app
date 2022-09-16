package services;

import models.Passenger;

public interface IPassengerInterface {
    public Passenger getPassengerByID(int id);
    public void createPassenger(Passenger p);
    public void updatePassenger(Passenger p);
    public void deletePassenger(Passenger p);
}
