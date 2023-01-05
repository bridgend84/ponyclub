package org.example.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pony {
    protected String name;
    protected int xp;
    protected Coordinate position;

    public Pony(String name, int xp, Coordinate position) {
        this.name = name;
        this.xp = xp;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getXp() {
        return xp;
    }

    public Coordinate getPosition() {
        return position;
    }

    public void walk() {
        Random random = new Random();
        List<Coordinate> possibleCoordinates = new ArrayList<>();
        for (int y = position.y() - 1; y <= position.y() + 1; y++) {
            for (int x = position.x() - 1; x <= position.x() + 1; x++) {
                possibleCoordinates.add(new Coordinate(x, y));
            }
        }
        possibleCoordinates = possibleCoordinates
                .stream()
                .filter(coordinate -> coordinate.x() != position.x() && coordinate.y() != position.y())
                .toList();
        position = possibleCoordinates.get(random.nextInt(possibleCoordinates.size()));
    }

    public void rename(String name) {
        this.name = name;
    }
}
