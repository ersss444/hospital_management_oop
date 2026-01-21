package hospital.management;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/hospital_db";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "ER2008nur";

    public static Connection connect() throws Exception {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
