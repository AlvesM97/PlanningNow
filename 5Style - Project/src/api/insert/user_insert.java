package api.insert;

import api.BDConnection;
import javafx.event.ActionEvent;

public class user_insert {

    BDConnection conexaoBd = new BDConnection();

    public void insert(String name, String email, String password) {
        conexaoBd.openConnection();

        String sqlQuery;

        sqlQuery = "insert into usuario (nome, email, senha) values ('"+name+"', '"+email+"', '"+password+"')";

        conexaoBd.executarQuery(sqlQuery);
    }

}