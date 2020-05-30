package com.company;

/*В каждой строке стихотворения Сергея Есенина подсчитать частоту повторяемости каждого слова из заданного списка и вывести эти слова в порядке
возрастания частоты повторяемости*/

import java.io.IOException;
import java.util.*;

public class Main {

    public static void selectionSort(int[] arr){//сортировка выбором
    /*По очереди будем просматривать все подмножества
      элементов массива (0 - последний, 1-последний,
      2-последний,...)*/
        for (int i = 0; i < arr.length; i++) {
        /*Предполагаем, что первый элемент (в каждом
           подмножестве элементов) является минимальным */
            int min = arr[i];
            int min_i = i;
        /*В оставшейся части подмножества ищем элемент,
           который меньше предположенного минимума*/
            for (int j = i+1; j < arr.length; j++) {
                //Если находим, запоминаем его индекс
                if (arr[j] < min) {
                    min = arr[j];
                    min_i = j;
                }
            }
        /*Если нашелся элемент, меньший, чем на текущей позиции,
          меняем их местами*/
            if (i != min_i) {
                int tmp = arr[i];
                arr[i] = arr[min_i];
                arr[min_i] = tmp;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String text=MyFileReader.fileRead("file.txt");//читаем текст из файла
        String[] words = text.trim().split("\\s"); // Разбиение строки на слова с помощью разграничителя (пробел)
        String[] listForChecking={"Ты","В","Я","что","и"};//заданный список слов
        int[] listWithIndexesDuringChecking=new int[listForChecking.length];//массив, хранящий кол-во вхождений слов из listForChecking в text

        //заполнение массива listWithIndexesDuringChecking
        for(int i=0;i<words.length;i++){
            for(int j=0;j<listForChecking.length;j++){
                if (words[i].compareTo(listForChecking[j])==0) {
                    listWithIndexesDuringChecking[j]++;
                }
            }
        }

        //Выводим слова из списка вместе с их количеством до сортировки
        System.out.println("Список слов до сортировки:");
        for (int i=0;i<listWithIndexesDuringChecking.length;i++) {
            System.out.println(listForChecking[i]+" - "+listWithIndexesDuringChecking[i]);
        }

        selectionSort(listWithIndexesDuringChecking);//сортировка

        //Выводим слова из списка вместе с их количеством после сортировки
        System.out.println("Список слов после сортировки:");
        for (int i=0;i<listWithIndexesDuringChecking.length;i++) {
            System.out.println(listForChecking[i]+" - "+listWithIndexesDuringChecking[i]);
        }

    }

}



