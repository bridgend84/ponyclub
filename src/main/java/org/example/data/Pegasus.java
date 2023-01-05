package org.example.data;

public class Pegasus extends Pony implements Fly{

    public Pegasus(String name, int xp, Coordinate position) {
        super(name, xp, position);
    }

    @Override
    public void fly(Coordinate coordinate) {
        this.position = coordinate;
    }
}
