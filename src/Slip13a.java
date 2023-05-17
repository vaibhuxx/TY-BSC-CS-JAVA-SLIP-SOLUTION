import java.sql.*;

import java.util.ArrayList;

 

public class Slip13a {

   

    static final String JDBC_DRIVER = "org.postgresql.Driver";

    static final String DB_URL = "jdbc:postgresql://localhost/stud";

 

    // Database credentials

    static final String USER = "postgres";

    static final String PASS = "vai123";

 

    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {

            // Get DatabaseMetaData object

            DatabaseMetaData metaData = conn.getMetaData();

 

            // Display database information

            System.out.println("Database name: " + metaData.getDatabaseProductName());

            System.out.println("Database version: " + metaData.getDatabaseProductVersion());

            System.out.println("Driver name: " + metaData.getDriverName());

            System.out.println("Driver version: " + metaData.getDriverVersion());

 

            // Get all tables in the database

            ArrayList<String> tableNames = new ArrayList<>();

            ResultSet tables = metaData.getTables(null, null, null, new String[]{"TABLE"});

            while (tables.next()) {

                String tableName = tables.getString("TABLE_NAME");

                tableNames.add(tableName);

            }

 

            // Display table names

            System.out.println("\nTables in the database:");

            for (String tableName : tableNames) {

                System.out.println(tableName);

            }

 

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

}

 