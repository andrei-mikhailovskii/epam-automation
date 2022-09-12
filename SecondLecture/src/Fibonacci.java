import java.util.Scanner;
public class Fibonacci {
    public static int fib(int n) {
        var firstNumber = 0;
        var secondNumber = 1;
        var xNumber = 0;
        if (n == 0) {
            return firstNumber;
        } else if (n == 1) {
            return secondNumber;
        } else {
            for (var counter = 2; counter <= n; counter++) {
                xNumber = firstNumber + secondNumber;
                firstNumber = secondNumber;
                secondNumber = xNumber;
            } return xNumber;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(Fibonacci.fib(n));
    }
}
