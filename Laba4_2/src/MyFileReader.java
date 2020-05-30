import java.io.*;


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

            System.out.println("Файл не найден");
        } catch (IOException e) {
            System.out.println("Операция ввода-вывода завершилась неудачно или прервана");

        }
        return Line;
    }

    // построчное считывание файла
    public static void main(String[] args) {

        System.out.println(MyFileReader.fileRead("file.txt"));
    }

}