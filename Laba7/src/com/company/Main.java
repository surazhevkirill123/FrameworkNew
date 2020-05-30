package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        List <String> sShortWordsList = new ArrayList <String> ();
        List <String> sLongWordsList = new ArrayList <String> ();
        System.out.println("Введите текст: ");
        String text=MyFileReader.fileRead("file.txt");
        String[] sSentencesWords=text.trim().split("[\\s.,?!\\n\\r]+");
        int minimalWordLength = sSentencesWords[0].length();
        for (String currentWord : sSentencesWords) {
            if (minimalWordLength > currentWord.length()) {
                minimalWordLength = currentWord.length();
                sShortWordsList.clear();
                sShortWordsList.add(currentWord);
            } else if (minimalWordLength == currentWord.length()) {
                sShortWordsList.add(currentWord);
            }
        }

        int maximumWordLength = sSentencesWords[0].length();
        for (String currentWord : sSentencesWords) {
            if (maximumWordLength < currentWord.length()) {
                maximumWordLength = currentWord.length();
                sLongWordsList.clear();
                sLongWordsList.add(currentWord);
            } else if (maximumWordLength == currentWord.length()) {
                sLongWordsList.add(currentWord);
            }
        }
        System.out.println("Самые короткие слова: ");
        System.out.println(Arrays.toString(sShortWordsList.toArray()));
        System.out.println("Самые длинные слова: ");
        System.out.println(Arrays.toString(sLongWordsList.toArray()));
    }
}