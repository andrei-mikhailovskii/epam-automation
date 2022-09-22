package third_oop;

public class OOP {
    public static void main(String[] args) {
        /*RunnerAdult and RunnerUnderage classes extends Runners class
        which in turn extends SportsPeople class*/

        //parameters: String name, double weight, int maxSpeed, boolean isRun, int age
//        RunnersAdult runner1 = new RunnersAdult("John", 20, 15, true, 30);
//        runner1.display();
//
//        //invalid parameters
//        RunnersAdult runner2 = new RunnersAdult("Meredith", -20, -15, true, -9);
//        runner2.display();
//
//        //parameters: String name, double weight, int maxSpeed, boolean isRun, String motto (can be absent)
//        RunnersUnderage runner3 = new RunnersUnderage("Billy", 10, 20, false);
//        runner3.display();
//        runner3.setMotto("AAAAA!");
//        RunnersUnderage.mottoExplanation(); //static method
//
//        //parameters: String name, double weight, boolean outdoorSwimmer, String swimmingStyle
//        Swimmers swimmer1 = new Swimmers();
//        swimmer1.printInfo();
//        swimmer1.setName("Pekka");
//        swimmer1.setWeight(20);
//        swimmer1.setOutdoorSwimmer(true);
//        swimmer1.setSwimmingStyle("Butterfly");
//        swimmer1.printInfo();

        //inner class
        RunnersAdult runner3 = new RunnersAdult("Usain", 40, 30, true);
        RunnersAdult.Legs legs = runner3.new Legs();
        legs.legsMove();

        //static nested class
        RunnersUnderage.JamaicaRunner runner4 = new RunnersUnderage.JamaicaRunner(3);
        runner4.mottoJamaica();

        //anonymous inner class
        WinProbability preschoolerSwimmer = new WinProbability() {
            @Override
            public float canWin() {
                return 1;
            }
        };
        System.out.println("For preschoolers, win coefficient is already equals to " + preschoolerSwimmer.canWin());
    }
}
