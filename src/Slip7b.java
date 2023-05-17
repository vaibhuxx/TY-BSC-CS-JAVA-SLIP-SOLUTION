import java.sql.*;

 

public class Slip7b {

 

    // JDBC driver name and database URL

    static final String JDBC_DRIVER = "org.postgresql.Driver";

    static final String DB_URL = "jdbc:postgresql://localhost/stud";

 

    // Database credentials

    static final String USER = "postgres";

    static final String PASS = "vai123";

 

    public static void main(String[] args) {

 

        Connection conn = null;

        Statement stmt = null;

 

        try {

            // Register JDBC driver

            Class.forName(JDBC_DRIVER);

 

            // Open a connection

            System.out.println("Connecting to database...");

            conn = DriverManager.getConnection(DB_URL, USER, PASS);

 

            // Create a statement

            System.out.println("Creating statement...");

            stmt = conn.createStatement();

 

            // Create the Product table

            String createTableSQL = "CREATE TABLE Product  " +

                    "(Pid INT NOT NULL, " +

                    " Pname VARCHAR(50), " +

                    " Price int, " +

                    " PRIMARY KEY ( Pid ))";

            stmt.executeUpdate(createTableSQL);

            System.out.println("Product table created successfully");

 

            // Insert records into the Product table

            String insertSQL1 = "INSERT INTO Product (Pid, Pname, Price) " +

                    "VALUES (101, 'Product1', 20.0)";

            stmt.executeUpdate(insertSQL1);

            String insertSQL2 = "INSERT INTO Product (Pid, Pname, Price) " +

                    "VALUES (102, 'Product2', 30.0)";

            stmt.executeUpdate(insertSQL2);

            String insertSQL3 = "INSERT INTO Product (Pid, Pname, Price) " +

                    "VALUES (103, 'Product3', 40.0)";

            stmt.executeUpdate(insertSQL3);

            String insertSQL4 = "INSERT INTO Product (Pid, Pname, Price) " +

                    "VALUES (104, 'Product4', 50.0)";

            stmt.executeUpdate(insertSQL4);

            String insertSQL5 = "INSERT INTO Product (Pid, Pname, Price) " +

                    "VALUES (105, 'Product5', 60.0)";

            stmt.executeUpdate(insertSQL5);

            System.out.println("Records inserted into the Product table");

 

            // Retrieve and display all the records from the Product table

            String selectSQL = "SELECT * FROM Product";

            ResultSet rs = stmt.executeQuery(selectSQL);

            System.out.println(rs);

            while (rs.next()) {

                int pid = rs.getInt("Pid");

                String pname = rs.getString("Pname");

                double price = rs.getDouble("Price");

 

                System.out.println("Pid: " + pid + ", Pname: " + pname + ", Price: " + price);

            }

 

            // Clean-up environment

            rs.close();

            stmt.close();

            conn.close();

        } catch (SQLException se) {

            // Handle errors for JDBC

            se.printStackTrace();

        } catch (Exception e) {

            // Handle errors for Class.forName

            e.printStackTrace();

        } finally {

            // Finally block used to close resources

            try {

                if (stmt != null) 
                {stmt.close();}

            } catch (SQLException se2) {

            } // nothing we can do

            try {

                if (conn != null)
                { conn.close();}

            } catch (SQLException se) {

                se.printStackTrace();

            } // end finally try

        } // end try

        System.out.println("Goodbye!");

    } // end main

} // end ProductTable