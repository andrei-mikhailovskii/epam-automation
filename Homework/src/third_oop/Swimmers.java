package third_oop;

import java.text.DecimalFormat;
import java.util.Arrays;

public class Swimmers extends SportsPeople implements WinProbability{
    private boolean outdoorSwimmer;
    private String swimmingStyle;
    private static final int WATER_DENSITY = 997; //kg/m3

    public boolean isOutdoorSwimmer() {
        return outdoorSwimmer;
    }

    public void setOutdoorSwimmer(boolean outdoorSwimmer) {
        this.outdoorSwimmer = outdoorSwimmer;
    }

    public String getSwimmingStyle() {
        return swimmingStyle;
    }

    public void setSwimmingStyle(String swimmingStyle) {
        if (Arrays.asList("Butterfly", "Free", "Breaststroke", "Front Crawl").contains(swimmingStyle)) {
            this.swimmingStyle = swimmingStyle;
        } else {
            System.out.println("Please, check and fix Swimming Style");
        }
    }

    {
        outdoorSwimmer = false;
        swimmingStyle = "Unknown";
    }

    public Swimmers() {
        System.out.println("Please update a swimmer with the following necessary parameters: Name, Weight, OutdoorSwimmer, SwimmingStyle");
    }

    public Swimmers(String name, double weight, boolean outdoorSwimmer, String swimmingStyle) {
        super(name, weight);
        this.outdoorSwimmer = outdoorSwimmer;
        if (Arrays.asList("Butterfly", "Free", "Breaststroke", "Front Crawl").contains(swimmingStyle)) {
            this.swimmingStyle = swimmingStyle;
        } else {
            System.out.println("Please, check and fix Swimming Style");
        }
    }

    public void printInfo() {
        System.out.println("Swimmer name: " + getName() +
                "\nWeight: " + getWeight() +
                "\nCan participate in Open Lake swimming festival: " + (isOutdoorSwimmer() ? "Yes" : "No") +
                "\nPrimary swimming style: " + getSwimmingStyle() +
                "\nWin odds for your bet: " + canWin() + "\n");
    }

    @Override
    public float canWin() {
        float winCoef = 1;
        DecimalFormat df = new DecimalFormat("#.00");
        if (isOutdoorSwimmer() == true) {
            winCoef = 2;
        } else {
        }
        float result = (float) (getWeight() * winCoef / WATER_DENSITY * 100);
        return Float.valueOf(df.format(result));
    }

}
