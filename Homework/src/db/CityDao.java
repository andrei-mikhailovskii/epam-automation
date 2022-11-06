package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CityDao implements Dao<City> {

    @Override
    public List<City> getAll() {
        List<City> cities = new ArrayList<>();

        try (Statement st = Connection.getConnection().createStatement()) {

            ResultSet resultSet = st.executeQuery("SELECT * FROM TA_DB.dbo.city");

            while (resultSet.next()) {
                cities.add(new City(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getInt(3)));
            }
            resultSet.close();

        } catch (SQLException e) {
            System.out.println("Exception during SQL query execution " + e);
        }
        Connection.closeConnection();

        return cities;
    }

    @Override
    public int getAllRecords() {
        return 0;
    }

    @Override
    public List<City> getAggregated() {
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
    public void updateValue(String city, int people) {
        String sql = "UPDATE city SET citizen = ? WHERE city_name = ?";

        try (PreparedStatement preparedStatement = Connection.getConnection().prepareStatement(sql)) {

            preparedStatement.setString(2, city);
            preparedStatement.setInt(1, people);

            preparedStatement.executeUpdate();
            System.out.println("Amount of citizens in " + city + " has been set to " + people);

        } catch (SQLException e) {
            System.out.println("Exception during SQL query execution " + e);
        }
    }
}
