package controller;

import api.BDConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class register_controller {

    BDConnection conexaoBd = new BDConnection();

    @FXML
    private Button botaoCadastro;

    @FXML
    private TextField campoEmail;

    @FXML
    private TextField campoSenha;

    @FXML
    private TextField campoUsuario;

    @FXML
    void fazerCadastro(ActionEvent event) {
        String usuario = campoUsuario.getText();
        String senha = campoSenha.getText();
        String email = campoEmail.getText();

        conexaoBd.openConnection();

        String sqlQuery;

        sqlQuery = "insert into usuario (nome, email, senha) values ('"+usuario+"', '"+email+"', '"+senha+"')";

        conexaoBd.executarQuery(sqlQuery);
    }

}