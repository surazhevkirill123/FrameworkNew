package SerializationClasses;

import java.io.*;
import java.util.*;
public class InSerialize {
    public static void main (String args[]) throws  IOException, ClassNotFoundException {
        ObjectInputStream in =  new ObjectInputStream (new FileInputStream("objects.dat"));
        /*Date d1 = (Date)in.readObject();
        RandomClass rc1 = (RandomClass)in.readObject();
        RandomClass rc2 = (RandomClass)in.readObject();
        System.out.println("I have read:");
        System.out.println("A Date object: "+d1);
        System.out.println("Two Group of randoms");
        rc1.printout();
        rc2.printout();*/
    }
}
