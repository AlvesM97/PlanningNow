package api.select;

import api.BDConnection;
public class user_select {
    BDConnection conexaoBd = new BDConnection();

    public void getAll() {
        conexaoBd.openConnection();

        String sqlQuery;

        sqlQuery = "select * from usuario";

        conexaoBd.executarQuery(sqlQuery);
    }

    public void get(String nome, String email) {
        conexaoBd.openConnection();

        String sqlQuery;

        sqlQuery = "select * from usuario where usuario.nome  = '" + nome + "' and usuario.email = '" + email + "'";

        conexaoBd.executarQuery(sqlQuery);
    }
}
