package db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AthleteDao implements Dao<Athlete> {

    @Override
    public List<Athlete> getAll() {
        List<Athlete> athletes = new ArrayList<>();

        try (Statement st = Connection.getConnection().createStatement()) {

            ResultSet resultSet = st.executeQuery("SELECT * FROM TA_DB.dbo.athlete");

            while (resultSet.next()) {
                athletes.add( new Athlete(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getInt(5)));
            }
            resultSet.close();

        } catch (SQLException e) {
            System.out.println("Exception during SQL query execution");
        }
        Connection.closeConnection();

        return athletes;
    }

    @Override
    public int getAllRecords() {
        return 0;
    }

    @Override
    public List<Athlete> getAggregated() {
        return null;
    }

    @Override
    public void getAllFromAll() {

    }

    @Override
    public void getBetweenInLike() {
        try (Statement statement = Connection.getConnection().createStatement()) {

            ResultSet resultSet = statement.executeQuery("SELECT * FROM athlete WHERE birth_date_time BETWEEN '2000-01-01 00:00:00' AND '2010-01-01 00:00:00' AND university_id IN (2, 3) AND first_name LIKE 'R%'");

            ResultSetMetaData rsmd = resultSet.getMetaData();
            int columnCount = rsmd.getColumnCount();

            //get column names
            StringBuilder columnName = new StringBuilder();
            for (int colIdx = 1; colIdx <= columnCount; colIdx++) {
                columnName.append(rsmd.getColumnName(colIdx));
                if (colIdx != columnCount) {
                    columnName.append(" : ");
                }
            }
            System.out.println(columnName);

            //get data from SQL query
            while (resultSet.next()) {
                StringBuilder tableData = new StringBuilder();
                for (int colIdx = 1; colIdx <= columnCount; colIdx++) {
                    tableData.append(resultSet.getObject(colIdx));
                    if (colIdx != columnCount) {
                        tableData.append(" : ");
                    }
                }
                System.out.println(tableData);
            }

            resultSet.close();

        } catch (SQLException e) {
            System.out.println("Exception during SQL query execution " + e);
        }
    }

    @Override
    public void deleteRecord(int id) {
        String sql = "DELETE FROM athlete WHERE athlete_id = ?";

        try (PreparedStatement statement = Connection.getConnection().prepareStatement(sql)) {

            statement.setInt(1, id);

            statement.executeUpdate();

            System.out.println("Record is deleted");

        } catch (SQLException e) {
            System.out.println("Exception during SQL query execution" + e);
        }
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
