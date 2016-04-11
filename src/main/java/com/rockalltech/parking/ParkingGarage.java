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

    public List<ParkingSpace> getSpaces() {
        List<ParkingSpace> result = new ArrayList<>();
        for (ParkingLevel parkingLevel : parkingLevels) {
            result.addAll(parkingLevel.getSpaces());
        }
        return result;
    }
}
