package api.select;

import java.util.StringJoiner;

import api.BDConnection;
public class user_select {
    BDConnection conexaoBd = new BDConnection();

    public void getAll() {
        conexaoBd.openConnection();

        String sqlQuery;

        sqlQuery = "select * from usuario";

        conexaoBd.executarQueryGet(sqlQuery);
    }

    public StringJoiner get(String nome, String email) {
        conexaoBd.openConnection();

        String sqlQuery;

        sqlQuery = "select * from usuario where usuario.nome  = '" + nome + "' and usuario.email = '" + email + "'";

       StringJoiner result = conexaoBd.executarQueryGet(sqlQuery);
       return result;
    }
}
