package com.hillel.elementary.teamleaders.battleship;

public class Ship {
    private int size;
    private int lives;

    public Ship(int size) {
        this.size = size;
        this.lives = size;
    }

    public int getSize() {
        return size;
    }

    public int hit() {
        return --lives;
    }

    public boolean isAlive() {
        return lives > 0;
    }
}
