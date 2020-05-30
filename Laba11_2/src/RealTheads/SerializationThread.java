package RealTheads;

import MainClasses.Toy;
import MainClasses.ToyRoom;

import java.io.*;

import static RealTheads.DemoThreadApp.toyRoom;

public class SerializationThread implements Runnable {
    @Override
    public void run() {
        ToyRoom toyRoom1 = toyRoom;
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream("objects.dat"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.writeObject(toyRoom1);//запись найденной игрушки в objects.dat с помощью сериализации
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Запись найденной игрушки в objects.dat с помощью сериализации...есть");
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream("objects.dat"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        toyRoom1 = null;//чтение найденной игрушки в objects.dat с помощью сериализации
        try {
            toyRoom1 = (ToyRoom) in.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Чтение найденной игрушки в objects.dat с помощью сериализации:");
        System.out.println(toyRoom1.toString());
        System.out.println("Поток, отвечающий за сериализацию, отработал");
    }
}
