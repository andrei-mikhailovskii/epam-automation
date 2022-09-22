package third_oop;

public final class RunnersAdult extends Runners implements WinProbability{
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 18) {
            this.age = age;
        } else if (age < 18 && age >= 0) {
            System.out.println("This sportsperson is underage!");
        }
        else {
            System.err.println("ERROR in RunnerAdult. Negative age! Please provide a valid parameter. Now it is set to 0.");
        }
    }

    public RunnersAdult(){
        System.out.println("Please, provide parameters");
    }

    public RunnersAdult(String name, double weight) {
        super(name, weight);
    }

    public RunnersAdult(String name, double weight, int maxSpeed, boolean isRun) {
        super(name, weight, maxSpeed, isRun);
    }

    public RunnersAdult(String name, double weight, int maxSpeed, boolean isRun, int age) {
        super(name, weight, maxSpeed, isRun);
        if (age >= 18) {
            this.age = age;
        } else if (age < 18 && age >= 0) {
            System.out.println("This sportsperson is underage!");
        }
        else {
            System.err.println("ERROR in RunnerAdult. Negative age! Please provide a valid parameter. Now it is set to 0.");
        }
    }

    @Override
    public void display() {
        System.out.println("Sportsperson " + getName() + "\nTheir age is " + getAge() + " and the weight is: " + getWeight() + "\nMax Speed: " + getMaxSpeed() + "\nNow they are run: " + (isRun() ? "Yes" : "No") + "\nWin odds for your bet: " + canWin() + "\n");
    }

    @Override
    public float canWin() {
        float winCoefficient = (float) (age / getMaxSpeed() / getWeight() * 100);
        return winCoefficient;
    }

    //inner class
    public class Legs{
        public void legsMove() {
            if (isRun()) {
                System.out.println("The legs of " + getName() + " are moving");
            } else {
                System.out.println("The legs of " + getName() + " are not moving");
            }

        }
    }
}
