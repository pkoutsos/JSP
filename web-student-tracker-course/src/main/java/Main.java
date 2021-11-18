import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    private static final String USERNAME = "webstudent";
    private static final String PASSWORD = "webstudent";
    private static final String CONN_STRING =
            "jdbc:mysql://localhost/web_student_tracker";

    public static void main(String[] args) throws SQLException {

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            System.out.println("Connected!");
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            if (connection != null){
                connection.close();
            }
        }

    }

}