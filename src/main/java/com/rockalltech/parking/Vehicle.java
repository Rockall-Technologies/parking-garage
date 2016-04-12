package com.rockalltech.parking;

public class Vehicle {
    private final String id;
    private final Sizes size;

    public Vehicle(String id, Sizes size) {
        this.id = id;
        this.size = size;
    }

    public Sizes getSize() {
        return size;
    }
}
