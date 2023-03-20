package controllers;

import api.BDConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class register_controller {

    BDConnection new_connection = new BDConnection();
    App teste = new App();
    @FXML
    private TextField user_login;

    @FXML
    private TextField user_password;

    @FXML
    private TextField user_registration_email;

    @FXML
    private TextField user_registration_name;

    @FXML
    private TextField user_registration_password;

    @FXML
    void login(ActionEvent event) {
        System.out.println("Login funcionando!");

        teste.changeScreen("home");
    }

    @FXML
    void register(ActionEvent event) {
        System.out.println("Cadastro funcionando!");
    }

}