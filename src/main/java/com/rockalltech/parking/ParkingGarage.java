package com.rockalltech.parking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParkingGarage {
    private List<ParkingLevel> parkingLevels;

    public ParkingGarage(ParkingLevel... pl) {
        parkingLevels = Arrays.asList(pl);
    }

    public List<ParkingLevel> getLevels() {
        return parkingLevels;
    }

    private List<ParkingSpace> getSpaces() {
        List<ParkingSpace> result = new ArrayList<>();
        for (ParkingLevel parkingLevel : parkingLevels) {
            for (ParkingSpace parkingSpace : parkingLevel.getSpaces()) {
                result.add(parkingSpace);
            }
        }
        return result;
    }

    public List<ParkingSpace> getEmptySpaces() {
        List<ParkingSpace> result = new ArrayList<>();
        for (ParkingSpace parkingSpace : getSpaces()) {
            if (parkingSpace.empty()) {
                result.add(parkingSpace);
            }
        }
        return result;
    }

    public ParkingSpace park(Vehicle vehicle) {
        ParkingSpace result = null;
        for (ParkingSpace space : getEmptySpaces()) {
            if (space.canPark(vehicle)) {
                space.park(vehicle);
                result = space;
                break;
            }
        }
        return result;
    }

    public ParkingSpace find(Vehicle vehicle) {
        ParkingSpace result = null;
        for (ParkingSpace parkingSpace : getSpaces()) {
            if (parkingSpace.isParked(vehicle)) {
                result = parkingSpace;
                break;
            }
        }
        return result;
    }

    public void unpark(Vehicle vehicle) {
        ParkingSpace parkingSpace = find(vehicle);
        if (parkingSpace == null) {
            throw new RuntimeException("Vehicle not parked here");
        }
        parkingSpace.unpark(vehicle);
        optimiseSpace(parkingSpace);
    }

    private void optimiseSpace(ParkingSpace parkingSpace) {
        ParkingSpace unoptimal = findUnoptimalSpace(parkingSpace.getSize());
        if (unoptimal != null) {
            Vehicle move = unoptimal.getVehicle();
            unoptimal.unpark(move);
            parkingSpace.park(move);
        }
    }

    private ParkingSpace findUnoptimalSpace(Sizes size) {
        ParkingSpace result = null;
        for (ParkingSpace parkingSpace : getSpaces()) {
            if (parkingSpace.unoptimal(size)) {
                result = parkingSpace;
                break;
            }
        }
        return result;
    }

}
