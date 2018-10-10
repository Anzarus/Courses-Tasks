package com.hillel.elementary.teamleaders.battleship;
import java.util.Random;

public class ShipCreator {
    private Random random = new Random();

    public void createShip(Cell[][] cells, int shipSize) {
        int[][] shipCoords = generateNext(cells, shipSize);
        while (shipCoords == null) {
            shipCoords = generateNext(cells, shipSize);
        }

        Ship ship = new Ship(shipSize);

        for (int i = 0; i < shipSize; i++) {
            cells[shipCoords[i][0]][shipCoords[i][1]].setIsPartOfShip(true);
            cells[shipCoords[i][0]][shipCoords[i][1]].setStatus(CellStatus.SHIP);
            cells[shipCoords[i][0]][shipCoords[i][1]].setShip(ship);
        }
    }

    private int[][] generateNext(Cell[][] cells, int shipSize) {
        int[][] shipCoords = null;
        int startingX = random.nextInt(10);
        int startingY = random.nextInt(10);

        int orientation = random.nextInt(2);


        if (!cells[startingX][startingY].getIsPartOfShip()) {
            shipCoords = fillShipCoords(shipSize, startingX, startingY, orientation);
            if (cannotBePlaced(cells, shipCoords)) shipCoords = null;
        }

        return shipCoords;
    }

    private int[][] fillShipCoords(int shipSize, int startingX, int startingY, int orientation) {
        int[][] shipCoords;
        shipCoords = new int[shipSize][2];
        shipCoords[0][0] = startingX;
        shipCoords[0][1] = startingY;

        switch (orientation) {
            case 0:
                if (startingX - shipSize >= 0) {
                    for (int i = 1; i < shipSize; i++) {
                        shipCoords[i][0] = startingX - i;
                        shipCoords[i][1] = startingY;
                    }
                } else if (startingX + shipSize < 10) {
                    for (int i = 1; i < shipSize; i++) {
                        shipCoords[i][0] = startingX + i;
                        shipCoords[i][1] = startingY;
                    }
                }
                break;
            case 1:
                if (startingY - shipSize >= 0) {
                    for (int i = 1; i < shipSize; i++) {
                        shipCoords[i][0] = startingX;
                        shipCoords[i][1] = startingY - i;
                    }
                } else if (startingY + shipSize < 10) {
                    for (int i = 1; i < shipSize; i++) {
                        shipCoords[i][0] = startingX;
                        shipCoords[i][1] = startingY + i;
                    }
                }
        }
        return shipCoords;
    }

    private boolean cannotBePlaced(Cell[][] cells, int[][] shipCoords) {
        for (int[] shipCoord : shipCoords) {
            int x = shipCoord[0];
            int y = shipCoord[1];

            if (cells[x][y].getIsPartOfShip()) {
                return true;
            }
            if (x > 0 && cells[x - 1][y].getIsPartOfShip()) {
                return true;
            }
            if (x < 9 && cells[x + 1][y].getIsPartOfShip()) {
                return true;
            }
            if (y > 0 && cells[x][y - 1].getIsPartOfShip()) {
                return true;
            }
            if (y < 9 && cells[x][y + 1].getIsPartOfShip()) {
                return true;
            }

            if (x > 0 && y > 0 && cells[x - 1][y - 1].getIsPartOfShip()) {
                return true;
            }
            if (x < 9 && y < 9 && cells[x + 1][y + 1].getIsPartOfShip()) {
                return true;
            }
            if (x < 9 && y > 0 && cells[x + 1][y - 1].getIsPartOfShip()) {
                return true;
            }
            if (x > 0 && y < 9 && cells[x - 1][y + 1].getIsPartOfShip()) {
                return true;
            }
        }
        return false;
    }
}