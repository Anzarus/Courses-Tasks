package com.hillel.elementary.teamleaders.matrix_rotation;

public class MatrixRotation {

    public static void rotation90grad(int[][] matrix) {
        int buffer;
        for (int k = 0; k < matrix.length / 2; k++) {
            for (int i = k; i < matrix.length - k - 1; i++) {
                buffer = matrix[k][i];
                matrix[k][i] = matrix[i][matrix.length - 1 - k];
                matrix[i][matrix.length - 1 - k] = matrix[matrix.length - 1 - k][matrix.length - 1 - i];
                matrix[matrix.length - 1 - k][matrix.length - 1 - i] = matrix[matrix.length - 1 - i][k];
                matrix[matrix.length - 1 - i][k] = buffer;
            }
        }
    }

    public static void rotation180grad(int[][] matrix) {
        int buffer;
        for (int k = 0; k < matrix.length / 2; k++) {
            for (int i = k; i < matrix.length - 1 - k; i++) {
                buffer = matrix[i][k];
                matrix[i][k] = matrix[matrix.length - 1 - i][matrix.length - 1 - k];
                matrix[matrix.length - 1 - i][matrix.length - 1 - k] = buffer;

                buffer = matrix[k][matrix.length - 1 - i];
                matrix[k][matrix.length - 1 - i] = matrix[matrix.length - 1 - k][i];
                matrix[matrix.length - 1 - k][i] = buffer;
            }
        }
    }

    public static void rotation270grad(int[][] matrix) {
        int buffer;
        for (int k = 0; k < matrix.length / 2; k++) {
            for (int i = k; i < matrix.length - k - 1; i++) {
                buffer = matrix[k][i];
                matrix[k][i] = matrix[matrix.length - 1 - i][k];
                matrix[matrix.length - 1 - i][k] = matrix[matrix.length - 1 - k][matrix.length - 1 - i];
                matrix[matrix.length - 1 - k][matrix.length - 1 - i] = matrix[i][matrix.length - 1 - k];
                matrix[i][matrix.length - 1 - k] = buffer;
            }
        }
    }

    public static void matrixPrint(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print("\t" + matrix[i][j]);
            }
            System.out.println();
        }
    }
}
