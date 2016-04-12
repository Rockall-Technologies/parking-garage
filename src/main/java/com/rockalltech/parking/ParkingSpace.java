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

    public boolean isParked(Vehicle vehicle) {
        return this.vehicle == vehicle;
    }

    public void unpark(Vehicle vehicle) {
        if (this.vehicle != vehicle) {
            return;
        }
        this.vehicle = null;
    }
}
