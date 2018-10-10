package com.hillel.elementary.teamleaders.battleship;

import java.util.Random;

import static com.hillel.elementary.teamleaders.battleship.CellStatus.*;

public class PcPlayer extends Player {

    private Random random = new Random();

    public PcPlayer(String name, Field field) {
        super(name, field);
    }

    @Override
    int[] move(Player defender) {
        int x = random.nextInt(10);
        int y = random.nextInt(10);

        while (checkIsHitted(defender, x, y)) {
            x = random.nextInt(10);
            y = random.nextInt(10);
        }
        return new int[]{x, y};
    }

    private boolean checkIsHitted(Player defender, int x, int y) {
        Cell[][] cells = defender.getField().getCells();
        return cells[x][y].getStatus() == HIT
                || cells[x][y].getStatus() == SHIP_HIT
                || cells[x][y].getStatus() == TRY_TO_SKIP;
    }
}
