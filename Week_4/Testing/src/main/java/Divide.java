public class Divide {
    public int divide(int a,int b){
        try {
            return a / b;
        }
        catch (ArithmeticException e){
            System.out.println(e.getMessage());
            return 0;
        }
    }

}
