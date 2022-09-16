package services;

import DAOclasses.FlightDAO;
import models.Flight;

public class FlightService implements IFlightService {
    private FlightDAO flightDAO;

    @Override
    public Flight getFlightByID(int id) {
        try {
            return flightDAO.getFlightByID(id);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createFlight(Flight f) {
        try {
            flightDAO.createFlight(f);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void updateFlight(Flight f) {
        try {
            flightDAO.updateFlight(f);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteFlight(Flight f) {
        try {
            flightDAO.deleteFlight(f);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}

