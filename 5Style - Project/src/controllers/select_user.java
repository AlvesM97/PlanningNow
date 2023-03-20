package controllers;

import api.BDConnection;
import javafx.event.ActionEvent;

public class select_user {

    BDConnection conexaoBd = new BDConnection();

    void fazerCadastro() {
        conexaoBd.openConnection();

        String sqlQuery;

        sqlQuery = "insert into usuario (nome, email, senha) values ('Gustavo', 'gutogmail.com', '1234')";

        conexaoBd.executarQuery(sqlQuery);
    }

}