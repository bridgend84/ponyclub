package org.example.data;

import java.util.List;
import java.util.Random;

public class Unicorn extends Pony implements Magic{

    public Unicorn(String name, int xp, Coordinate position) {
        super(name, xp, position);
        List<String> magicCharacters = List.of("*", "#", "&");
        Random random = new Random();
        this.name = name + magicCharacters.get(random.nextInt(magicCharacters.size()));
    }

    @Override
    public void magic() {
        this.xp++;
    }
}
