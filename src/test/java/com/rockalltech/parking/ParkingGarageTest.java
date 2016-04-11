package com.rockalltech.parking;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParkingGarageTest {

    @Test
    public void shouldReturnLevels() throws Exception {
        ParkingGarage parkingGarage = new ParkingGarage(new ParkingLevel[]{new ParkingLevel(1, 0, 0)});
        assertEquals(1, parkingGarage.getLevels().size());
    }

    @Test
    public void shouldReturnSmallSpaces() throws Exception {
        ParkingGarage parkingGarage = new ParkingGarage(new ParkingLevel[]{new ParkingLevel(1, 0, 0)});
        assertEquals(1, parkingGarage.getSpaces().size());
        assertEquals(Sizes.SMALL, parkingGarage.getSpaces().get(0).getSize());
    }

    @Test
    public void shouldReturnMediumSpaces() throws Exception {
        ParkingGarage parkingGarage = new ParkingGarage(new ParkingLevel[]{new ParkingLevel(0, 1, 0)});
        assertEquals(1, parkingGarage.getSpaces().size());
        assertEquals(Sizes.MEDIUM, parkingGarage.getSpaces().get(0).getSize());
    }

    @Test
    public void shouldReturnBigSpaces() throws Exception {
        ParkingGarage parkingGarage = new ParkingGarage(new ParkingLevel[]{new ParkingLevel(0, 0, 1)});
        assertEquals(1, parkingGarage.getSpaces().size());
        assertEquals(Sizes.BIG, parkingGarage.getSpaces().get(0).getSize());
    }
}
