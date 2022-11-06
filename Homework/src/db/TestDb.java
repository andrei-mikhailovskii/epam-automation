package db;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestDb {
    public static void main() {

        System.out.println(new StringBuilder().append("1 - View table ATHLETE").append("\n").append("2 - View table CITY").append("\n").append("3 - View table UNIVERSITY").append("\n").append("4 - Get amount of records in all the tables").append("\n").append("5 - City + amount of students in it (aggregate function)").append("\n").append("6 - Receive ALL records from all tables").append("\n").append("7 - All students with first name starting with \"R\", born between 2000 and 2010, studying in university 2 or 3").append("\n").append("8 - Delete record from ATHLETE table by ID").append("\n").append("9 - Delete all records from table").append("\n").append("10 - Update amount of people in city").append("\n").append("11 - Delete all tables and create them from scratch").append("\n").append("12 - Exit program"));

        try {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            if (n == 1) {
                AthleteDao athleteDao = new AthleteDao();
                athleteDao.getAll().stream().forEach(System.out::println);
            } else if (n == 2) {
                CityDao cityDao = new CityDao();
                cityDao.getAll().stream().forEach(System.out::println);
            } else if (n == 3) {
                UniversityDao universityDao = new UniversityDao();
                universityDao.getAll().stream().forEach(System.out::println);
            } else if (n == 4) {
                VariousTablesDao variousTablesDao = new VariousTablesDao();
                variousTablesDao.getAllRecords();
            } else if (n == 5) {
                VariousTablesDao variousTablesDao = new VariousTablesDao();
                variousTablesDao.getAggregated().stream().forEach(System.out::println);
            } else if (n == 6) {
                VariousTablesDao variousTablesDao = new VariousTablesDao();
                variousTablesDao.getAllFromAll();
            } else if (n == 7) {
                AthleteDao athleteDao = new AthleteDao();
                athleteDao.getBetweenInLike();
            } else if (n == 8) {
                System.out.print("Enter ID to delete: ");
                AthleteDao athleteDao = new AthleteDao();
                athleteDao.deleteRecord(scanner.nextInt());
            } else if (n == 9) {
                System.out.print("Input table name to delete all data: ");
                VariousTablesDao variousTablesDao = new VariousTablesDao();
                variousTablesDao.deleteAllRecords(scanner.next());
            } else if (n == 10) {
                System.out.print("Enter a city name, then press Enter and enter amount of citizens: ");
                String city = scanner.next();
                int people = scanner.nextInt();
                if (city.equals("Berlin") | city.equals("London") | city.equals("Stockholm")) {
                    CityDao cityDao = new CityDao();
                    cityDao.updateValue(city, people);
                } else System.out.println("Invalid city name");
            } else if (n == 11) {
                CreateFromScratchDao createFromScratchDao = new CreateFromScratchDao();
                createFromScratchDao.fromScratch();
            } else if (n == 12) {
                System.exit(0);
            } else  {
                System.out.println("Wrong input");
                System.exit(0);
            }
        } catch (InputMismatchException e) {
            System.out.println("Wrong input");
        }
    }
}
