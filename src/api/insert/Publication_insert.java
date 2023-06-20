package api.insert;

import api.BDConnection;

public class Publication_insert {

    BDConnection conexaoBd = new BDConnection();

    public void insert(String descricao, String usuario, String data, int Usuario_ra) {
        conexaoBd.openConnection();
        String sqlQuery;

        sqlQuery = "INSERT INTO PUBLICACAO (descricao, usuario, data, Usuario_ra) values ('" + descricao + "', '"
                + usuario + "','"
                + data + "','" + Usuario_ra + "')";
                
        conexaoBd.executarQueryInsert(sqlQuery);
    }
}
