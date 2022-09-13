package flightInfo;

import org.apache.log4j.Logger;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Flight {
    private int flightId;
    private String flightNum;
    private int ticketNum ;
    private String seat;
    private int routeId;
    private int cost;

    public Flight () {}

    public Flight (String flightNum, int ticketNum, String seat, int routeId) {
        this.flightNum = flightNum;
        this.ticketNum = ticketNum;
        this.seat = seat;
        this.routeId = routeId;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getFlightNum() {
        return flightNum;
    }

    public void setFlightNum(String flightNum) {
        this.flightNum = flightNum;
    }

    public int getTicketNum() {
        return ticketNum;
    }

    public void setTicketNum(int ticketNum) {
        this.ticketNum = ticketNum;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightId=" + flightId +
                ", flightNum='" + flightNum + '\'' +
                ", ticketNum=" + ticketNum +
                ", seat='" + seat + '\'' +
                ", routeId=" + routeId +
                ", cost=" + cost +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flight)) return false;
        Flight flight = (Flight) o;
        return getFlightId() == flight.getFlightId() && getTicketNum() == flight.getTicketNum() && getRouteId() == flight.getRouteId() && getCost() == flight.getCost() && Objects.equals(getFlightNum(), flight.getFlightNum()) && Objects.equals(getSeat(), flight.getSeat());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFlightId(), getFlightNum(), getTicketNum(), getSeat(), getRouteId(), getCost());
    }
}
