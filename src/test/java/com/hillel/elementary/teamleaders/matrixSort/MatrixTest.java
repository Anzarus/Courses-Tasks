package com.hillel.elementary.teamleaders.matrixSort;

import com.hillel.elementary.teamleaders.menu_class.MenuClass;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {
    @Test
    void shouldSortMatrixByColumnElements() {
        int[][] matrix = {{9, 1, 2}, {8, 3, 4}, {7, 5, 6}};
        int[][] matrixResult = {{7, 5, 6}, {8, 3, 4}, {9, 1, 2}};
        int n = 3, position = 0;

        Matrix.sortMatrixByColumnElements(matrix, n, position);

        assertArrayEquals(matrixResult, matrix);
    }

    @Test
    void shouldSortMatrixByStringElements() {
        int[][] matrix = {{3, 2, 1}, {2, 3, 4}, {1, 5, 6}};
        int[][] matrixResult = {{1, 2, 3}, {4, 3, 2}, {6, 5, 1}};
        int n = 3, position = 0;

        Matrix.sortMatrixByStringElements(matrix, n, position);

        assertArrayEquals(matrixResult, matrix);
    }

    @Test
    void shouldPrintMatrix() {
        int[][] matrix = {{3, 2, 1}, {2, 3, 4}, {1, 5, 6}};
        int n = 3;
        String expectedPrint = "3\t2\t1\t\n2\t3\t4\t\n1\t5\t6\t\n";

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Matrix.printMatrix(matrix, n);

        assertEquals(expectedPrint, outContent.toString());
    }

    @Test
    void shouldCheckStarterSorting() {
        MenuClass menu = new MenuClass("y", 4, 10);
        boolean sortingMenu = true;
        int expected = 0;
        int actual = Matrix.starterSorting(sortingMenu, menu);

        assertEquals(expected, actual);
    }
}