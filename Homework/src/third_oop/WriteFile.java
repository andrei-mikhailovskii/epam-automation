package third_oop;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriteFile {
    public void writeToFile() throws IOException, InputOptionException {

        System.out.println("Please select a sportsperson and press a corresponding button: " + "\n" +
                "To fill information about ADULT RUNNER press 1" + "\n" +
                "To fill information about UNDERAGE RUNNER press 2" + "\n" +
                "To fill information about adult SWIMMER press 3" + "\n" +
                "To exit program press 4");

        File file = new File("./Homework/src/sportsperson.txt");
        FileWriter pw = new FileWriter(file, true);

        try {
            Scanner number = new Scanner(System.in);
            int n = number.nextInt();
            if (n == 1) {
                System.out.println("Please provide adult runner parameters consequently:"  + "\n" + "Name (word/string)" + "\n" + "Weight (number/double)" + "\n" + "Max Speed (number/int)" + "\n" + "Are they run now (write \"true\" or \"false\")");
                Scanner scan = new Scanner(System.in);
                RunnersAdult runner = new RunnersAdult(scan.nextLine(), scan.nextDouble(), scan.nextInt(), scan.nextBoolean());
                pw.write("Name: " + runner.getName() + "\n" + "Weight: " + runner.getWeight() + "\n" + "Max speed: " + runner.getMaxSpeed() + "\n" + "Is running now: " + runner.isRun() + "\n" + "\n");
            } else if (n == 2) {
                System.out.println("Please provide underage runner parameters consequently:" + "\n" + "Name (word/string)" + "\n" + "Weight (number/double)" + "\n" + "Max Speed (number/int)" + "\n" + "Are they run now (write \"true\" or \"false\")" + "\n" + "Motto (word/string)");
                Scanner scan = new Scanner(System.in);
                RunnersUnderage runneryoung = new RunnersUnderage(scan.nextLine(), scan.nextDouble(), scan.nextInt(), scan.nextBoolean(), scan.next());
                pw.write("Name: " + runneryoung.getName() + "\n" + "Weight: " + runneryoung.getWeight() + "\n" + "Max speed: " + runneryoung.getMaxSpeed() + "\n" + "Is running now: " + runneryoung.isRun() + "\n" + "Their motto: " + runneryoung.getMotto() + "\n" + "\n");
            } else if (n == 3) {
                System.out.println("Please provide swimmer parameters consequently:" + "\n" + "Name (word/string)" + "\n" + "Weight (number/double)" + "\n" + "Can they swim outdoors (write \"true\" or \"false\")" + "\n" + "Their swimming style (write one of the following: \"Butterfly\", \"Free\", \"Breaststroke\", \"Front Crawl\")");
                Scanner scan = new Scanner(System.in);
                Swimmers swimmer = new Swimmers(scan.nextLine(), scan.nextDouble(), scan.nextBoolean(), scan.next());
                pw.write("Name: " + swimmer.getName() + "\n" + "Weight: " + swimmer.getWeight() + "\n" + "Can swim outdoors: " + swimmer.isOutdoorSwimmer() + "\n" + "Swimming style: " + swimmer.getSwimmingStyle() + "\n" + "\n");
            } else if (n == 4) {
                System.exit(0);
            } else {
                throw new InputOptionException();
            }
        }
        catch (IOException e) {
            System.err.println("Wrong input/output");
        }
        catch (InputOptionException e) {
            throw new InputOptionException();
        }
        pw.close();
        }
}
