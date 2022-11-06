package db;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class CreateFromScratchDao implements Dao {

    @Override
    public List getAll() { return null; }

    @Override
    public int getAllRecords() { return 0; }

    @Override
    public List getAggregated() { return null; }

    @Override
    public void getAllFromAll() { }

    @Override
    public void getBetweenInLike() { }

    @Override
    public void deleteRecord(int id) { }

    @Override
    public void fromScratch() {
        try (Statement statement = Connection.getConnection().createStatement()){

            //delete all tables
            statement.addBatch("DROP TABLE athlete");
            statement.addBatch("DROP TABLE university");
            statement.addBatch("DROP TABLE city");

            //create tables
            statement.addBatch("CREATE TABLE athlete (athlete_id INT NOT NULL IDENTITY(1,1) PRIMARY KEY, first_name VARCHAR(50), last_name VARCHAR(50), birth_date_time DATETIME, university_id INT)");
            statement.addBatch("CREATE TABLE city (city_id INT NOT NULL IDENTITY(1,1) PRIMARY KEY, city_name VARCHAR(50), citizen INT)");
            statement.addBatch("CREATE TABLE university (university_id INT NOT NULL IDENTITY(1,1) PRIMARY KEY, u_name VARCHAR(50), student_quantity INT, city_id INT)");

            //connect tables
            statement.addBatch("ALTER TABLE dbo.athlete ADD FOREIGN KEY (university_id) REFERENCES university (university_id)");
            statement.addBatch("ALTER TABLE dbo.university ADD FOREIGN KEY (city_id) REFERENCES city (city_id)");

            //insert values
            statement.addBatch("INSERT INTO city (city_name, citizen) VALUES ('Berlin', 6144600), ('London', 14257962), ('Stockholm', 2415139)");
            statement.addBatch("INSERT INTO university (u_name, student_quantity, city_id) VALUES ('University of Roehampton', 2450, 2), ('Staffordshire University', 1349, 2), ('University Sports at Freie Universitat Berlin', 1888, 1), ('Stockholm University of Sports', 984, 3)");
            statement.addBatch("INSERT INTO athlete (first_name, last_name, birth_date_time, university_id) VALUES ('Richard', 'Schneider', '20040618 10:34:09 AM', 3), ('John', 'Barkley', '20000718 04:20:00 AM', 1), ('Kurz', 'Braun', '19981018 11:24:08 PM', 2), ('Oskar', 'Bjornsson', '19960606 01:19:00 PM', 4), ('Anna', 'Karlsson', '20020108 10:01:50 AM', 2), ('Richard', 'Smith', '20010619 00:04:09 AM', 3)");

            //submit a batch for execution
            statement.executeBatch();
            System.out.println("Query executed successfully");

        } catch (SQLException e) {
            System.out.println("Exception during SQL query execution " + e);
        }
    }

    @Override
    public void deleteAllRecords(String string) {

    }

    @Override
    public void updateValue(String s, int i) {

    }
}
