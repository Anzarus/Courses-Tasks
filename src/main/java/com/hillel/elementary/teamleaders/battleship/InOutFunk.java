package com.hillel.elementary.teamleaders.battleship;

import java.util.Scanner;

public class InOutFunk {

    public static String setPlayerName() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please print your name:");
        return scan.next();
    }

    public static int setDifficult() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose difficult(1-easy; 2-medium):");
        return scan.nextInt();
    }

    public static String printFields(Player human, Player pc) {
        Cell[][] humanCells = human.getField().getCells();
        Cell[][] pcCells = pc.getField().getCells();
        StringBuilder stringBuilder = new StringBuilder();

        headPrint(stringBuilder);

        for (int i = 0; i < humanCells.length; i++) {
            stringBuilder.append(i + 1).append("\t");
            analiseCellToPrint(humanCells, stringBuilder, i, false);
            stringBuilder.append("\t\t\t\t");
            stringBuilder.append(i + 1).append("\t");
            analiseCellToPrint(pcCells, stringBuilder, i, true);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    private static void headPrint(StringBuilder stringBuilder) {
        stringBuilder.append("\tA B C D E F G H I J");
        stringBuilder.append("\t\t\t\t\t\tA B C D E F G H I J\n");
    }

    private static void analiseCellToPrint(Cell[][] playerCell, StringBuilder stringBuilder, int i, boolean isOponent) {
        for (int j = 0; j < playerCell[i].length; j++) {
            switch ((playerCell[i][j].getStatus())) {
                case CLEAR:
                    stringBuilder.append("~ ");
                    break;
                case TRY_TO_SKIP:
                    stringBuilder.append("~ ");
                    break;
                case HIT:
                    stringBuilder.append("• ");
                    break;
                case SHIP:
                    if (isOponent) {
                        stringBuilder.append("~ ");
                    } else {
                        stringBuilder.append("■ ");
                    }
                    break;
                case SHIP_HIT:
                    stringBuilder.append("× ");
                    break;
            }
        }
    }
}
