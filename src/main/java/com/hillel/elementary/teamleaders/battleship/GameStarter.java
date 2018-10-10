package com.hillel.elementary.teamleaders.battleship;

import java.util.Random;

import static com.hillel.elementary.teamleaders.battleship.InOutFunk.*;

public class GameStarter {
public static void main(String[] args) {
        String playerName = setPlayerName();
        int opponentDifficult = setDifficult();

        ShipCreator shipCreator = new ShipCreator();
        Field fieldOne = new Field(shipCreator, opponentDifficult);
        fieldOne.initializeRandomShips();
        Field fieldTwo = new Field(shipCreator, 0);
        fieldTwo.initializeRandomShips();

        Player user = new HumanPlayer(playerName, fieldOne);
        Player pc = new PcPlayer("PC", fieldTwo);

        gameInProcess(playerName, user, pc);
    }

    private static void gameInProcess(String playerName, Player user, Player pc) {
        Random random = new Random();
        boolean humanMovesFirst = random.nextBoolean();

        Player offender = humanMovesFirst ? user : pc;
        Player defender = humanMovesFirst ? pc : user;
        boolean gameInProgress = true;

        System.out.println("\t" + playerName + "`s\t\t\t\t\t\t\t\tPC`s field\n");
        System.out.print(printFields(user, pc) + "\n");

        while (gameInProgress) {
            StringBuffer moveStatus = new StringBuffer();
            System.out.println(offender.toString() + "`s MOVE");
            int[] move = offender.move(defender);
            switch (defender.takeHit(move)) {
                case HIT:
                    moveStatus.append(defender).append(" TOOK A HIT!");
                    break;
                case SINKED:
                    moveStatus.append("\t\t").append(defender).append("'s SHIP SANK!");
                    if (defender.allShipsAreSank()) {
                        gameInProgress = false;
                        moveStatus.append("\n").append(offender).append(" is a WINNER!");
                    }
                    break;
                case MISSED:
                    moveStatus.append("\t\t\t\t\t").append(offender).append(" MISS!");
                    Player tmp = offender;
                    offender = defender;
                    defender = tmp;
                    break;
            }
            System.out.print(printFields(user, pc) + "\n");
            System.out.println(moveStatus);
//            System.in.read();
        }
    }
}
