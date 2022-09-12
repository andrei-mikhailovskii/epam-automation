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
                i += 1;
                charPosition -= 1;
            }
        } return result;
    }
    public static void main(String[] args) {
        System.out.println(LengthOfLastWord.wordLength("   fly me   to   the moon  "));
    }
}
