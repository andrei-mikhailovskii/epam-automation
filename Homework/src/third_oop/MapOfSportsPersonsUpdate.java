package third_oop;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapOfSportsPersonsUpdate {
    Map<String, String> mapRunner = new HashMap<>();
    Map<String, String> mapSwimmer = new HashMap<>();

    //Update an object in the collection/map by specific field value
    public void updateMapOfPersons() throws InputOptionException, FileNotFoundException {
        System.out.println("From which Map would you like to update an object?" + "\n" + "Runners - press 1" + "\n" + "Swimmers - press 2"+ "\n" + "To exit program press 3");
        try {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            if (n == 1) {
                File file = new File("./Homework/src/runnersmap.txt");
                if (file.exists()) {
                    try {
                        Scanner scFile = new Scanner(file);
                        while (scFile.hasNextLine()) {
                            String[] splitted = scFile.nextLine().split("=");
                            mapRunner.put(splitted[0], splitted[1]);
                        }
                        scFile.close();
                    }
                    catch (ArrayIndexOutOfBoundsException e) {
                        throw new ArrayIndexOutOfBoundsException("Delete empty strings in runnersmap.txt and try again");
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(mapRunner);
                System.out.println("Input name (key) to update value:");
                mapRunner.replace(sc.next(), sc.next() + " ");

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

                System.out.println("Updated: " + mapRunner);
            } else if (n == 2) {
                File file = new File("./Homework/src/swimmersmap.txt");
                if (file.exists()) {
                    try {
                        Scanner scFile = new Scanner(file);
                        while (scFile.hasNextLine()) {
                            String[] splitted = scFile.nextLine().split("=");
                            mapSwimmer.put(splitted[0], splitted[1]);
                        }
                        scFile.close();
                    }
                    catch (ArrayIndexOutOfBoundsException e) {
                        throw new ArrayIndexOutOfBoundsException("Delete empty strings in swimmersmap.txt and try again");
                    }
                }
                System.out.println(mapSwimmer);
                System.out.println("Input name (key) to update value:");
                mapSwimmer.replace(sc.next(), sc.next() + " ");

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

                System.out.println("Updated: " + mapSwimmer);
            } else if (n == 3) {
                System.exit(0);
            } else {
                throw new InputOptionException();
            }
            sc.close();
        }
        catch(InputOptionException e) {
            throw new InputOptionException();
        }
    }
}
