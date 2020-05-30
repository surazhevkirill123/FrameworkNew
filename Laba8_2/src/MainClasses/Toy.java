package MainClasses;

import AdditionalClasses.RandomString;
import Enums.ToyType;

import java.util.Random;

public class Toy {
    private double cost;
    private ToyType type;
    private String name;
    Toy() {
        try {
            int a = 1; // Начальное значение диапазона - "от"
            int b = 100; // Конечное значение диапазона - "до"
            int random_number1 = a + (int) (Math.random() * b); // Генерация 1-го числа
            this.cost=random_number1;
            int pick = new Random().nextInt(ToyType.values().length);
            this.type=ToyType.values()[pick];
            this.name= RandomString.getAlphaNumericString(5);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public Toy(double cost, ToyType type, String name){
        try {
            this.cost = cost;
            this.type = type;
            this.name = name;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    Toy(double cost)
    {
        try {
            this.cost=cost;
            int pick = new Random().nextInt(ToyType.values().length);
            this.type=ToyType.values()[pick];
            this.name=RandomString.getAlphaNumericString(5);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setType(ToyType type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public ToyType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "MainClasses.Toy{" +
                "cost=" + cost +
                ", type=" + type +
                ", name='" + name + '\'' +
                '}';
    }

    public static int rang(ToyType toyType) {
        if (toyType==ToyType.smallCars)
            return 0;
        if (toyType==ToyType.midCars)
            return 1;
        if (toyType==ToyType.bigCars)
            return 2;
        if (toyType==ToyType.dolls)
            return 3;
        if (toyType==ToyType.balls)
            return 4;
        else
            return 5;

    }
    public static Toy[] createArray(int size)
    {
        Toy[]toys=new Toy[size];
        for (int i=0;i<size;i++)
        {
            toys[i]=new Toy();

        }
        return toys;
    }

    public static void main(String[]args)
    {
        Toy toy1=new Toy();

        Toy toy2=new Toy(234,ToyType.bigCars,"bhbb");
        Toy toy3=new Toy();
        System.out.println(toy1.toString());
        System.out.println(toy2.toString());
        System.out.println(toy3.toString());
        Toy[] toys=createArray(5);
        for (int i=0;i<toys.length;i++){
            toys[i].toString();
        }
        Toy toy4=new Toy(234,null,"bhbb");
        System.out.println(toy4.toString());
    }

}
