import java.util.Arrays;

public class Main {
    public static void main(String[]args) {
        String textWithFractions1=MyFileReader.fileRead("fractions1.txt");
        String textWithFractions=MyFileReader.fileRead("fractions.txt");
        String[]fractions=textWithFractions.split("[\\n]+");
        SimpleFraction[]fractions1=new SimpleFraction[fractions.length];
        for (int i=0;i<fractions.length;i++) {
            fractions1[i]= new SimpleFraction(fractions[i]);
        }
        System.out.println(Arrays.toString(fractions1));


        SimpleFraction fract1=new SimpleFraction(3,4);
        SimpleFraction fract2=new SimpleFraction(3,4);
        SimpleFraction fract3=new SimpleFraction(7,11);
        SimpleFraction fract4=new SimpleFraction(3,5);

        System.out.println(fract1.toString());
        System.out.println(fract2.toString());
        System.out.println(fract3.toString());
        System.out.println(fract4.toString());

        System.out.println(fract1.equals(fract2));
        System.out.println(fract3.equals(fract4));

        System.out.println(fract1.hashCode());
        System.out.println(fract2.hashCode());
        System.out.println(fract3.hashCode());
        System.out.println(fract4.hashCode());

        System.out.println(fract3.addition(fract4).toString());
        System.out.println(fract3.subtraction(fract4).toString());
        System.out.println(fract3.multiplication(fract4).toString());
        System.out.println(fract3.division(fract4).toString());



    }

}
