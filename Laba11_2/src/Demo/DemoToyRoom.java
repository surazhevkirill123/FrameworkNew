package Demo;

import AdditionalClasses.MyFileReader;
import AdditionalClasses.SelectionSort;
import MainClasses.Toy;
import MainClasses.ToyRoom;
import MyExceptions.MyException;

import java.io.*;
import java.util.ArrayList;

import static MainClasses.ToyRoom.findToysByCost;
import static MainClasses.ToyRoom.getToyTypeFromString;

public class DemoToyRoom {
    public static void main(String[]args) throws MyException, IOException, ClassNotFoundException {


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
        for (int i=0;i<toys.length;i++){

            try {
                System.out.println(toys[i].toString());
            }catch (NullPointerException exception) {
                try {
                    MyException exception1=new MyException("В файле есть незаполненные поля, поэтому мы не можем правильно вывести все объекты, исправьте");
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
        SelectionSort.selectionSort(toyRoom1);
        System.out.println("Игровая комната после сортировки:");
        System.out.println(toyRoom1.toString());
        System.out.println("Найденные по диапазону цен игрушки:");
        ArrayList<Toy> foundedToys=findToysByCost(toyRoom1,50,100);
        System.out.println(foundedToys.toString());
        Toy foundedToy=foundedToys.get(0);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("objects.dat"));
        out.writeObject(foundedToy);//запись найденной игрушки в objects.dat с помощью сериализации
        System.out.println("Запись найденной игрушки в objects.dat с помощью сериализации...есть");
        out.close();
        ObjectInputStream in = new ObjectInputStream (new FileInputStream("objects.dat"));
        Toy foundedToy1=(Toy)in.readObject();//чтение найденной игрушки в objects.dat с помощью сериализации
        System.out.println("Чтение найденной игрушки в objects.dat с помощью сериализации:");
        System.out.println(foundedToy1.toString());



    }
}
