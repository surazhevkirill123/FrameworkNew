package MainClasses;

import AdditionalClasses.MyFileReader;
import AdditionalClasses.SelectionSort;
import Enums.AgeGroup;
import Enums.ToyType;
import MyExceptions.MyException;

import java.util.Arrays;
import java.util.Random;

public class ToyRoom {
    private Toy[]toys;
    private AgeGroup ageGroup;

    public static ToyType getToyTypeFromString(String toyType)
    {
        if (toyType.compareTo("smallCars")==0)
        return ToyType.smallCars;
        if (toyType.compareTo("bigCars")==0)
        return ToyType.bigCars;
        if (toyType.compareTo("midCars")==0)
        return ToyType.midCars;

        if (toyType.compareTo("dolls")==0)
            return ToyType.dolls;
        if (toyType.compareTo("cubes")==0)
            return ToyType.cubes;
        else
            return ToyType.balls;

    }


    ToyRoom(){
        try {
            int count=0;
            int costs[]=new int[20];
            double totalCost=1000;
            int sumOfCosts=0;
            for (int i=0;sumOfCosts<totalCost ;i++) {
                int a = 50; // Начальное значение диапазона - "от"
                int b = 125; // Конечное значение диапазона - "до"
                int random_number = a + (int) (Math.random() * b);
                costs[i]=random_number;
                sumOfCosts+=random_number;
                count++;
            }
            this.toys=new Toy[count];
            for (int i=0;i<count;i++) {
                this.toys[i]=new Toy(costs[i]);
            }

            for (int i=0;i<5;i++) {
                this.toys[i]=new Toy();
                sumOfCosts+=toys[i].getCost();
            }
            int pick = new Random().nextInt(AgeGroup.values().length);
            this.ageGroup=AgeGroup.values()[pick];
            if(ageGroup==AgeGroup.junior)
            {
                for (int i=0;i<count/2;i++) {
                    this.toys[i*2].setType(ToyType.bigCars);
                }
                for (int i=1;i<count;i++) {
                    this.toys[i].setType(ToyType.cubes);
                }
            }
            if(ageGroup==AgeGroup.middle)
            {
                for (int i=0;i<count/2;i++) {
                    this.toys[i*2].setType(ToyType.midCars);
                }
                for (int i=1;i<count;i++) {
                    this.toys[i].setType(ToyType.dolls);
                }
            }
            if(ageGroup==AgeGroup.senior)
            {
                for (int i=0;i<count/2;i++) {
                    this.toys[i*2].setType(ToyType.balls);
                }
                for (int i=1;i<count;i++) {
                    this.toys[i].setType(ToyType.smallCars);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public ToyRoom(Toy[] toys)
    {
        this.toys=toys;
        int pick = new Random().nextInt(AgeGroup.values().length);
        this.ageGroup=AgeGroup.values()[pick];
    }

    public static void findToysByCost(ToyRoom toyRoom,int start,int finish) {
        Toy[]toys=toyRoom.getToys();
        for (int i=0;i<toys.length;i++) {
            if (toys[i].getCost()>start && toys[i].getCost()<finish)
                System.out.println(toys[i].toString());
        }
    }

    public void setToys(Toy[] toys) {
        this.toys = toys;
    }
    public double getSumOfCosts()
    {
        double SumOfCosts=0;
        for (int i=0;i<toys.length;i++)
        {
            SumOfCosts+=toys[i].getCost();
        }
        return SumOfCosts;
    }


    public Toy[] getToys() {
        return toys;
    }


    @Override
    public String toString() {
        return "MainClasses.ToyRoom{" +
                "toys=" + Arrays.toString(toys) +
                ", ageGroup=" + ageGroup +
                '}';
    }


}
