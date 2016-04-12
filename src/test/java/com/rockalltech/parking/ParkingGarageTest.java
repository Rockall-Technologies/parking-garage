package com.rockalltech.parking;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParkingGarageTest {

    @Test
    public void levelsReturnsLevels() throws Exception {
        ParkingGarage parkingGarage = new ParkingGarage(new ParkingLevel(1, 0, 0));
        assertEquals(1, parkingGarage.getLevels().size());
    }

    @Test
    public void spacesReturnsSmallSpace() throws Exception {
        ParkingGarage parkingGarage = new ParkingGarage(new ParkingLevel(1, 0, 0));
        assertEquals(1, parkingGarage.getEmptySpaces().size());
        assertEquals(Sizes.SMALL, parkingGarage.getEmptySpaces().get(0).getSize());
    }

    @Test
    public void spacesReturnsMediumSpace() throws Exception {
        ParkingGarage parkingGarage = new ParkingGarage(new ParkingLevel(0, 1, 0));
        assertEquals(1, parkingGarage.getEmptySpaces().size());
        assertEquals(Sizes.MEDIUM, parkingGarage.getEmptySpaces().get(0).getSize());
    }

    @Test
    public void spacesReturnsBigSpace() throws Exception {
        ParkingGarage parkingGarage = new ParkingGarage(new ParkingLevel(0, 0, 1));
        assertEquals(1, parkingGarage.getEmptySpaces().size());
        assertEquals(Sizes.BIG, parkingGarage.getEmptySpaces().get(0).getSize());
    }

    @Test
    public void parkShouldReturnSmallSpace() throws Exception {
        ParkingGarage parkingGarage = new ParkingGarage(new ParkingLevel(1, 0, 0));
        ParkingSpace parkingSpace = parkingGarage.park(new Vehicle("small", Sizes.SMALL));
        assertEquals(Sizes.SMALL, parkingSpace.getSize());
    }


    @Test
    public void parkShouldReturnNullIfNotEmpty() throws Exception {
        ParkingGarage parkingGarage = new ParkingGarage(new ParkingLevel(1, 0, 0));
        parkingGarage.park(new Vehicle("small", Sizes.SMALL));
        ParkingSpace parkingSpace = parkingGarage.park(new Vehicle("small", Sizes.SMALL));
        assertEquals(null, parkingSpace);
    }

    @Test
    public void parkShouldReturnMediumSpace() throws Exception {
        ParkingGarage parkingGarage = new ParkingGarage(new ParkingLevel(0, 1, 0));
        ParkingSpace parkingSpace = parkingGarage.park(new Vehicle("small", Sizes.SMALL));
        assertEquals(Sizes.MEDIUM, parkingSpace.getSize());
    }

    @Test
    public void parkShouldReturnNullIfDoesntFit() throws Exception {
        ParkingGarage parkingGarage = new ParkingGarage(new ParkingLevel(1, 0, 0));
        ParkingSpace parkingSpace = parkingGarage.park(new Vehicle("medium", Sizes.MEDIUM));
        assertEquals(null, parkingSpace);
    }

    @Test
    public void findShouldReturnParkingSpace() throws Exception {
        ParkingGarage parkingGarage = new ParkingGarage(new ParkingLevel(1, 0, 0));
        Vehicle vehicle = new Vehicle("small", Sizes.SMALL);
        ParkingSpace parkingSpace = parkingGarage.park(vehicle);
        ParkingSpace found = parkingGarage.find(vehicle);
        assertEquals(parkingSpace, found);
    }

    @Test
    public void unparkShouldReleaseSpace() throws Exception {
        ParkingGarage parkingGarage = new ParkingGarage(new ParkingLevel(0, 1, 0));
        Vehicle small = new Vehicle("small", Sizes.SMALL);
        parkingGarage.park(small);
        assertEquals(0, parkingGarage.getEmptySpaces().size());
        parkingGarage.unpark(small);
        assertEquals(1, parkingGarage.getEmptySpaces().size());
    }
}
