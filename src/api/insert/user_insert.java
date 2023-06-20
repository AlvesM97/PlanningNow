package api.insert;

import api.BDConnection;

public class User_insert {

    BDConnection conexaoBd = new BDConnection();

    public void insert(int ra, String password, int type, String name, String cursor) {
        conexaoBd.openConnection();
        String sqlQuery;

        sqlQuery = "INSERT INTO USUARIO (ra, senha, tipo, nome, curso) values ('" + ra + "', '" + password + "','"
                + type + "','" + name + "', '" + cursor + "')";
                
        conexaoBd.executarQueryInsert(sqlQuery);
    }

}