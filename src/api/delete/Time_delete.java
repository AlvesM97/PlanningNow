package api.delete;

import api.BDConnection;

public class Time_delete {
    public Time_delete(int id_monitoria) {
        BDConnection conexaoBd = new BDConnection();
        conexaoBd.openConnection();
        String sqlQuery;

        sqlQuery = "DELETE FROM MONITORIA WHERE IDMONITORIA = " + id_monitoria + "";

        conexaoBd.executarQueryInsert(sqlQuery);
    }
}
