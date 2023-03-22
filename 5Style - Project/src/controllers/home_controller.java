package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class home_controller {

    App app = new App();

    @FXML
    void register(ActionEvent event) {
        app.changeScreen("register");
    }

}
