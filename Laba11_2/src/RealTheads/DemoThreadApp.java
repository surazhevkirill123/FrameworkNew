package RealTheads;

import AdditionalClasses.MyFileReader;
import AdditionalClasses.SelectionSort;
import MainClasses.Toy;
import MainClasses.ToyRoom;
import MyExceptions.MyException;

import java.io.*;
import java.util.ArrayList;

import static MainClasses.ToyRoom.findToysByCost;
import static MainClasses.ToyRoom.getToyTypeFromString;

public class DemoThreadApp {
    public static ToyRoom toyRoom;
    public static void main(String[] args) throws MyException, IOException, ClassNotFoundException {


        String textWithObjectsOfClass= MyFileReader.fileRead("toys.txt");
        String[]objectsOfClass=textWithObjectsOfClass.split("[\\r\\n]+");
        Toy[]toys=new Toy[objectsOfClass.length];

        for (int i=0;i<objectsOfClass.length;i++)
        {
            try {
                String[] oneObject1 = objectsOfClass[i].trim().split("[\\s]+");
                toys[i] = new Toy(Double.parseDouble(oneObject1[0]), getToyTypeFromString(oneObject1[1]), oneObject1[2]);
            }catch (ArrayIndexOutOfBoundsException exception) {
                try {
                    MyException exception1=new MyException("В файле есть незаполненные поля, исправьте");
                    throw exception1;
                }
                catch (MyException e){
                    e.printStackTrace();

                }
            }

        }

        ToyRoom toyRoom1=new ToyRoom(toys);
        System.out.println("Игровая комната, считанная с файла:");
        System.out.println(toyRoom1.toString());

        toyRoom=toyRoom1;

        Thread mySortingThread=new Thread(new SortingThread());
        mySortingThread.start();
        Thread myFindToysByCostThread=new Thread(new FindToysByCostThread());
        myFindToysByCostThread.start();
        Thread SerializationThread=new Thread(new SerializationThread());
        SerializationThread.start();

        System.out.println("Главный поток завершён...");



    }
}

