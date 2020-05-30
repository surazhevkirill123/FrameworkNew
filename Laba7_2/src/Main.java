import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    private String text=MyFileReader.fileRead("file.txt");

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public static boolean isPalindrom(String word) {
        char[] wordToArray = word.toCharArray();
        int flag=0;
        for(int i=0,j=wordToArray.length-1;i<wordToArray.length && j>0;i++,j--) {
           if(wordToArray[i]!=wordToArray[j])
               flag++;
        }
        if(flag==0) {
            return true;
        }
        else
            return false;
    }
    public static String longestPalindrom(String longSentence) {
        String longestPalindrom="";
        for (int i=0;i<longSentence.length()-3;i++)
            for (int j=i+3;j<longSentence.length()+1;j++) {
                if(isPalindrom(longSentence.substring(i,j)) && longSentence.substring(i,j).length()>longestPalindrom.length())
                    longestPalindrom=longSentence.substring(i,j);
            }
        return longestPalindrom;
    }

    public static String cleaningFromSpacesAndTabulations(String sentence) {
        String[] sentences = sentence.trim().split("[\\n]+");
        for (int i=0;i<sentences.length;i++)
        {
            String[]words=sentences[i].split("[\\s\\t]+");
            sentences[i]=String.join(" ",words);
        }
        String cleanedSentence=String.join("\n",sentences);
        return cleanedSentence;
    }

    public static void main(String[] args) throws IOException {
        Main object=new Main();
        String text=object.getText();
        System.out.println("Исходный (полученный getter-ом) текст: ");
        System.out.println(text);
        System.out.println("Текст, очищенный от множественных пробелов и табуляций: ");
        System.out.println(cleaningFromSpacesAndTabulations(text));
        System.out.println("Наибольший палиндром: ");
        System.out.println("["+longestPalindrom(text)+"]");
        object.setText("sbchbsc");
        text=object.getText();
        System.out.println("Изменённый(setter-ом) текст: ");
        System.out.println(text);
    }
}