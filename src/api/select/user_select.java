package api.select;

import java.util.StringJoiner;

import api.BDConnection;

public class User_select {
    BDConnection conexaoBd = new BDConnection();

    public void getAll() {
        conexaoBd.openConnection();

        String sqlQuery;

        sqlQuery = "select * from usuario";

        conexaoBd.executarQueryGet(sqlQuery);
    }

    public StringJoiner getLogin(int ra, String password) {
        conexaoBd.openConnection();
        String sqlQuery;

        sqlQuery = "SELECT * FROM usuario WHERE usuario.ra = '" + ra + "' AND usuario.senha = '" + password + "'";

        StringJoiner result = conexaoBd.executarQueryGet(sqlQuery);

        return result;
    }

    public StringJoiner getRA(int ra) {
        conexaoBd.openConnection();
        String sqlQuery;

        sqlQuery = "SELECT * FROM usuario WHERE usuario.ra = '" + ra + "'";

        StringJoiner result = conexaoBd.executarQueryGet(sqlQuery);

        return result;
    }
}
