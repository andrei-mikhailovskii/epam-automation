package third_oop;

public abstract class SportsPeople {
    private String name;

    private double weight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight > 0) {
            this.weight = weight;
        } else {
            System.err.println("Weight cannot be negative or zero! Please set a new parameter, now it is set to default value: 1.0");
        }
    }

    {
        name = "Default Name";
        weight = 1;
    }

    public SportsPeople(){

    }
    public SportsPeople (String name, double weight) {
        this.name = name;
        if (weight > 0) {
            this.weight = weight;
        } else {
            System.err.println("Weight cannot be negative or zero! Please set a new parameter, now it is set to default value: 1.0");
        }

    }

}
