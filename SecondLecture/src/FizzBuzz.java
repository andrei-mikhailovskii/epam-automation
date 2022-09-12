import java.util.Scanner;

public class FizzBuzz {
    public static String fizz(int n) {
        if (n % 3 == 0 && n % 5 == 0) {
            return "fizz-buzz";
        } else if (n % 5 == 0 && n % 3 != 0) {
            return "buzz";
        } else if (n % 3 == 0 && n % 5 != 0) {
            return  "fizz";
        } else {
            return Integer.toString(n);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(FizzBuzz.fizz(n));
    }
}
