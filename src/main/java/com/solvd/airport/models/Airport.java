package com.solvd.airport.models;

public class Airport {
    private int id;
    private String name;
    private String location;
    private String terminal;

    public Airport() {
    }

    public Airport(String name, String location, String terminal) {
        this.name = name;
        this.location = location;
        this.terminal = terminal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }
}
