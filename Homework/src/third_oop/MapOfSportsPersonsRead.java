package third_oop;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapOfSportsPersonsRead {
    //Read all the objects from the collection/map
    public void readMapOfPersons() throws InputOptionException, FileNotFoundException {
        Map<String, String> mapRunner = new HashMap<>();
        Map<String, String> mapSwimmer = new HashMap<>();

        System.out.println("Which Map would you like to read?" + "\n" + "To read Runners map press 1" + "\n" + "To read Swimmers map press 2"+ "\n" + "To exit program press 3");
        try {
            Scanner number = new Scanner(System.in);
            int n = number.nextInt();
            number.close();
            if (n == 1) {
                File file = new File("./Homework/src/runnersmap.txt");
                Scanner sc = new Scanner(file);
                while (sc.hasNextLine()) {
                    String[] splitted = sc.nextLine().split("=");
                    mapRunner.put(splitted[0], splitted[1]);
                }
                System.out.println(mapRunner);
                sc.close();
            } else if (n == 2) {
                File file = new File("./Homework/src/swimmersmap.txt");
                Scanner sc = new Scanner(file);
                while (sc.hasNextLine()) {
                    String[] splitted = sc.nextLine().split("=");
                    mapSwimmer.put(splitted[0], splitted[1]);
                }
                System.out.println(mapSwimmer);
                sc.close();
            } else if (n == 3) {
                System.exit(0);
            } else {
                throw new InputOptionException();
            }
        }
        catch(InputOptionException e) {
            throw new InputOptionException();
        }

    }
}
