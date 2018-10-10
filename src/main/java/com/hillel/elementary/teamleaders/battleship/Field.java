package com.hillel.elementary.teamleaders.battleship;

import static com.hillel.elementary.teamleaders.battleship.CellStatus.*;
import static com.hillel.elementary.teamleaders.battleship.HitStatus.*;

public class Field {
    private Cell[][] cells = new Cell[10][10];
    private ShipCreator shipCreator;
    private int opponentDifficult;

    public Cell[][] getCells() {
        return cells;
    }

    public Field(ShipCreator shipCreator, int opponentDifficult) {
        this.shipCreator = shipCreator;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                cells[i][j] = new Cell();
            }
        }
        this.opponentDifficult = opponentDifficult;
    }

    public void initializeRandomShips() {
        shipCreator.createShip(cells, 4);
        shipCreator.createShip(cells, 3);
        shipCreator.createShip(cells, 3);
        shipCreator.createShip(cells, 2);
        shipCreator.createShip(cells, 2);
        shipCreator.createShip(cells, 2);
        shipCreator.createShip(cells, 2);
        shipCreator.createShip(cells, 1);
        shipCreator.createShip(cells, 1);
        shipCreator.createShip(cells, 1);
        shipCreator.createShip(cells, 1);
//        shipCreator.createShip(cells, 4);
//        shipCreator.createShip(cells, 3);
//        shipCreator.createShip(cells, 2);
//        shipCreator.createShip(cells, 1);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\tA B C D E F G H I J\n\n");
        for (int i = 0; i < cells.length; i++) {
            stringBuilder.append(i + 1).append("\t");
            for (int j = 0; j < cells[i].length; j++) {
                switch ((cells[i][j].getStatus())) {
                    case CLEAR:
                        stringBuilder.append("~ ");
                        break;
                    case HIT:
                        stringBuilder.append("• ");
                        break;
                    case SHIP:
                        stringBuilder.append("■ ");
                        break;
                    case SHIP_HIT:
                        stringBuilder.append("× ");
                        break;
                }
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public HitStatus takeHit(int[] coord) {
        Ship ship = cells[coord[0]][coord[1]].getShip();
        if (ship == null) {
            cells[coord[0]][coord[1]].setStatus(CellStatus.HIT);
            return MISSED;
        } else {
            int livesLeft = ship.hit();
            cells[coord[0]][coord[1]].setStatus(CellStatus.SHIP_HIT);
            if (livesLeft <= 0) {
                if (opponentDifficult == 2)
                    pointNeighbors(coord);
                return SINKED;
            } else {
                if (opponentDifficult == 2)
                    pointNeighbors(coord);
                return HitStatus.HIT;
            }
        }
    }

    private void pointNeighbors(int[] coord) {
        int x = coord[0];
        int y = coord[1];
        if (x > 0 && cells[x - 1][y].getStatus() == CLEAR) {
            cells[x - 1][y].setStatus(TRY_TO_SKIP);
        }
        if (x < 9 && cells[x + 1][y].getStatus() == CLEAR) {
            cells[x + 1][y].setStatus(TRY_TO_SKIP);
        }
        if (y > 0 && cells[x][y - 1].getStatus() == CLEAR) {
            cells[x][y - 1].setStatus(TRY_TO_SKIP);
        }
        if (y < 9 && cells[x][y + 1].getStatus() == CLEAR) {
            cells[x][y + 1].setStatus(TRY_TO_SKIP);
        }

        if (x > 0 && y > 0 && cells[x - 1][y - 1].getStatus() == CLEAR) {
            cells[x - 1][y - 1].setStatus(TRY_TO_SKIP);
        }
        if (x < 9 && y < 9 && cells[x + 1][y + 1].getStatus() == CLEAR) {
            cells[x + 1][y + 1].setStatus(TRY_TO_SKIP);
        }
        if (x < 9 && y > 0 && cells[x + 1][y - 1].getStatus() == CLEAR) {
            cells[x + 1][y - 1].setStatus(TRY_TO_SKIP);
        }
        if (x > 0 && y < 9 && cells[x - 1][y + 1].getStatus() == CLEAR) {
            cells[x - 1][y + 1].setStatus(TRY_TO_SKIP);
        }
    }

    public boolean allShipsAreSank() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                Ship ship = cells[i][j].getShip();
                if (ship != null && ship.isAlive()) return false;
            }
        }
        return true;
    }
}
