package db;
import java.util.List;

public interface Dao<S> {

    //get all values from table
    List<S> getAll();

    //get amount of records in all the tables
    int getAllRecords();

    //create  script to use any aggregated function
    List<S> getAggregated();

    //receive records from all the 3 tables (join) ordered by any column
    void getAllFromAll();

    //get records from a table using between/in/like
    void getBetweenInLike();

    //delete record
    void deleteRecord(int id);

    //delete all tables and create them from scratch
    void fromScratch();

    //delete all records from one table
    void deleteAllRecords(String table);

    //update value by id
    void updateValue(String s, int i);

}
