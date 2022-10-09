package third_oop;

public final class RunnersUnderage extends Runners implements WinProbability {
    private static String motto;
    private static String country;

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public String getCountry() { return country; }

    public void setCountry(String country) { this.country = country; }

    {
        motto = "Per Aspera Ad Astra!";
        country = "Undefined country";
    }

    public RunnersUnderage() {
        System.out.println("Please provide parameters");
    }

    public RunnersUnderage(String name, double weight, int maxSpeed, boolean isRun) {
        super(name, weight, maxSpeed, isRun);
        this.getMotto();
    }

    public RunnersUnderage(String name, double weight, int maxSpeed, boolean isRun, String motto) {
        super(name, weight, maxSpeed, isRun);
        this.motto = motto;
        this.country = country;
    }

    public RunnersUnderage(String name, double weight, int maxSpeed, boolean isRun, String motto, String country) {
        super(name, weight, maxSpeed, isRun);
        this.motto = motto;
        this.country = country;
    }

    public static void mottoExplanation() {
        System.out.println("Every runner has a motto. For example: " + motto + "\n");
    }

    @Override
    public void display()  {
        System.out.println("Young sportsperson " + getName() + "From " + getCountry() + "\nWeight: " + getWeight() + "\nMax Speed: " + getMaxSpeed() + "\nNow they are run: " + (isRun() ? "Yes" : "No") + "\nWin odds for your bet: " + canWin() + "\nThis youngster's motto is: " + getMotto() + "\n");
    }

    @Override
    public float canWin() {
        float winCoefficient = (float) (getMaxSpeed() / getWeight() * 10);
        return winCoefficient;
    }

    //static nested class
    public static class JamaicaRunner {
        private static int repeat;

        public JamaicaRunner(int repeat) {
            this.repeat = repeat;
        }

        public static void mottoJamaica() {
            for (int i = 0; i < repeat; i++) {
                motto = "Out of Many One People!";
                System.out.println("The motto of Jamaica is " + motto);
            }
        }
    }
}
