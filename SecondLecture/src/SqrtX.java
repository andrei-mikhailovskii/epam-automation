public class SqrtX {
    public static int sqrt(int x) {
        var desiredValue = 1;
        while ((desiredValue + 1) * (desiredValue + 1) <= x) {
                desiredValue += 1;
            } return desiredValue;
        }
    public static void main(String[] args) {
        System.out.println(SqrtX.sqrt(120));
    }
}
