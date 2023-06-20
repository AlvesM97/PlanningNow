package api.insert;

import api.BDConnection;

public class Schedule_insert {
    BDConnection conexaoBd = new BDConnection();

    public Schedule_insert(int ra, int id_monitoria) {
        conexaoBd.openConnection();
        String sqlQuery;

        sqlQuery = "INSERT INTO AGENDA (USUARIO_RA, MONITORIA_IDMONITORIA) VALUES ('" + ra + "', '" + id_monitoria + "')";

        conexaoBd.executarQueryInsert(sqlQuery);
    }

}
