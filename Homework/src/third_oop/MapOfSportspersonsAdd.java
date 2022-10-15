package third_oop;
import java.io.*;
import java.util.*;

public class MapOfSportspersonsAdd {

    Map<String, String> mapRunner = new HashMap<>();
    Map<String, String> mapSwimmer = new HashMap<>();

    //Add new object to collection/map
    public void writeMapOfPersons() throws InputOptionException, ArrayIndexOutOfBoundsException{



        System.out.println("To add basic info about a sportperson into the Map, press a corresponding button: " + "\n" +
                "To fill information about a RUNNER press 1" + "\n" +
                "To fill information about a SWIMMER press 2" + "\n" +
                "To exit program press 3");

        try {
            Scanner scan = new Scanner(System.in);
            int n = scan.nextInt();
            if (n == 1) {
                File file = new File("./Homework/src/runnersmap.txt");
                if (file.exists()) {
                    try {
                        Scanner sc = new Scanner(file);
                        while (sc.hasNextLine()) {
                            String[] splitted = sc.nextLine().split("=");
                            mapRunner.put(splitted[0], splitted[1]);
                        }
                        sc.close();
                    }
                    catch (ArrayIndexOutOfBoundsException e) {
                        throw new ArrayIndexOutOfBoundsException("Delete empty strings in runnersmap.txt and try again");
                    }
                }
                System.out.println("Please provide runner's parameters consequently:" + "\n" + "Name (word/string)" + "\n" + "Weight (number/double)" + "\n" + "Max Speed (number/int)" + "\n" + "Are they run now (write \"true\" or \"false\")");
                scan.nextLine();
                Runners runner = new Runners(scan.nextLine(), scan.nextDouble(), scan.nextInt(), scan.nextBoolean());
                String value = "Weight: " + runner.getWeight() + ", " + "Max speed: " + runner.getMaxSpeed() + ", " + "Is running now: " + runner.isRun();
                mapRunner.put(runner.getName(), value);

                BufferedWriter bf = null;

                try {
                    bf = new BufferedWriter(new FileWriter(file));

                    for (Map.Entry<String, String> entry :
                            mapRunner.entrySet()) {

                        bf.write(entry.getKey() + "=" + entry.getValue());
                        bf.newLine();
                    }

                    bf.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {

                    try {
                        bf.close();
                    } catch (Exception e) {
                    }
                }

            } else if (n == 2) {
                File file = new File("./Homework/src/swimmersmap.txt");
                if (file.exists()) {
                    try {
                        Scanner sc = new Scanner(file);
                        while (sc.hasNextLine()) {
                            String[] splitted = sc.nextLine().split("=");
                            mapSwimmer.put(splitted[0], splitted[1]);
                        }
                        sc.close();
                    }
                    catch (ArrayIndexOutOfBoundsException e) {
                        throw new ArrayIndexOutOfBoundsException("Delete empty strings in swimmersmap.txt and try again");
                    }
                }
                System.out.println("Please provide swimmer's parameters consequently:" + "\n" + "Name (word/string)" + "\n" + "Weight (number/double)" + "\n" + "Can they swim outdoors (write \"true\" or \"false\")" + "\n" + "Their swimming style (write one of the following: \"Butterfly\", \"Free\", \"Breaststroke\", \"Front Crawl\")");
                scan.nextLine();
                Swimmers swimmer = new Swimmers (scan.nextLine(), scan.nextDouble(), scan.nextBoolean(), scan.next());
                String value = "Weight: " + swimmer.getWeight() + ", " + "Can swim outdoors: " + swimmer.isOutdoorSwimmer() + ", " + "Swimming style: " + swimmer.getSwimmingStyle();
                mapSwimmer.put(swimmer.getName(), value);

                BufferedWriter bf = null;

                try {
                    bf = new BufferedWriter(new FileWriter(file, true));

                    for (Map.Entry<String, String> entry :
                            mapSwimmer.entrySet()) {

                        bf.write(entry.getKey() + "=" + entry.getValue());
                        bf.newLine();
                    }

                    bf.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {

                    try {
                        bf.close();
                    } catch (Exception e) {
                    }
                }

            } else if (n == 3) {
                System.exit(0);
            } else {
                throw new InputOptionException();
            }
            scan.close();
        }
        catch (InputOptionException e) {
            throw new InputOptionException();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
