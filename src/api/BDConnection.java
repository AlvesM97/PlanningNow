package api;


import java.sql.*;

public class BDConnection {
    
    public static String url = "jdbc:mysql://localhost:3306/5style";
    public static String user = "Gustavo";
    public static String pswd = "1234";

    private Connection db_connection = null;
    private Statement sql_management = null;
    private ResultSet result_sql = null;

    public void openConnection() {
        
        try {
            db_connection = DriverManager.getConnection(url, user, pswd);
            System.out.println("ConexÃ£o feita.");
            sql_management = db_connection.createStatement();
        } catch (Exception Error) {
            System.out.println(Error.getMessage());
        }

    }

    public void closeDatabase() throws SQLException {
        sql_management.close();
        db_connection.close();
    } 

    public int executarQuery(String sql) {

        try {
            return sql_management.executeUpdate(sql);
        } catch (Exception Error) { 
            System.out.println(Error.getMessage());
        }

        return -1;
    }

}