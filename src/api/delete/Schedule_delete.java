package api.delete;

import api.BDConnection;

public class Schedule_delete {

    public void delete(int id_agenda) {
        BDConnection conexaoBd = new BDConnection();
        conexaoBd.openConnection();
        String sqlQuery;

        sqlQuery = "DELETE FROM AGENDA WHERE idAgenda = " + id_agenda + ";";

        conexaoBd.executarQueryInsert(sqlQuery);
    }

    public void deleteAll(int id_agenda) {
        BDConnection conexaoBd = new BDConnection();
        conexaoBd.openConnection();
        String sqlQuery;

        sqlQuery = "DELETE FROM AGENDA WHERE MONITORIA_IDMONITORIA = " + id_agenda + ";";

        conexaoBd.executarQueryInsert(sqlQuery);
    }
}
