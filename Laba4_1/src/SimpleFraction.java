import java.util.Objects;

public class SimpleFraction {
    private double numerator;
    private double denominator;

    SimpleFraction()
    {
        try {
            int a = 1; // Начальное значение диапазона - "от"
            int b = 10; // Конечное значение диапазона - "до"

            int random_number1 = a + (int) (Math.random() * b); // Генерация 1-го числа
            int random_number2 = a + (int) (Math.random() * b); // Генерация 2-го числа
            int quotient=random_number1/random_number2;
            this.numerator = random_number1;
            this.denominator = random_number2;

        } catch (ArithmeticException e) {
            this.numerator = 1;
            this.denominator = 1;
            System.out.println("Деление на ноль!");
        }

    }
    SimpleFraction(String fraction) {
        try {
            String[] ArrOfNumAndDenom=fraction.split("/");
            double quotient=Integer.parseInt(ArrOfNumAndDenom[0])/Integer.parseInt(ArrOfNumAndDenom[1]);
            this.numerator=Integer.parseInt(ArrOfNumAndDenom[0]);
            this.denominator=Integer.parseInt(ArrOfNumAndDenom[1]);

        } catch (Exception e) {
            this.numerator = 1;
            this.denominator = 1;
            System.out.println("Деление на ноль!");
        }

    }
    SimpleFraction(double numerator,double denominator)
    {
        try {
            double quotient=numerator/denominator;
            this.numerator = numerator;
            this.denominator = denominator;
        } catch (Exception e) {
            this.numerator = 1;
            this.denominator = 1;
            System.out.println("Деление на ноль!");
        }
    }
    public void setNumerator(double numerator) {
        this.numerator = numerator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleFraction that = (SimpleFraction) o;
        return Double.compare(that.numerator, numerator) == 0 &&
                Double.compare(that.denominator, denominator) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }

    public void setDenominator(double denominator) {
        this.denominator = denominator;
    }

    public double getDenominator() {
        return denominator;
    }

    public double getNumerator() {
        return numerator;
    }
    public SimpleFraction addition(SimpleFraction b){
        double newNumerator=this.numerator*b.getDenominator()+this.denominator*b.getNumerator();
        double newDenominator=b.getDenominator()*this.denominator;
        return new SimpleFraction(newNumerator,newDenominator);
    }
    public SimpleFraction subtraction(SimpleFraction b){
        double newNumerator=this.numerator*b.getDenominator()-this.denominator*b.getNumerator();
        double newDenominator=b.getDenominator()*this.denominator;
        return new SimpleFraction(newNumerator,newDenominator);
    }
    public SimpleFraction multiplication(SimpleFraction b){
        double newNumerator=this.numerator*b.getNumerator();
        double newDenominator=b.getDenominator()*this.denominator;
        return new SimpleFraction(newNumerator,newDenominator);
    }
    public SimpleFraction division(SimpleFraction b){
        double newNumerator=this.numerator*b.getDenominator();
        double newDenominator=b.getNumerator()*this.denominator;
        return new SimpleFraction(newNumerator,newDenominator);
    }



    @Override
    public String toString() {
        return "SimpleFraction{" +
                 numerator +
                " / " + denominator +
                '}';
    }
}
