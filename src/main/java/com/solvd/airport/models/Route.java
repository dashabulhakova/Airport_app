package com.solvd.airport.models;

public class Route {
    private int routeId;
    private String origin;
    private String destination;
    private static boolean connecting = false;
    public Route() {}

    public Route(String origin, String destination) {
        this.origin = origin;
        this.destination = destination;
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public static boolean isConnecting() {
        return connecting;
    }

    public static void setConnecting(boolean connecting) {
        Route.connecting = connecting;
    }
}

