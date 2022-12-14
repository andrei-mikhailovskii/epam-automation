package third_oop;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class OOP {
    public static void main(String[] args) throws Exception {

        // hashCode() and equals() are implemented in the SportsPeople abstract class for the "name" field

            System.out.println(new StringBuilder().append("What would you like to do?").append("\n").append("Press 1 to enter sportsperson's data and save it to a file").append("\n").append("Press 2 to read info about sportspersons from file").append("\n").append("Press 3 to add new sportsperson to collection/map").append("\n").append("Press 4 to read all the sportspersons from the collection/map").append("\n").append("Press 5 to remove a sportsperson from collection/map").append("\n").append("Press 6 to update a sportsperson in the collection/map").append("\n").append("Press 7 to start work with Database").append("\n").append("Press 8 to exit the program").toString());
            Scanner control = new Scanner(System.in);
            try {
                int n = control.nextInt();
                if (n == 1) {
                    WriteFile sportsperson = new WriteFile();
                    sportsperson.writeToFile();
                } else if (n == 2) {
                    ReadFile sportsperson = new ReadFile();
                    sportsperson.readFile();
                } else if (n == 3) {
                    MapOfSportspersonsAdd addPerson = new MapOfSportspersonsAdd();
                    addPerson.writeMapOfPersons();
                } else if (n == 4) {
                    MapOfSportsPersonsRead readPerson = new MapOfSportsPersonsRead();
                    readPerson.readMapOfPersons();
                } else if (n == 5) {
                    MapOfSportsPersonsRemove removePerson = new MapOfSportsPersonsRemove();
                    removePerson.removeFromMapOfPersons();
                } else if (n == 6) {
                    MapOfSportsPersonsUpdate updatePerson = new MapOfSportsPersonsUpdate();
                    updatePerson.updateMapOfPersons();
                } else if (n == 7) {
                    db.TestDb.main();
                } else if (n == 8) {
                    System.exit(0);
                } else {
                    throw new InputOptionException();
                }
            }
            catch (FileNotFoundException e) {
                System.err.println("File not found");
            }
            catch (IOException e) {
                System.err.println("Wrong input/output");
            }
            catch (InputMismatchException e) {
                System.err.println("You entered an invalid value");
            }
            catch (InputOptionException e) {
                throw new InputOptionException("You entered wrong option number", e);
            }
            control.close();
        }
}
