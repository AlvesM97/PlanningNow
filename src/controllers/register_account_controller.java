package controllers;

import java.util.StringJoiner;

import api.BDConnection;
import models.User;
import api.insert.*;
import api.select.user_select;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class register_account_controller {

    BDConnection new_connection = new BDConnection();
    user_insert user = new user_insert();
    user_select userSelect = new user_select();
    StringJoiner joinerTest = new StringJoiner(", ", "[", "]");
    StringJoiner joinerResult = new StringJoiner(", ", "[", "]");

    App app = new App();

    @FXML
    private TextField user_email;

    @FXML
    private TextField user_name;

    @FXML
    private PasswordField user_password;

    @FXML
    void createAccount(ActionEvent event) {
        User new_user = new User(user_name.getText(), user_email.getText(), user_password.getText());
        joinerResult = userSelect.get(new_user.getUser_name(), new_user.getUser_email());
        System.out.println(joinerResult);
        System.out.println(joinerTest);

        if (joinerResult != joinerTest) {
            System.out.println("Conta já existente");

        } else {
            user.insert(new_user.getUser_name(), new_user.getUser_email(), new_user.getUser_password());

        }

    }

    @FXML
    void login(ActionEvent event) {
        app.changeScreen("login");
    }

}
