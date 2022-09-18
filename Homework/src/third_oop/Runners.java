package third_oop;

public class Runners extends SportsPeople{
    private int maxSpeed;
    private boolean isRun;

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        if (maxSpeed > 0) {
            this.maxSpeed = maxSpeed;
        } else {
            System.err.println("ERROR in Runners. Negative speed! Please provide a valid parameter. Now it is set to 1.");
        }
    }

    public boolean isRun() {
        return isRun;
    }

    public void setRun(boolean run) {
        isRun = run;
    }

    {
        maxSpeed = 1;
        isRun = false;
    }

    public Runners() {
        System.out.println("Please, provide parameters");
    }

    public Runners(String name, double weight) {
        super(name, weight);
    }

    public Runners(String name, double weight, int maxSpeed, boolean isRun) {
        super(name, weight);
        if (maxSpeed > 0) {
            this.maxSpeed = maxSpeed;
        } else {
            System.err.println("ERROR in Runners. Negative or zero speed! Please provide a valid parameter. Now it is set to 1.");
        }
        this.isRun = isRun;
    }

    public void display() {
        System.out.println("Sportsperson " + getName() + "\nTheir weight is: " + getWeight() + "\nMax Speed: " + getMaxSpeed() + "\nNow they are run: " + isRun());
    }
}
