package Theads;

public class Program			//Класс с методом main()
{
    public static void main(String[] args)
    {
        Something mThing = new Something();//mThing - объект класса, реализующего интерфейс Runnable
        Something2 iThing= new Something2();
        Thread myThready = new Thread(mThing);	//Создание потока "myThready"
        Thread myThready2 = new Thread(iThing);	//Создание потока "myThready"
        System.out.println("Главный поток завершён...");
        myThready.start();				//Запуск потока
        myThready2.start();				//Запуск потока
        System.out.println("Главный поток завершён...");

    }
}
