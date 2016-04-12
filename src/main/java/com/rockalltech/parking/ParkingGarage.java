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

    public List<ParkingSpace> getEmptySpaces() {
        List<ParkingSpace> result = new ArrayList<>();
        for (ParkingLevel parkingLevel : parkingLevels) {
            for (ParkingSpace parkingSpace : parkingLevel.getSpaces()) {
                if (parkingSpace.empty()) {
                    result.add(parkingSpace);
                }
            }
        }
        return result;
    }

    public ParkingSpace park(Vehicle vehicle) {
        ParkingSpace result = null;
        for (ParkingSpace space : getEmptySpaces()) {
            if (vehicle.getSize().ordinal() <= space.getSize().ordinal()) {
                space.park(vehicle);
                result = space;
            }
        }
        return result;
    }
}
