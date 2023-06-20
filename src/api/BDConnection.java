package api;

import java.sql.*;
import java.util.StringJoiner;

public class BDConnection {
    public static String url = "jdbc:mysql://localhost:3306/planningnow";
    public static String user = "Gustavo";
    public static String pswd = "1234";

    private Connection db_connection = null;
    private Statement sql_management = null;
    private StringJoiner joiner = new StringJoiner(", ", "[", "]");

    public void openConnection() {

        try {
            db_connection = DriverManager.getConnection(url, user, pswd);
            sql_management = db_connection.createStatement();
        } catch (Exception Error) {
            System.out.println(Error.getMessage());
        }

    }

    public void closeDatabase() throws SQLException {
        sql_management.close();
        db_connection.close();
    }

    public int executarQueryInsert(String sql) {

        try {
            return sql_management.executeUpdate(sql);
        } catch (Exception Error) {
            System.out.println(Error.getMessage());
        }

        return -1;
    }

    public StringJoiner executarQueryGet(String sql) {

        try {

            ResultSet rs = sql_management.executeQuery(sql);
            ResultSetMetaData metaData = rs.getMetaData();
            int numeroDeColunas = metaData.getColumnCount();

            while (rs.next()) {
                for (int coluna = 1; coluna <= numeroDeColunas; coluna++) {
                    String nomeDaColuna = metaData.getColumnName(coluna);
                    joiner.add(nomeDaColuna + "=" + rs.getObject(coluna));
                }
            }
            
            rs.close();
            return joiner;

        } catch (Exception Error) {
            System.out.println(Error.getMessage());
            return null;
        }
    }
}
