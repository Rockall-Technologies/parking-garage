package com.rockalltech.parking;

public class Vehicle {
    private final String id;
    private final Size size;

    public Vehicle(String id, Size size) {
        this.id = id;
        this.size = size;
    }

    public Size getSize() {
        return size;
    }

    void move(Space unoptimal, Space current) {
        unoptimal.unpark(this);
        current.park(this);
    }
}
