package com.company;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
import org.apache.commons.io.FileUtils;
/**
 * Class for finding a number in which the numbers are in ascending order.
 * @author Surazhev Kirill
 * @version 1.1
 */

public class Main {

    /**
     * Ascend Check Function
     */
    public static boolean check(int num) {
        String str = Integer.toString(num); // converts num into String
        char[] ch = str.toCharArray();// gets str1 into an array of char
        int[] t = new int[ch.length];// defines t1 for bringing ch1 into it
        for(int i=0;i<ch.length;i++) // watch the ASCII table
            t[i]= (int) ch[i]-48;// ch1[i] is 48 units more than what we want
        int flag=0;
        for(int i=0;i<ch.length-1;i++){
            if(t[i+1]<=t[i]){
                flag++;
            }
        }
        if (flag==0 && str.length()!=1)
            return true;
        else if(flag==0 && str.length()==1)
            return false;
        else
            return false;
    }



    /**
     * Main Function

     */
    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество чисел: ");
        int n = in.nextInt();
        int[] myArray = new int[n];
        System.out.print("Введите числа: ");
        for(int i=0;i<n;i++) {
            myArray[i]=in.nextInt();
        }
        int flag=0;
        for(int i=0;i<n;i++) {
            if(check(myArray[i])){
                System.out.println(myArray[i]);
                flag=1;
                break;
            }
        }
        if(flag!=1)
        {
            System.out.println("Таких чисел нет");
        }

        System.out.println("Фамилия студента: Суражев");
        System.out.println("Дата получения задания: 15.02.2020");
        System.out.println("Время получения задания: 13:40");

        System.out.print("Дата сдачи задания: ");
        Date date=new Date();
        System.out.println(date.toString());
        in.close();

    }
}

