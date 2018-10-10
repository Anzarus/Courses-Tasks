package com.hillel.elementary.teamleaders.matrix_rotation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MatrixRotationTest {

    @Test
    public void shouldRotateMatrix90grad() {
        int[][] matrix4x4 ={{1,2,3,4},
                            {2,2,3,4},
                            {3,3,3,4},
                            {4,4,4,4}};
        int[][] matrixExpected4x4 ={{4,4,4,4},
                                    {3,3,3,4},
                                    {2,2,3,4},
                                    {1,2,3,4}};

        int[][] matrix5x5 ={{1,2,3,4,5},
                            {2,2,3,4,5},
                            {3,3,3,4,5},
                            {4,4,4,4,5},
                            {5,5,5,5,5}};
        int[][] matrixExpected5x5 ={{5,5,5,5,5},
                                    {4,4,4,4,5},
                                    {3,3,3,4,5},
                                    {2,2,3,4,5},
                                    {1,2,3,4,5}};

        MatrixRotation.rotation90grad(matrix4x4);
        MatrixRotation.matrixPrint(matrix4x4);


        MatrixRotation.rotation90grad(matrix5x5);
        MatrixRotation.matrixPrint(matrix5x5);

        assertArrayEquals(matrixExpected4x4,matrix4x4);
        assertArrayEquals(matrixExpected5x5,matrix5x5);

    }
    @Test
    public void shouldRotateMatrix180grad() {
        int[][] matrix4x4 ={{1,2,3,4},
                            {2,2,3,4},
                            {3,3,3,4},
                            {4,4,4,4}};
        int[][] matrixExpected4x4 ={{4,4,4,4},
                                    {4,3,3,3},
                                    {4,3,2,2},
                                    {4,3,2,1}};

        int[][] matrix5x5 ={{1,2,3,4,5},
                            {2,2,3,4,5},
                            {3,3,3,4,5},
                            {4,4,4,4,5},
                            {5,5,5,5,5}};
        int[][] matrixExpected5x5 ={{5,5,5,5,5},
                                    {5,4,4,4,4},
                                    {5,4,3,3,3},
                                    {5,4,3,2,2},
                                    {5,4,3,2,1}};

        MatrixRotation.rotation180grad(matrix4x4);
        MatrixRotation.matrixPrint(matrix4x4);
        System.out.println();


        MatrixRotation.rotation180grad(matrix5x5);
        MatrixRotation.matrixPrint(matrix5x5);

        assertArrayEquals(matrixExpected4x4,matrix4x4);
        assertArrayEquals(matrixExpected5x5,matrix5x5);

    }
    @Test
    public void shouldRotateMatrix270grad() {
        int[][] matrix4x4 ={{1,2,3,4},
                            {2,2,3,4},
                            {3,3,3,4},
                            {4,4,4,4}};
        int[][] matrixExpected4x4 ={{4,3,2,1},
                                    {4,3,2,2},
                                    {4,3,3,3},
                                    {4,4,4,4}};

        int[][] matrix5x5 ={{1,2,3,4,5},
                            {2,2,3,4,5},
                            {3,3,3,4,5},
                            {4,4,4,4,5},
                            {5,5,5,5,5}};
        int[][] matrixExpected5x5 ={{5,4,3,2,1},
                                    {5,4,3,2,2},
                                    {5,4,3,3,3},
                                    {5,4,4,4,4},
                                    {5,5,5,5,5}};

        MatrixRotation.rotation270grad(matrix4x4);
        MatrixRotation.matrixPrint(matrix4x4);


        MatrixRotation.rotation270grad(matrix5x5);
        MatrixRotation.matrixPrint(matrix5x5);

        assertArrayEquals(matrixExpected4x4,matrix4x4);
        assertArrayEquals(matrixExpected5x5,matrix5x5);

    }
}
