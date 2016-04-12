package com.rockalltech.parking;

public class ParkingSpace {
    private Sizes size;
    private Vehicle vehicle;

    public ParkingSpace(Sizes size) {
        this.size = size;
    }

    public Sizes getSize() {
        return size;
    }

    public void park(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public boolean empty() {
        return vehicle == null;
    }
}
