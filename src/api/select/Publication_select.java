package api.select;

import java.util.StringJoiner;

import api.BDConnection;

public class Publication_select {

    public StringJoiner getAll() {
        BDConnection conexaoBd = new BDConnection();
        conexaoBd.openConnection();
        String sqlQuery;

        sqlQuery = "SELECT * FROM PUBLICACAO ORDER BY idPublicacao DESC";

        StringJoiner result = conexaoBd.executarQueryGet(sqlQuery);

        return result;
    }

    public String getCount() {
        BDConnection conexaoBd = new BDConnection();
        conexaoBd.openConnection();
        String sqlQuery;

        sqlQuery = "SELECT COUNT(*) FROM PUBLICACAO";

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
