package controllers;

import api.BDConnection;
import api.insert.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class register_account_controller {

    BDConnection new_connection = new BDConnection();
    user_insert insert = new user_insert();
    App app = new App();

    @FXML
    private TextField user_email;

    @FXML
    private TextField user_name;

    @FXML
    private PasswordField user_password;

    @FXML
    void createAccount(ActionEvent event) {
        insert.insert(user_name.getText(), user_email.getText(), user_password.getText());
    }

    @FXML
    void login(ActionEvent event) {
        app.changeScreen("login");
    }

}
