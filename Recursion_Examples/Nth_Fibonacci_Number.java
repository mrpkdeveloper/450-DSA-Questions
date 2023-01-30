import java.util.Scanner;
public class Nth_Fibonacci_Number {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        System.out.println(fibonacci(n));
    }
    static int fibonacci(int n) {
        if(n<2){
            return n;
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }
}
