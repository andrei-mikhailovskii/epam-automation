package third_oop;

public final class RunnersUnderage extends Runners implements WinProbability {
    private static String motto;

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    {
        motto = "Per Aspera Ad Astra!";
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
        this.getMotto();
    }

    public static void mottoExplanation() {
        System.out.println("Every runner has a motto. For example: " + motto + "\n");
    }

    @Override
    public void display()  {
        System.out.println("Young sportsperson " + getName() + "Weight: " + getWeight() + "\nMax Speed: " + getMaxSpeed() + "\nNow they are run: " + (isRun() ? "Yes" : "No") + "\nWin odds for your bet: " + canWin() + "\nThis youngster's motto is: " + getMotto() + "\n");
    }

    @Override
    public float canWin() {
        float winCoefficient = (float) (getMaxSpeed() / getWeight() * 10);
        return winCoefficient;
    }

}
