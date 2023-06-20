package api.insert;

import java.sql.*;

public class Time_insert {

    String url = "jdbc:mysql://localhost:3306/planningnow";
    String username = "Gustavo";
    String password = "1234";

    public Time_insert(int Usuario_ra, String data, String hora, String disciplina, String sala,
            int quantidade) {
        try (
                Connection connection = DriverManager.getConnection(url, username, password)) {
            String insertMonitoriaQuery = "INSERT INTO monitoria (Usuario_ra, data, hora, disciplina, sala, quantidade) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement insertMonitoriaStatement = connection.prepareStatement(insertMonitoriaQuery,
                    Statement.RETURN_GENERATED_KEYS);
            insertMonitoriaStatement.setInt(1, Usuario_ra);
            insertMonitoriaStatement.setString(2, data);
            insertMonitoriaStatement.setString(3, hora);
            insertMonitoriaStatement.setString(4, disciplina);
            insertMonitoriaStatement.setString(5, sala);
            insertMonitoriaStatement.setInt(6, quantidade);
            insertMonitoriaStatement.executeUpdate();

            ResultSet generatedKeys = insertMonitoriaStatement.getGeneratedKeys();
            int idMonitoria = 0;
            if (generatedKeys.next()) {
                idMonitoria = generatedKeys.getInt(1);
            }

            String insertAgendaQuery = "INSERT INTO agenda (Usuario_ra, monitoria_IdMonitoria) VALUES (?, ?)";
            PreparedStatement insertAgendaStatement = connection.prepareStatement(insertAgendaQuery);
            insertAgendaStatement.setInt(1, Usuario_ra);
            insertAgendaStatement.setInt(2, idMonitoria);
            insertAgendaStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
