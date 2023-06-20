package controllers;

import java.io.IOException;
import java.util.StringJoiner;

import api.BDConnection;
import api.select.User_select;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import models.User;

public class Login_account_controller {

    User_select user_select = new User_select();
    App app = new App();
    BDConnection conexaoBd = new BDConnection();
    Alerts alert = new Alerts();

    @FXML
    private TextField user_ra;

    @FXML
    private PasswordField user_password;

    @FXML
    void loginAccount(ActionEvent event) throws IOException {
        if (user_ra.getText().length() == 0 || user_password.getText().length() == 0) {
            alert.showAlert("Erro", "Preencha todos os campos", "Warning");
        } else {
            StringJoiner userLogin = user_select.getLogin(Integer.parseInt(user_ra.getText()), user_password.getText());
            if (userLogin.length() == 2) {
                alert.showAlert("Erro", "Conta não existente", "Warning");
                userLogin = null;
            } else {
                User user = new User();

                int cont = 0;
                for (int x = 0; x < userLogin.length(); x++) {
                    if (userLogin.toString().substring(x, x + 1).equals("=")) {
                        for (int y = x + 1; y < userLogin.length(); y++) {
                            if (userLogin.toString().substring(y, y + 1).equals(",")
                                    || userLogin.toString().substring(y, y + 1).equals("]")) {

                                if (cont == 0) {
                                    user.setUser_ra(Integer.parseInt(userLogin.toString().substring(x + 1, y)));
                                    cont++;
                                } else if (cont == 1) {
                                    user.setUser_password(userLogin.toString().substring(x + 1, y));
                                    cont++;
                                } else if (cont == 2) {
                                    user.setUser_type(Integer.parseInt(userLogin.toString().substring(x + 1, y)));
                                    cont++;
                                } else if (cont == 3) {
                                    user.setUser_name(userLogin.toString().substring(x + 1, y));
                                    cont++;
                                } else {
                                    user.setUser_cursor(userLogin.toString().substring(x + 1, y));
                                    cont++;
                                }
                                break;
                            }
                        }

                    }
                }
                String ra = Integer.toString(user.getUser_ra());
                app.addUser(ra, user.getUser_name(), user.getUser_type());
                user_ra.setText(null);
                user_password.setText("");
                app.changeScreen("feed");
                Feed_controller feed = new Feed_controller();
                feed.refreshFeed();
                userLogin = null;
            }
        }

    }

    @FXML
    void createAccountScreen(ActionEvent event) throws IOException {
        app.changeScreen("register");
    }

}
