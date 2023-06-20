package controllers;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

public class Alerts {

    public Optional<ButtonType> showAlert(String title, String message, String type) {
        final Alert alert = new Alert(AlertType.NONE);

        if (type.equals("Warning")) {
            alert.setAlertType(AlertType.WARNING);
            
        }
        else if (type.equals("Sucess")) {
            alert.setAlertType(AlertType.CONFIRMATION);
        }
        else if(type.equals("information")){
            alert.setAlertType(AlertType.INFORMATION);
        }

        alert.setTitle(title);
        alert.setContentText(message);

        return alert.showAndWait();
    }

    public Optional<ButtonType> showSucess(String title, String message) {
        final Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

        alert.setTitle(title);
        alert.setContentText(message);

        return alert.showAndWait();
    }
}
