package com.rockalltech.parking;

public class Space {
    private Size size;
    private Vehicle vehicle;

    public Space(Size size) {
        this.size = size;
    }

    public Size getSize() {
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

    boolean unoptimal(Size size) {
        return !empty() && getVehicle().getSize() == size && getSize().ordinal() > getVehicle().getSize().ordinal();
    }
}
