package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Main {
    public static ArrayList<String> getList(String filePath) throws FileNotFoundException {
        ArrayList<String> list = new ArrayList<>();
        new BufferedReader(new FileReader(filePath)).lines().forEach(list::add);
        return list;
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Список строк из файла:");
        ArrayList<String> myList=getList("file.txt");
        System.out.println(myList.toString());
        Collections.sort(myList);
        System.out.println("Список, отсортрованный с помощью Collections.sort:");
        System.out.println(myList.toString());


    }
}