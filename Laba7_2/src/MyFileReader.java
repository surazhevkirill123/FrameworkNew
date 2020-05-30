import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;


public class MyFileReader {

    public static String fileRead(String path) {
        String Line="";
        try {
            File file = new File(path);
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            while (line != null) {
                Line+=line;
                Line+="\n";
                // считываем остальные строки в цикле
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Line;
    }

    // построчное считывание файла
    public static void main(String[] args) {

        System.out.println(MyFileReader.fileRead("file.txt"));
    }

}

