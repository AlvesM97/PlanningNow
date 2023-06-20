package controllers;

import api.insert.Time_insert;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewTime_controller {
    App app = new App();
    @FXML
    private TextField textDiscipline;

    @FXML
    private ChoiceBox boxDays;

    @FXML
    private ChoiceBox boxTimes;

    @FXML
    private TextField textClass;

    @FXML
    private TextField textAmount;

    @FXML
    public void initialize() {
        boxDays.getItems().addAll("Segunda-Feira", "Terça-Feira", "Quarta-Feira", "Quinta-Feira", "Sexta-Feira",
                "Sabado", "Domingo");
        boxTimes.getItems().addAll(
                "07:30 / 08:20 (M1)",
                "08:20 / 09:10 (M2)",
                "09:10 / 10:00 (M3)",
                "10:20 / 11:10 (M4)",
                "11:10 / 12:00 (M5)",
                "12:00 / 12:50 (M6)",
                "13:00 / 13:50 (T1)",
                "13:50 / 14:40 (T2)",
                "14:40 / 15:30 (T3)",
                "15:50 / 16:40 (T4)",
                "16:40 / 17:30 (T5)",
                "17:50 / 18:40 (T6)",
                "18:40 / 19:30 (N1)",
                "19:30 / 20:20 (N2)",
                "20:20 / 21:10 (N3)",
                "21:20 / 22:10 (N4)",
                "22:10 / 23:00 (N5)");
    }

    @FXML
    private void createTime() {
        String discipline = textDiscipline.getText();
        String day = boxDays.getValue().toString();
        String time = boxTimes.getValue().toString();
        int amount = Integer.parseInt(textAmount.getText());
        String classe = textClass.getText();

        new Time_insert(Integer.parseInt(app.getUser()[0]), day, time, discipline, classe, amount);

        System.out.println(discipline + day + time + amount + classe);

        TimeM_controller timeM = new TimeM_controller();
        close();
        timeM.closeDialog();
    }

    @FXML
    private void close() {
        Stage dialogStage = (Stage) boxTimes.getScene().getWindow();
        dialogStage.close();
    }
}
