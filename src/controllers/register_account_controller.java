package controllers;

import api.BDConnection;
import models.User;
import api.insert.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class register_account_controller {

    BDConnection new_connection = new BDConnection();
    user_insert user = new user_insert();
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
        user.insert(new_user.getUser_name(), new_user.getUser_email(), new_user.getUser_password());

        System.out.println(new_user.getUser_email());
    }

    @FXML
    void login(ActionEvent event) {
        app.changeScreen("login");
    }

}
