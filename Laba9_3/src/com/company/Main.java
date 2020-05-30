package com.company;
/*. Входной файл содержит совокупность строк. Строка файла содержит строку
квадратной матрицы. Ввести матрицу в двумерный массив (размер матрицы
найти). Вывести исходную матрицу и результат ее транспонирования.*/
import java.io.IOException;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        String text = MyFileReader.fileRead("file.txt");//читаем текст из файла
        String[] words = text.trim().split("\\s"); // Разбиение строки на слова с помощью разграничителя (пробел)
        int n=(int)Math.sqrt(words.length);//длина и ширина двумерной матрицы
        String[][]matrixWords=new String[n][n];//двумерная массив-матрица типа String

        //заполнение matrixWords
        int l=0;
        for (int i=0;i<n;i++)
            for (int j=0;j<n;j++) {
                matrixWords[i][j]=words[l];
                l++;
            }

        //заполнение matrixNumbers
        int[][]matrixNumbers=new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrixNumbers[i][j]=Integer.parseInt(matrixWords[i][j]);
            }
        }
        //Матрица, считанная с файла
        System.out.println("Матрица, считанная с файла: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrixNumbers[i][j]+" ");
            }
            System.out.println();
        }
        Transpose.transpose(matrixNumbers);//транспонирование
        //Транспонированная матрица
        System.out.println("Транспонированная матрица: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrixNumbers[i][j]+" ");
            }
            System.out.println();
        }
        String[][]transposedMatrixWords=new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                transposedMatrixWords[i][j]=String.valueOf(matrixNumbers[i][j]);
            }
        }
        String[]transposedMatrixSentences=new String[n];
        for (int i = 0; i < n; i++) {
            transposedMatrixSentences[i]=String.join(" ",transposedMatrixWords[i]);
        }
        String transposedMatrixText=String.join("\n",transposedMatrixSentences);
        System.out.println(transposedMatrixText);
        CreateDirectoryExample.createDirectory("E:\\STUDIES\\PROGA2kurs\\4sem\\IntelijIdea\\Laba9_3\\myDir");
        CreateNewFile.createFileWithPathAndText("E:\\STUDIES\\PROGA2kurs\\4sem\\IntelijIdea\\Laba9_3\\myDir\\file.txt",transposedMatrixText);
    }

}



