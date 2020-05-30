package RealTheads;

import AdditionalClasses.SelectionSort;

import static RealTheads.DemoThreadApp.toyRoom;

public class SortingThread implements Runnable {
    @Override
    public void run() {
        SelectionSort.selectionSort(toyRoom);
        System.out.println("Игровая комната после сортировки:");
        System.out.println(toyRoom.toString());
        System.out.println("Поток, отвечающий за сортировку комнаты, отработал");
    }
}
