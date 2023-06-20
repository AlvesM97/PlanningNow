package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.StringJoiner;

import api.insert.Schedule_insert;
import api.select.Schedule_select;
import api.select.Time_select;
import api.update.Time_update;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.Monitoring;
import models.User;

public class TimeM_controller implements Initializable {
    @FXML
    private Button openDialogButton;
    @FXML
    private Pane mensage1;
    @FXML
    private Pane mensage2;
    @FXML
    private Pane mensage3;
    @FXML
    private Pane mensage4;
    @FXML
    private Pane mensage5;

    @FXML
    private Text textDiscipline1;
    @FXML
    private Text textDiscipline2;
    @FXML
    private Text textDiscipline3;
    @FXML
    private Text textDiscipline4;
    @FXML
    private Text textDiscipline5;

    @FXML
    private Text textName1;
    @FXML
    private Text textName2;
    @FXML
    private Text textName3;
    @FXML
    private Text textName4;
    @FXML
    private Text textName5;

    @FXML
    private Text textNameAbrev1;
    @FXML
    private Text textNameAbrev2;
    @FXML
    private Text textNameAbrev3;
    @FXML
    private Text textNameAbrev4;
    @FXML
    private Text textNameAbrev5;

    @FXML
    private Text textDate1;
    @FXML
    private Text textDate2;
    @FXML
    private Text textDate3;
    @FXML
    private Text textDate4;
    @FXML
    private Text textDate5;

    @FXML
    private Text textRoom1;
    @FXML
    private Text textRoom2;
    @FXML
    private Text textRoom3;
    @FXML
    private Text textRoom4;
    @FXML
    private Text textRoom5;

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    Time_select timeS = new Time_select();
    App app = new App();
    User user;
    Alerts alert = new Alerts();
    Monitoring monitoring = new Monitoring();
    ArrayList<Monitoring> monitoringsList = new ArrayList<Monitoring>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (this.mensage1 != null) {
            refreshFeed();
        }

    }

    @FXML
    void logout(ActionEvent event) throws IOException {
        app.changeScreen("login");
    }

    @FXML
    void goFeed(ActionEvent event) throws IOException {
        app.changeScreen("feed");
    }

    @FXML
    void goSchedule(ActionEvent event) throws IOException {
        app.changeScreen("schedule");
    }

    @FXML
    private void createTime() throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/screens/newTime_screen.fxml"));
            Pane pane = fxmlLoader.load();

            DialogPane dialogPane = new DialogPane();
            dialogPane.setContent(pane);

            Dialog<String> dialog = new Dialog<>();
            dialog.setDialogPane(dialogPane);
            dialog.initOwner(stage);

            dialog.showAndWait();
            refreshFeed();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeDialog() {
        refreshFeed();
    }

    public void refreshFeed() {
        StringJoiner times = timeS.getAll();
        int cont = 0;
        int cont2 = 0;
        monitoring = new Monitoring();
        monitoringsList.clear();
        for (int x = 0; x < times.length(); x++) {
            if (times.toString().substring(x, x + 1).equals("=")) {
                for (int y = x + 1; y < times.length(); y++) {
                    if (times.toString().substring(y, y + 1).equals(",")
                            || times.toString().substring(y, y + 1).equals("]")) {
                        if (cont == 0) {
                            monitoring.setMonitoring(Integer.parseInt(times.toString().substring(x + 1, y)));
                            cont++;
                        } else if (cont == 1) {
                            monitoring.setUser(Integer.parseInt(times.toString().substring(x + 1, y)));
                            cont++;
                        } else if (cont == 2) {
                            monitoring.setDate(times.toString().substring(x + 1, y));
                            cont++;
                        } else if (cont == 3) {
                            monitoring.setHour(times.toString().substring(x + 1, y));
                            cont++;
                        } else if (cont == 4) {
                            monitoring.setDiscipline(times.toString().substring(x + 1, y));
                            cont++;
                        } else if (cont == 5) {
                            monitoring.setRoom(times.toString().substring(x + 1, y));
                            cont++;
                        } else {
                            monitoring.setQuantity(Integer.parseInt(times.toString().substring(x + 1, y)));
                            monitoringsList.add(monitoring);
                            monitoring = new Monitoring();
                            cont = 0;
                        }
                        break;
                    }
                }
            }
        }

        cont2 = Integer.parseInt(getCount());
        if (monitoringsList.size() > 0) {
            for (int i = 0; i < cont2; i++) {
                String name = timeS.getNameMonitor(monitoringsList.get(i).getMonitoring(),
                        monitoringsList.get(i).getUser());
                String[] palavras = name.split(" ");

                String primeiroNome = palavras[0];

                String segundoNome = palavras[1];

                char primeiraLetraPrimeiroNome = primeiroNome.charAt(0);
                char primeiraLetraSegundoNome = segundoNome.charAt(0);

                String resultado = Character.toString(primeiraLetraPrimeiroNome)
                        + Character.toString(primeiraLetraSegundoNome);
                if (i == 0) {
                    mensage1.setVisible(true);
                    textDiscipline1.setText(monitoringsList.get(i).getDiscipline());
                    textNameAbrev1.setText(resultado);
                    textName1.setText(name);
                    textDate1.setText(monitoringsList.get(i).getDate() + " " + monitoringsList.get(i).getHour());
                    textRoom1.setText("sala: " + monitoringsList.get(i).getRoom());
                } else if (i == 1) {
                    mensage2.setVisible(true);
                    textDiscipline2.setText(monitoringsList.get(i).getDiscipline());
                    textNameAbrev2.setText(resultado);
                    textName2.setText(name);
                    textDate2.setText(monitoringsList.get(i).getDate() + " " + monitoringsList.get(i).getHour());
                    textRoom2.setText("sala: " + monitoringsList.get(i).getRoom());
                } else if (i == 2) {
                    mensage3.setVisible(true);
                    textDiscipline3.setText(monitoringsList.get(i).getDiscipline());
                    textNameAbrev3.setText(resultado);
                    textName3.setText(name);
                    textDate3.setText(monitoringsList.get(i).getDate() + " " + monitoringsList.get(i).getHour());
                    textRoom3.setText("sala: " + monitoringsList.get(i).getRoom());
                } else if (i == 3) {
                    mensage4.setVisible(true);
                    textDiscipline4.setText(monitoringsList.get(i).getDiscipline());
                    textNameAbrev4.setText(resultado);
                    textName4.setText(name);
                    textDate4.setText(monitoringsList.get(i).getDate() + " " + monitoringsList.get(i).getHour());
                    textRoom4.setText("sala: " + monitoringsList.get(i).getRoom());
                } else if (i == 4) {
                    mensage5.setVisible(true);
                    textDiscipline5.setText(monitoringsList.get(i).getDiscipline());
                    textNameAbrev5.setText(resultado);
                    textName5.setText(name);
                    textDate5.setText(monitoringsList.get(i).getDate() + " " + monitoringsList.get(i).getHour());
                    textRoom5.setText("sala: " + monitoringsList.get(i).getRoom());
                } else {
                }
            }

        }
    }

    public String getCount() {
        String countP = timeS.getCount();

        return countP;
    }

    @FXML
    private void click1() {
        createSchedule(0);
    }

    @FXML
    private void click2() {
        createSchedule(1);
    }

    @FXML
    private void click3() {
        createSchedule(2);
    }

    @FXML
    private void click4() {
        createSchedule(3);
    }

    @FXML
    private void click5() {
        createSchedule(4);
    }

    public void createSchedule(int index) {
        Schedule_select schedule_select = new Schedule_select();
        if (schedule_select.getVerify(Integer.parseInt(app.getUser()[0]), monitoringsList.get(index).getMonitoring())
                .equals("0")) {
            new Schedule_insert(Integer.parseInt(app.getUser()[0]), monitoringsList.get(index).getMonitoring());
            new Time_update(monitoringsList.get(index).getMonitoring(), (monitoringsList.get(index).getQuantity() - 1));
            alert.showAlert("Agendado", "Mentoria agendada com sucesso", "Sucess");
        } else {
            alert.showAlert("Alerta", "Mentoria já agentada!", "information");
        }
        refreshFeed();
    }

}
