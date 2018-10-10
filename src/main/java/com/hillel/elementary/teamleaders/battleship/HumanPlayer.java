package com.hillel.elementary.teamleaders.battleship;

import java.util.Scanner;

public class HumanPlayer extends Player {

    public HumanPlayer(String name, Field field) {
        super(name, field);
    }

    @Override
    int[] move(Player defender) {
        Scanner scanner = new Scanner(System.in);
        boolean invalidCoords = true;
        int x = 0;
        int y = 0;
        while (invalidCoords) {
            System.out.println("Choose a coordinates(numb letter):");

            x = scanner.nextInt() - 1;

            String yStr = scanner.next();
            y = ordinatesTranslate(yStr) - 1;

            if (x < 0 || x > 9 || y < 0 || y > 9) {
                System.out.println("Invalid coordinates");
            } else {
                invalidCoords = false;
            }
        }
        return new int[]{x, y};
    }

    private int ordinatesTranslate(String y) {
        int value = 0;
        char symbol = y.toLowerCase().charAt(0);
        if (y.length() == 1 && symbol >= 'a' && symbol <= 'j') {
            switch (symbol) {
                case 'a':
                    value = 1;
                    break;
                case 'b':
                    value = 2;
                    break;
                case 'c':
                    value = 3;
                    break;
                case 'd':
                    value = 4;
                    break;
                case 'e':
                    value = 5;
                    break;
                case 'f':
                    value = 6;
                    break;
                case 'g':
                    value = 7;
                    break;
                case 'h':
                    value = 8;
                    break;
                case 'i':
                    value = 9;
                    break;
                case 'j':
                    value = 10;
            }
        }
        return value;
    }
}
