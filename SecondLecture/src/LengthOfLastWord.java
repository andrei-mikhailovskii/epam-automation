import java.util.Scanner;

public class LengthOfLastWord {
    public static int wordLength(String text) {
        var trimmedText = text.trim();
        var result = 0;
        var charPosition = trimmedText.length() - 1;
        for (var i = 0; i < trimmedText.length(); i++) {
            if (trimmedText.charAt(charPosition) == ' ') {
                break;
            } else {
                result += 1;
                charPosition -= 1;
            }
        } return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        System.out.println(LengthOfLastWord.wordLength(n));
    }
}
