package api.insert;

import api.BDConnection;
import javafx.event.ActionEvent;

public class user_insert {

    BDConnection conexaoBd = new BDConnection();

    public void insert() {
        conexaoBd.openConnection();

        String sqlQuery;

        sqlQuery = "insert into usuario (nome, email, senha) values ('Enrique', 'Enriquegmail.com', '1234')";

        conexaoBd.executarQuery(sqlQuery);
    }

}