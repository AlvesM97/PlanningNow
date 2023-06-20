package api.update;

import api.BDConnection;

public class Time_update {
    BDConnection conexaoBd = new BDConnection();

    public Time_update(int id_monitoria, int amount) {
        conexaoBd.openConnection();
        String sqlQuery;

        sqlQuery = "UPDATE MONITORIA SET QUANTIDADE = " + amount + " WHERE IDMONITORIA = " + id_monitoria + "";

        conexaoBd.executarQueryInsert(sqlQuery);
    }
}
