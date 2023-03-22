package controllers;

import api.BDConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class login_account_controller {

    BDConnection new_connection = new BDConnection();
    App app = new App();

    @FXML
    private TextField user_email;

    @FXML
    private PasswordField user_password;

    @FXML
    void createAccount(ActionEvent event) {
        app.changeScreen("register");
    }

    @FXML
    void login(ActionEvent event) {
        
    }

}
