import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ToyRoom {
    private Toy[]toys;
    private AgeGroup ageGroup;

    public ToyType getToyTypeFromString(String toyType)
    {
        if (toyType=="smallCars")
        return ToyType.smallCars;
        if (toyType=="bigCars")
        return ToyType.bigCars;
        if (toyType=="midCars")
        return ToyType.midCars;

        if (toyType=="dolls")
            return ToyType.dolls;
        if (toyType=="cubes")
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
    ToyRoom(Toy[]toys)
    {
        this.toys=toys;
    }


    public static ToyRoom sortRoom(ToyRoom toyRoom) {
        Toy[] toys=toyRoom.getToys();

        for (int i=0;i<toys.length;i++)
            for (int j=i;j<toys.length;j++)
            {
                if (toys[i].getCost()<toys[j].getCost() );
                Toy toy=toys[i];
                toys[i]=toys[j];
                toys[j]=toy;
            }

        for (int i=0;i<toys.length-1;i++) {
            //System.out.println(toys[i].toString());
        }
        toyRoom.setToys(toys);
        return toyRoom;
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
        return "ToyRoom{" +
                "toys=" + Arrays.toString(toys) +
                ", ageGroup=" + ageGroup +
                '}';
    }

    public static void main(String[]args) {
        ToyRoom toyRoom=new ToyRoom();
        System.out.println(toyRoom.toString());
        System.out.println(sortRoom(toyRoom).toString());
        findToysByCost(toyRoom,50,100);
        System.out.println(toyRoom.getSumOfCosts());

        String textWithObjectsOfClass=MyFileReader.fileRead("toys.txt");
        String[]objectsOfClass=textWithObjectsOfClass.split("[\\r\\n]+");
        String[]oneObject=objectsOfClass[0].split("[\\s]+");
        String[]poleOfObjectsOfClass=textWithObjectsOfClass.split("[\\s]+");
        Toy[]toys=new Toy[objectsOfClass.length];

        for (int i=0;i<objectsOfClass.length;i++)
            {
                toys[i]=new Toy(Double.parseDouble(poleOfObjectsOfClass[i]),poleOfObjectsOfClass[i],poleOfObjectsOfClass[i]);

            }

        ToyRoom toyRoom1=new ToyRoom();

        try{
            MyException exception=new MyException("Это моё исключение");
            throw exception;
        } catch (MyException exception) {
            exception.printStackTrace();
        }


    }
}
