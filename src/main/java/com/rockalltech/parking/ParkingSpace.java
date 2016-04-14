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

    public void unpark(Vehicle vehicle) {
        this.vehicle = null;
    }

    public boolean isParked(Vehicle vehicle) {
        return this.vehicle == vehicle;
    }

    boolean canPark(Vehicle vehicle) {
        return vehicle.getSize().ordinal() <= getSize().ordinal();
    }

    public boolean empty() {
        return vehicle == null;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    boolean unoptimal(Sizes size) {
        return !empty() && getVehicle().getSize() == size && getSize().ordinal() > getVehicle().getSize().ordinal();
    }
}
