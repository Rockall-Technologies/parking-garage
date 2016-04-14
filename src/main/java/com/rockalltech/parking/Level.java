package com.rockalltech.parking;

import java.util.ArrayList;
import java.util.List;

public class Level {

    private List<Space> spaces = new ArrayList<>();

    public Level(int small, int medium, int big) {
        spaces.addAll(spaces(small, Size.SMALL));
        spaces.addAll(spaces(medium, Size.MEDIUM));
        spaces.addAll(spaces(big, Size.BIG));
    }

    private List<Space> spaces(int small, Size size) {
        List<Space> result = new ArrayList<>();
        for (int i = 0; i < small; i++) {
            result.add(new Space(size));
        }
        return result;
    }

    public List<Space> getSpaces() {
        return spaces;
    }
}
