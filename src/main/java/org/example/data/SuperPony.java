package org.example.data;

import java.util.List;
import java.util.Random;

public class SuperPony extends Pony implements Fly, Magic{

    public SuperPony(String name, int xp, Coordinate position) {
        super(name, xp, position);
        List<String> magicCharacters = List.of("*", "#", "&");
        Random random = new Random();
        this.name = name + magicCharacters.get(random.nextInt(magicCharacters.size()));
    }

    @Override
    public void fly(Coordinate coordinate) {
        this.position = coordinate;
    }

    @Override
    public void magic() {
        this.xp++;
    }
}
