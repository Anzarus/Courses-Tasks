package com.hillel.elementary.teamleaders.battleship;

public class Cell {
    private Ship ship;
    private boolean isPartOfShip;
    private CellStatus status = CellStatus.CLEAR;

    public CellStatus getStatus() {
        return status;
    }

    public void setStatus(CellStatus status) {
        this.status = status;
    }

    public boolean getIsPartOfShip() {
        return isPartOfShip;
    }

    public void setIsPartOfShip(boolean partOfShip) {
        this.isPartOfShip = partOfShip;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }
}
