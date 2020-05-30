package cos;



public class DemoPrintersWork {
    public static void main(String[]args) {
        Printer[]printers=new Printer[3];
        printers[0]=new LaserPrinter("smile",12,34,56);
        printers[1]=new LaserPrinter("sweet",23,56,78);
        printers[2]=new Printer("sister",22,33,44);

        for (Printer tmpPr : printers)
            System.out.println(tmpPr);

    }
}
