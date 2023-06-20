package api.select;

import java.util.StringJoiner;

import api.BDConnection;

public class Schedule_select {

    public StringJoiner getAll(int ra) {
        BDConnection conexaoBd = new BDConnection();
        conexaoBd.openConnection();
        String sqlQuery;

        sqlQuery = "SELECT * FROM AGENDA WHERE USUARIO_RA = " + ra + "  ORDER BY IDAGENDA DESC";

        StringJoiner result = conexaoBd.executarQueryGet(sqlQuery);

        return result;
    }

    public String getCount(int ra) {
        BDConnection conexaoBd = new BDConnection();
        conexaoBd.openConnection();
        String sqlQuery;

        sqlQuery = "SELECT COUNT(*) FROM AGENDA WHERE USUARIO_RA = " + ra + "";

        StringJoiner resultQueryGet = conexaoBd.executarQueryGet(sqlQuery);
        String result = "";
        for (int x = 0; x < resultQueryGet.length(); x++) {
            if (resultQueryGet.toString().substring(x, x + 1).equals("=")) {
                for (int y = x + 1; y < resultQueryGet.length(); y++) {
                    if (resultQueryGet.toString().substring(y, y + 1).equals("]")) {
                        result = resultQueryGet.toString().substring(x + 1, y);
                        break;
                    }
                }

            }
        }
        return result;
    }

    public String getVerify(int ra, int monitoria) {
        BDConnection conexaoBd = new BDConnection();
        conexaoBd.openConnection();
        String sqlQuery;

        sqlQuery = "SELECT COUNT(*) FROM AGENDA WHERE USUARIO_RA = " + ra + " AND MONITORIA_IDMONITORIA = " + monitoria
                + ";";

        StringJoiner resultQueryGet = conexaoBd.executarQueryGet(sqlQuery);
        String result = "";
        for (int x = 0; x < resultQueryGet.length(); x++) {
            if (resultQueryGet.toString().substring(x, x + 1).equals("=")) {
                for (int y = x + 1; y < resultQueryGet.length(); y++) {
                    if (resultQueryGet.toString().substring(y, y + 1).equals("]")) {
                        result = resultQueryGet.toString().substring(x + 1, y);
                        break;
                    }
                }

            }
        }
        return result;
    }
}
