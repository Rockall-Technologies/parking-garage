package com.rockalltech.parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingLevel {

    private List<ParkingSpace> parkingSpaces = new ArrayList<ParkingSpace>();

    public ParkingLevel(int small, int medium, int big) {
        parkingSpaces.addAll(spaces(small, Sizes.SMALL));
        parkingSpaces.addAll(spaces(medium, Sizes.MEDIUM));
        parkingSpaces.addAll(spaces(big, Sizes.BIG));
    }

    private List<ParkingSpace> spaces(int small, Sizes size) {
        List<ParkingSpace> result = new ArrayList<ParkingSpace>();
        for (int i = 0; i < small; i++) {
            result.add(new ParkingSpace(size));
        }
        return result;
    }

    public List<ParkingSpace> getSpaces() {
        return parkingSpaces;
    }
}
