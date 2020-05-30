package Theads;

import Enums.ToyType;
import MainClasses.Toy;

class Something			//Нечто, реализующее интерфейс Runnable
        implements Runnable		//(содержащее метод run())
{
    public void run()		//Этот метод будет выполняться в побочном потоке
    {
         Toy toy=new Toy(23, ToyType.bigCars,"ggvgv");
         System.out.println();
    }
}


