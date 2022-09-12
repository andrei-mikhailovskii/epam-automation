//a .jar file for the following import is added to the Git repository
import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class Palindrome {
    public static boolean isPalindrome(int digit){
        var text = Integer.toString(digit);
        var reversedText = StringUtils.reverse(text);
        return digit == Integer.parseInt(reversedText);
    }
    public static void main(String[] array){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(Palindrome.isPalindrome(n));
    }
}