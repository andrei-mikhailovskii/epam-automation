package regex;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static void main(String[] args) {
        System.out.printf("To validate EMAIL, press 1\nTo validate PHONE NUMBER, press 2\nTo validate BOOK ISBN, press 3\nTo validate DATE , press 4%n");
        Scanner sc = new Scanner(System.in);
        try {
            int x = sc.nextInt();

        //check email
        if (x == 1) {
            System.out.println("Please enter your email (only letters, digits, \".\" and \"_\" are allowed):");
            Pattern pattern = Pattern.compile("[a-zA-Z0-9]+(\\.?\\_?[a-zA-Z0-9])+@[a-zA-Z0-9]{2,}\\.[a-zA-Z]{2,}");
            if (pattern.matcher(sc.next()).find()) System.out.println("Your email is VALID");
                else System.out.println("Your email is NOT VALID");
        }

        //check phone number
        else if (x == 2) {
            System.out.println("Please enter your mobile phone starting with +7 or 8 (also, you can use braces and hyphens):");
            Pattern pattern = Pattern.compile("(\\+7|8)((\\d{10})|((\\(|\\-)\\d{3}(\\)|\\-)((\\d{7})|(\\d{3}\\-\\d{2}\\-\\d{2}))))$");
            if (pattern.matcher(sc.next()).find()) System.out.println("Your phone number is VALID");
                else System.out.printf("Your phone number is NOT VALID! Please input in one of the following formats:\n+79991119999\n+79991119999\n+7(999)1119999\n+7(999)111-99-99\n+7-999-111-99-99");
        }

        //check ISBN
        else if (x == 3) {
            System.out.println("Please enter your book ISBN in the following format: \"978-X-XX-XXXXXX-X\" where X is number:");
            Pattern pattern = Pattern.compile("978\\-\\d\\-\\d{2}\\-\\d{6}\\-\\d$");
            if (pattern.matcher(sc.next()).find()) System.out.println("Your book's ISBN is valid");
            else System.out.println("Your book's ISBN is NOT VALID!");
        }

        //check date (including variations of quantity of days in each month)
        else if (x == 4) {
            System.out.printf("Please enter a date in the following format: \"year-month-date\".\nYear in 4 digits, month in 3 letters starting with capital one, date is 2 digits (0 is the first digit if is 1 to 9 day of month)%n");
            String dateFormat = sc.next();

            Pattern february = Pattern.compile("Feb");
            Pattern thirtyOne = Pattern.compile("(Jan|Mar|May|Jul|Aug|Oct|Dec)");
            Pattern thirty = Pattern.compile("(Apr|Jun|Sep|Nov)");
            Matcher matcherFeb = february.matcher(dateFormat);
            Matcher matcherThirtyOneDay = thirtyOne.matcher(dateFormat);
            Matcher matcherThirtyDay = thirty.matcher(dateFormat);

            if (matcherFeb.find()) {
                Pattern pattern = Pattern.compile("\\d{4}\\-(Feb)\\-(0[1-9]|1[1-9]|2[1-9])");
                if (pattern.matcher(dateFormat).find()) System.out.println("Your date " + dateFormat + " is valid");
                    else System.out.println("Incorrect date format!");
            } else if (matcherThirtyOneDay.find()) {
                Pattern pattern = Pattern.compile("\\d{4}\\-(Jan|Mar|May|Jul|Aug|Oct|Dec)\\-(0[1-9]|1[1-9]|2[1-9]|30|31)");
                if (pattern.matcher(dateFormat).find()) System.out.println("Your date " + dateFormat + " is valid");
                else System.out.println("Incorrect date format!");
            } else if (matcherThirtyDay.find()) {
                Pattern pattern = Pattern.compile("\\d{4}\\-(Apr|Jun|Sep|Nov)\\-(0[1-9]|1[1-9]|2[1-9]|30)");
                if (pattern.matcher(dateFormat).find()) System.out.println("Your date " + dateFormat + " is valid");
                else System.out.println("Incorrect date format!");
            } else System.out.println("Your date is invalid!");
        }

        else {
            System.out.println("You entered invalid number! The program is finished.");
            System.exit(0);
        }

        sc.close();
        }
        catch (InputMismatchException e) {
            System.out.println("You entered invalid character! The program is finished.");
        }
    }
}
