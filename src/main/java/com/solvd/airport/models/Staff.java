package com.solvd.airport.models;

public class Staff {
    private int id;
    private String position;
    private int staffMemberId;
    public Staff() {
    }

    public Staff(int id, String position, int staffMemberId) {
        this.id = id;
        this.position = position;
        this.staffMemberId = staffMemberId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getStaffMemberId() {
        return staffMemberId;
    }

    public void setStaffMemberId(int staffMemberId) {
        this.staffMemberId = staffMemberId;
    }
}
