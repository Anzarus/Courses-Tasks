package com.hillel.elementary.teamleaders.battleship;

public abstract class Player {
    private String name;
    private Field field;

    public Field getField() {
        return field;
    }

    public Player(String name, Field field) {
        this.field = field;
        this.name = name;
    }

    public HitStatus takeHit(int[] coord) {
        return field.takeHit(coord);
    }

    abstract int[] move(Player deffender);


    @Override
    public String toString() {
        return name;
    }

    public boolean allShipsAreSank() {
        return field.allShipsAreSank();
    }
}
