package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UniversityDao implements Dao<University> {

    @Override
    public List<University> getAll() {
        List<University> universities = new ArrayList<>();

        try (Statement st = Connection.getConnection().createStatement()) {

            ResultSet resultSet = st.executeQuery("SELECT * FROM TA_DB.dbo.university");

            while (resultSet.next()) {
                universities.add( new University(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getInt(4)));
            }
            resultSet.close();

        } catch (SQLException e) {
            System.out.println("Exception during SQL query execution");
        }
        Connection.closeConnection();

        return universities;
    }

    @Override
    public int getAllRecords() {
        return 0;
    }

    @Override
    public List<University> getAggregated() {
        return null;
    }

    @Override
    public void getAllFromAll() {

    }

    @Override
    public void getBetweenInLike() {

    }

    @Override
    public void deleteRecord(int id) {

    }

    @Override
    public void fromScratch() {

    }

    @Override
    public void deleteAllRecords(String string) {

    }

    @Override
    public void updateValue(String s, int i) {

    }
}
