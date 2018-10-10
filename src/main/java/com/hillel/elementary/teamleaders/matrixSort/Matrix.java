package com.hillel.elementary.teamleaders.matrixSort;

import com.hillel.elementary.teamleaders.menu_class.MenuClass;

class Matrix {
    public static int starterSorting(boolean sortingMenu, MenuClass menu) {
        int position = menu.getPosition();
        int n = menu.getSizeOfMatrix();

        int[][] matrix = new int[n][n];

        randMatrix(matrix, n);
        printMatrix(matrix, n);

        System.out.println();

        if (sortingMenu) {
            sortMatrixByStringElements(matrix, n, position);
        } else {
            sortMatrixByColumnElements(matrix, n, position);
        }
        printMatrix(matrix, n);

        return 0;
    }

    public static void printMatrix(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void randMatrix(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = -n + (int) (Math.random() * 2 * n);
            }
        }
    }

    public static void sortMatrixByColumnElements(int matrix[][], int n, int position) {
        int wall = 0;
        int matrixBuff;
        while (wall < n) {
            for (int i = wall; i < n; i++) {
                if (matrix[i][position] < matrix[wall][position]) {
                    for (int j = 0; j < n; j++) {
                        matrixBuff = matrix[wall][j];
                        matrix[wall][j] = matrix[i][j];
                        matrix[i][j] = matrixBuff;
                    }
                }
                if (i == n - 1) {
                    wall++;
                }
            }
        }
    }

    public static void sortMatrixByStringElements(int matrix[][], int n, int position) {
        int wall = 0;
        int matrixBuff;
        while (wall < n) {
            for (int i = wall; i < n; i++) {
                if (matrix[position][i] < matrix[position][wall]) {
                    for (int j = 0; j < n; j++) {
                        matrixBuff = matrix[j][wall];
                        matrix[j][wall] = matrix[j][i];
                        matrix[j][i] = matrixBuff;
                    }
                }
                if (i == n - 1) {
                    wall++;
                }
            }
        }
    }
}