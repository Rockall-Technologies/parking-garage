package com.rockalltech.parking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParkingGarage {
    private List<Level> levels;

    public ParkingGarage(Level... pl) {
        levels = Arrays.asList(pl);
    }

    public List<Level> getLevels() {
        return levels;
    }

    private List<Space> getSpaces() {
        List<Space> result = new ArrayList<>();
        for (Level level : levels) {
            for (Space space : level.getSpaces()) {
                result.add(space);
            }
        }
        return result;
    }

    public List<Space> getEmptySpaces() {
        List<Space> result = new ArrayList<>();
        for (Space space : getSpaces()) {
            if (space.empty()) {
                result.add(space);
            }
        }
        return result;
    }

    public Space park(Vehicle vehicle) {
        Space result = null;
        for (Space space : getEmptySpaces()) {
            if (space.canPark(vehicle)) {
                space.park(vehicle);
                result = space;
                break;
            }
        }
        return result;
    }

    public Space find(Vehicle vehicle) {
        Space result = null;
        for (Space space : getSpaces()) {
            if (space.isParked(vehicle)) {
                result = space;
                break;
            }
        }
        return result;
    }

    public void unpark(Vehicle vehicle) {
        Space space = find(vehicle);
        if (space == null) {
            throw new RuntimeException("Vehicle not parked here");
        }
        space.unpark(vehicle);
        optimiseSpace(space);
    }

    private void optimiseSpace(Space space) {
        Space unoptimal = findUnoptimalSpace(space.getSize());
        if (unoptimal != null) {
            Vehicle move = unoptimal.getVehicle();
            unoptimal.unpark(move);
            space.park(move);
        }
    }

    private Space findUnoptimalSpace(Size size) {
        Space result = null;
        for (Space space : getSpaces()) {
            if (space.unoptimal(size)) {
                result = space;
                break;
            }
        }
        return result;
    }

}
