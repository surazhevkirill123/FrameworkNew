package RealTheads;

import MainClasses.Toy;

import java.util.ArrayList;

import static MainClasses.ToyRoom.findToysByCost;
import static RealTheads.DemoThreadApp.toyRoom;

public class FindToysByCostThread implements Runnable {
    @Override
    public void run() {
        System.out.println("Найденные по диапазону цен игрушки:");
        ArrayList<Toy> foundedToys=findToysByCost(toyRoom,50,100);
        System.out.println(foundedToys.toString());
        System.out.println("Поток для нахождения игрушек в заданном диапазоне отработал");
    }
}
