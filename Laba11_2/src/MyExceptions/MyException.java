package MyExceptions;

public class MyException extends Exception {
    MyException() {

    }
    public MyException(String str) {
        super(str);
    }


    public static void main(String[] args) {
        try{
            MyException exception=new MyException("hbbbbnbn");
            throw exception;
        } catch (MyException exception) {
            exception.printStackTrace();
        }
    }
}
