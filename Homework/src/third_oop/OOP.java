package third_oop;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class OOP {
    public static void main(String[] args) throws Exception {

        System.out.println("What would you like to do?" + "\n" + "Press 1 to enter sportsperson's data and save it to a file" + "\n" + "Press 2 to read info about sportspersons" + "\n" + "Press 3 to exit the program");
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
                System.exit(0);
            } else {
                throw new InputOptionException();
            }
        }
        catch (FileNotFoundException e) {
            System.err.println("File \"sportsperson.txt\" not found");
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
