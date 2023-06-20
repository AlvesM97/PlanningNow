package controllers;

import java.io.IOException;
import java.util.StringJoiner;
import api.BDConnection;
import models.User;
import api.insert.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class Register_account_controller {

    BDConnection new_connection = new BDConnection();
    User_insert user = new User_insert();
    StringJoiner joinerTest = new StringJoiner(", ", "[", "]");
    StringJoiner joinerResult = new StringJoiner(", ", "[", "]");
    Alerts alert = new Alerts();

    App app = new App();

    @FXML
    private TextField user_ra;

    @FXML
    private TextField user_name;

    @FXML
    private PasswordField user_password;

    @FXML
    private PasswordField user_confirmPassword;

    @FXML
    private TextField user_cursor;

    @FXML
    private RadioButton student;

    @FXML
    private RadioButton monitor;

    private int type = 0;

    @FXML

    void createAccount(ActionEvent event) throws IOException {
        User new_user = new User(Integer.parseInt(user_ra.getText()), user_password.getText(), type,
                user_name.getText(), user_cursor.getText());

        if (user_password.getText().equals(user_confirmPassword.getText())) {
            user.insert(new_user.getUser_ra(), new_user.getUser_password(), new_user.getUser_type(),
                    new_user.getUser_name(), new_user.getUser_cursor());
            limparCampos();
            app.changeScreen("login");
        } else {
            alert.showAlert("senha", "As senhas devem ser iguais", "Warning");
        }
    }

    @FXML
    void click_student() {
        monitor.setSelected(false);
        type = 0;
    }

    @FXML
    void click_monitor() {
        student.setSelected(false);
        type = 1;
    }

    @FXML
    void loginAccountScreen(ActionEvent event) throws IOException {
        app.changeScreen("login");
    }

    void limparCampos() {
        user_ra.setText(null);
        user_name.setText("");
        user_password.setText("");
        user_cursor.setText("");
        user_confirmPassword.setText("");
    }
}
