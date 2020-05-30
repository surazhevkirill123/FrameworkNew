package AdditionalClasses;

import MainClasses.Toy;
import MainClasses.ToyRoom;

public class SelectionSort {
    public static void selectionSort(ToyRoom toyroom){//сортировка выбором
        Toy[] toys=toyroom.getToys();
     /*По очереди будем просматривать все подмножества
      элементов массива (0 - последний, 1-последний,
      2-последний,...)*/
        for (int i = 0; i < toys.length; i++) {
        /*Предполагаем, что первый элемент (в каждом
           подмножестве элементов) является минимальным */
            Toy min = toys[i];
            int min_i = i;
        /*В оставшейся части подмножества ищем элемент,
           который меньше предположенного минимума*/
            for (int j = i+1; j < toys.length; j++) {
                //Если находим, запоминаем его индекс
                if (toys[j].getCost() < min.getCost()) {
                    min = toys[j];
                    min_i = j;
                }
            }
        /*Если нашелся элемент, меньший, чем на текущей позиции,
          меняем их местами*/
            if (i != min_i) {
                Toy tmp = toys[i];
                toys[i] = toys[min_i];
                toys[min_i] = tmp;
            }
        }


    }
}
