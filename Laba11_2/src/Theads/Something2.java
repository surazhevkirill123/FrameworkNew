package Theads;

class Something2			//Нечто, реализующее интерфейс Runnable
        implements Runnable		//(содержащее метод run())
{
    public void run()		//Этот метод будет выполняться в побочном потоке
    {
        int a=5;
        System.out.println(a);
    }
}
