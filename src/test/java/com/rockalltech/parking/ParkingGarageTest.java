package com.rockalltech.parking;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParkingGarageTest {

    @Test
    public void levelsReturnsLevels() throws Exception {
        ParkingGarage parkingGarage = new ParkingGarage(new Level(1, 0, 0));
        assertEquals(1, parkingGarage.getLevels().size());
    }

    @Test
    public void spacesReturnsSmallSpace() throws Exception {
        ParkingGarage parkingGarage = new ParkingGarage(new Level(1, 0, 0));
        assertEquals(1, parkingGarage.getEmptySpaces().size());
        assertEquals(Size.SMALL, parkingGarage.getEmptySpaces().get(0).getSize());
    }

    @Test
    public void spacesReturnsMediumSpace() throws Exception {
        ParkingGarage parkingGarage = new ParkingGarage(new Level(0, 1, 0));
        assertEquals(1, parkingGarage.getEmptySpaces().size());
        assertEquals(Size.MEDIUM, parkingGarage.getEmptySpaces().get(0).getSize());
    }

    @Test
    public void spacesReturnsBigSpace() throws Exception {
        ParkingGarage parkingGarage = new ParkingGarage(new Level(0, 0, 1));
        assertEquals(1, parkingGarage.getEmptySpaces().size());
        assertEquals(Size.BIG, parkingGarage.getEmptySpaces().get(0).getSize());
    }

    @Test
    public void parkShouldReturnSmallSpace() throws Exception {
        ParkingGarage parkingGarage = new ParkingGarage(new Level(1, 0, 0));
        Space space = parkingGarage.park(new Vehicle("small", Size.SMALL));
        assertEquals(Size.SMALL, space.getSize());
    }

    @Test
    public void parkShouldReturnNullIfNotEmpty() throws Exception {
        ParkingGarage parkingGarage = new ParkingGarage(new Level(1, 0, 0));
        parkingGarage.park(new Vehicle("small", Size.SMALL));
        Space space = parkingGarage.park(new Vehicle("small", Size.SMALL));
        assertEquals(null, space);
    }

    @Test
    public void parkShouldReturnMediumSpace() throws Exception {
        ParkingGarage parkingGarage = new ParkingGarage(new Level(0, 1, 0));
        Space space = parkingGarage.park(new Vehicle("small", Size.SMALL));
        assertEquals(Size.MEDIUM, space.getSize());
    }

    @Test
    public void parkShouldReturnNullIfDoesntFit() throws Exception {
        ParkingGarage parkingGarage = new ParkingGarage(new Level(1, 0, 0));
        Space space = parkingGarage.park(new Vehicle("medium", Size.MEDIUM));
        assertEquals(null, space);
    }

    @Test
    public void findShouldReturnParkingSpace() throws Exception {
        ParkingGarage parkingGarage = new ParkingGarage(new Level(1, 0, 0));
        Vehicle vehicle = new Vehicle("small", Size.SMALL);
        Space space = parkingGarage.park(vehicle);
        Space found = parkingGarage.find(vehicle);
        assertEquals(space, found);
    }

    @Test
    public void unparkShouldReleaseSpace() throws Exception {
        ParkingGarage parkingGarage = new ParkingGarage(new Level(0, 1, 0));
        Vehicle vehicle = new Vehicle("small", Size.SMALL);
        parkingGarage.park(vehicle);
        assertEquals(0, parkingGarage.getEmptySpaces().size());
        parkingGarage.unpark(vehicle);
        assertEquals(1, parkingGarage.getEmptySpaces().size());
    }

    @Test(expected = RuntimeException.class)
    public void unparkShouldFailIfVehicleNotParked() throws Exception {
        ParkingGarage parkingGarage = new ParkingGarage(new Level(0, 1, 0));
        Vehicle small = new Vehicle("small", Size.SMALL);
        parkingGarage.park(small);
        assertEquals(0, parkingGarage.getEmptySpaces().size());
        parkingGarage.unpark(new Vehicle("another-small", Size.SMALL));
    }

    @Test
    public void unparkShouldOptimiseSpaces() {
        ParkingGarage parkingGarage = new ParkingGarage(new Level(1, 1, 0));
        Vehicle vehicle1 = new Vehicle("small-1", Size.SMALL);
        Space smallSpace = parkingGarage.park(vehicle1);
        assertEquals(Size.SMALL, smallSpace.getSize());
        Vehicle vehicle2 = new Vehicle("small-2", Size.SMALL);
        Space mediumSpace = parkingGarage.park(vehicle2);
        assertEquals(Size.MEDIUM, mediumSpace.getSize());
        parkingGarage.unpark(vehicle1);
        Space found = parkingGarage.find(vehicle2);
        assertEquals("Small car parking space", Size.SMALL, found.getSize());
    }
}
