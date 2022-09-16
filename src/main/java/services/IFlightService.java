package services;

import models.Flight;

public interface IFlightService {
    public Flight getFlightByID(int id);
    public void createFlight(Flight f);
    public void updateFlight(Flight f);
    public void deleteFlight(Flight f);
}
