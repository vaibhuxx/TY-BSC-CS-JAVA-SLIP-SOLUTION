import java.sql.*;

 

public class Slip29a {

 
    static final String JDBC_DRIVER = "org.postgresql.Driver";

    static final String DB_URL = "jdbc:postgresql://localhost/stud";

 

    // Database credentials

    static final String USER = "postgres";

    static final String PASS = "vai123";

 

    public static void main(String[] args) {

        Connection conn = null;

        Statement stmt = null;

        ResultSet rs = null;

 

        try {

            Class.forName("org.postgresql.Driver");

            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.createStatement();

            String sql = "SELECT * FROM DONAR";

            rs = stmt.executeQuery(sql);

            ResultSetMetaData rsmd = rs.getMetaData();

            int columnCount = rsmd.getColumnCount();

            System.out.println("Column count: " + columnCount);

            for (int i = 1; i <= columnCount; i++) {

                String name = rsmd.getColumnName(i);

                String type = rsmd.getColumnTypeName(i);

                int size = rsmd.getColumnDisplaySize(i);

                System.out.println("Column " + i + ": " + name + " (" + type + ", " + size + ")");

            }

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        } catch (SQLException e) {

            e.printStackTrace();

        } finally {

            try {

                if (rs != null) {rs.close();}

                if (stmt != null) {stmt.close();}

                if (conn != null){conn.close();}

            } catch (SQLException e) {

                e.printStackTrace();

            }

        }

    }

}

 