package db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VariousTablesDao implements Dao {

    @Override
    public int getAllRecords() {
        int recordsAmount = 0;

        try (Statement st = Connection.getConnection().createStatement()) {
            ResultSet resultSet = st.executeQuery("SELECT COUNT(*) FROM (SELECT athlete_id FROM athlete UNION ALL SELECT university_id FROM university UNION ALL SELECT city_id FROM city) AS row_amount");
            StringBuilder resultText = new StringBuilder();
            while (resultSet.next()) {
                resultText.append("Total amount of records: " + resultSet.getInt(1));
            }
            System.out.println(resultText);
            resultSet.close();
        } catch (SQLException e) {
            System.out.println("Exception during SQL query execution " + e);
        }

        return recordsAmount;
    }

    @Override
    public List getAggregated() {
        List<String> cityStudents = new ArrayList();

        try (Statement st = Connection.getConnection().createStatement()) {

            ResultSet resultSet = st.executeQuery("SELECT city_name, SUM(student_quantity) AS student_total FROM city c JOIN university u ON u.city_id = c.city_id GROUP BY city_name");

            while (resultSet.next()) {
                cityStudents.add(resultSet.getString(1));
                cityStudents.add(String.valueOf(resultSet.getInt(2)));
            }
            resultSet.close();
        } catch (SQLException e) {
            System.out.println("Exception during SQL query execution " + e);
        }

        return cityStudents;
    }

    @Override
    public void getAllFromAll() {
        try (Statement st = Connection.getConnection().createStatement()) {

            ResultSet resultSet = st.executeQuery("SELECT * FROM athlete a JOIN university u ON u.university_id = a.university_id JOIN city c ON c.city_id = u.city_id ORDER BY first_name");

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
    public void getBetweenInLike() {
    }

    @Override
    public void deleteRecord(int id) {

    }

    @Override
    public void fromScratch() {

    }

    @Override
    public void deleteAllRecords(String table) {

        try (Statement statement = Connection.getConnection().createStatement()) {

            String cancelForeignKey = "EXEC sp_msforeachtable \"ALTER TABLE ? NOCHECK CONSTRAINT all\"";
            String sqlTruncate = "DELETE FROM " + table;

            statement.execute(cancelForeignKey);
            statement.execute(sqlTruncate);
            System.out.println("All data in table " + table + " have been deleted");

        } catch (SQLException e) {
            System.out.println("Exception during SQL query execution " + e);
        }
    }

    @Override
    public void updateValue(String s, int i) {

    }

    //
    @Override
    public List getAll() {
        return null;
    }
}
