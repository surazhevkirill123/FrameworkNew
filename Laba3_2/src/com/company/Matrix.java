package com.company;

import java.util.Collections;
import java.util.Random;

class BooleanMatrix {
    private int n,m;
    private boolean[][] firstMatrix, secondMatrix;

    BooleanMatrix(int nSize, int mSize) {
        n = nSize;
        m = mSize;
        firstMatrix = new boolean[n][m];
        secondMatrix = new boolean[n][m];
    }

    private void fillMatrixByRandom(boolean[][] matrix) { // Заполнение матрицы
        Random rand = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = rand.nextInt() % 2 == 0;
            }
        }
    }

    private void printMatrix(boolean[][] matrix, String name) { // Печать матрицы
        System.out.println(name);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private void inverseMatrix(boolean[][] matrix) { // Инверсия матрицы (отрицание)
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = !matrix[i][j];
            }
        }
        System.out.println();
    }

    private void sortingMatrix(boolean[][] matrix) { // Лексикографическое упорядочение строк
        boolean[]b3;
        for (int i = 0; i < matrix.length-1; i++)
            for (int k = i+1; k < matrix.length; k++)
        {
            for (int j = 0; j < matrix[i].length; j++)
                {
                    if(matrix[i][j]==false && matrix[k][j]==true && i!=k)
                    {
                        b3=matrix[i];
                        matrix[i]=matrix[k];
                        matrix[k]=b3;
                    }

            }
        }

    }



    private boolean[][] foldMatrix(boolean[][] matrix ,boolean[][] foldedMatrix) { // Сложение матриц
        boolean[][] foldResult = new boolean[n][m];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                foldResult[i][j] = matrix[i][j] | foldedMatrix[i][j];
            }
        }
        System.out.println();
        return foldResult;
    }

    private boolean[][] multMatrix(boolean[][] matrix ,boolean[][] multedMatrix) { // Умножение матриц
        boolean[][] multResult = new boolean[n][m];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                multResult[i][j] = matrix[i][j] && multedMatrix[i][j];
            }
        }
        System.out.println();
        return multResult;
    }

    private void odinMatrix(boolean[][] matrix, String name){
        System.out.print(name + " ");
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++)
            {
                if (matrix[i][j]) count++;
            }
        }
        System.out.println(count);
    }

    void run() {
        fillMatrixByRandom(firstMatrix);
        printMatrix(firstMatrix, "Первая матрица");
        odinMatrix(firstMatrix, "Количество единиц в первой матрице");
        fillMatrixByRandom(secondMatrix);
        printMatrix(secondMatrix, "Вторая матрица");
        inverseMatrix(firstMatrix);
        printMatrix(firstMatrix, "Первая матрица после инверсии");
        inverseMatrix(secondMatrix);
        printMatrix(secondMatrix, "Вторая матрица после инверсии");
        printMatrix(foldMatrix(firstMatrix,secondMatrix), "Результат сложения двух инвертированных матриц");
        printMatrix(multMatrix(firstMatrix,secondMatrix), "Результат умножения двух инвертированных матриц");
        printMatrix(firstMatrix,"неотсортированная матрица");
        sortingMatrix(firstMatrix);
        printMatrix(firstMatrix,"отсортированная матрица");


    }

}

public class Matrix {
    public static void main(String[] args) {
        BooleanMatrix matrix = new BooleanMatrix(5,5);
        matrix.run();
    }

}
