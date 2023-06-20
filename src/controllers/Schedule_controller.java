package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.StringJoiner;

import api.delete.Schedule_delete;
import api.delete.Time_delete;
import api.select.Schedule_select;
import api.select.Time_select;
import api.update.Time_update;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import models.Monitoring;
import models.Schedule;
import models.User;

public class Schedule_controller implements Initializable {

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

    Schedule_select scheduleS = new Schedule_select();
    Time_select timeS = new Time_select();
    App app = new App();
    User user;
    Alerts alert = new Alerts();
    Schedule schedule = new Schedule();
    Monitoring monitoring = new Monitoring();
    ArrayList<Schedule> scheduleList = new ArrayList<Schedule>();
    ArrayList<Monitoring> monitoringList = new ArrayList<Monitoring>();

    @FXML
    void logout(ActionEvent event) throws IOException {
        app.changeScreen("login");
    }

    @FXML
    void goFeed(ActionEvent event) throws IOException {
        app.changeScreen("feed");
    }

    @FXML
    void goTime(ActionEvent event) throws IOException {
        app.changeScreen("time");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (this.mensage1 != null) {
            refreshFeed();
        }
    }

    public void refreshFeed() {
        StringJoiner times = null;
        times = scheduleS.getAll(Integer.parseInt(app.getUser()[0]));

        int cont = 0;
        int cont2 = 0;
        schedule = new Schedule();
        scheduleList.clear();
        for (int x = 0; x < times.length(); x++) {
            if (times.toString().substring(x, x + 1).equals("=")) {
                for (int y = x + 1; y < times.length(); y++) {
                    if (times.toString().substring(y, y + 1).equals(",")
                            || times.toString().substring(y, y + 1).equals("]")) {
                        if (cont == 0) {
                            schedule.setIdSchedule(Integer.parseInt(times.toString().substring(x + 1, y)));
                            cont++;
                        } else if (cont == 1) {
                            schedule.setUser(Integer.parseInt(times.toString().substring(x + 1, y)));
                            cont++;
                        } else {
                            schedule.setMonitoring(Integer.parseInt(times.toString().substring(x + 1, y)));
                            scheduleList.add(schedule);
                            schedule = new Schedule();
                            cont = 0;
                        }
                        break;
                    }
                }
            }
        }

        cont2 = Integer.parseInt(getCount());
        if (scheduleList.size() > 0) {

            for (int i = 0; i < cont2; i++) {
                monitoring = timeS.getTimeForSchedule(scheduleList.get(i).getMonitoring());
                monitoringList.add(monitoring);

                String name = timeS.getNameMonitor(monitoring.getMonitoring(),
                        monitoring.getUser());
                String[] palavras = name.split(" ");

                String primeiroNome = palavras[0];

                String segundoNome = palavras[1];

                char primeiraLetraPrimeiroNome = primeiroNome.charAt(0);
                char primeiraLetraSegundoNome = segundoNome.charAt(0);

                String resultado = Character.toString(primeiraLetraPrimeiroNome)
                        + Character.toString(primeiraLetraSegundoNome);
                if (i == 0) {
                    mensage1.setVisible(true);
                    textDiscipline1.setText(monitoring.getDiscipline());
                    textNameAbrev1.setText(resultado);
                    textName1.setText(name);
                    textDate1.setText(monitoring.getDate() + " " + monitoring.getHour());
                    textRoom1.setText("Sala: " + monitoring.getRoom());
                } else if (i == 1) {
                    mensage2.setVisible(true);
                    textDiscipline2.setText(monitoring.getDiscipline());
                    textNameAbrev2.setText(resultado);
                    textName2.setText(name);
                    textDate2.setText(monitoring.getDate() + " " + monitoring.getHour());
                    textRoom2.setText("Sala: " + monitoring.getRoom());
                } else if (i == 2) {
                    mensage3.setVisible(true);
                    textDiscipline3.setText(monitoring.getDiscipline());
                    textNameAbrev3.setText(resultado);
                    textName3.setText(name);
                    textDate3.setText(monitoring.getDate() + " " + monitoring.getHour());
                    textRoom3.setText("Sala: " + monitoring.getRoom());
                } else if (i == 3) {
                    mensage4.setVisible(true);
                    textDiscipline4.setText(monitoring.getDiscipline());
                    textNameAbrev4.setText(resultado);
                    textName4.setText(name);
                    textDate4.setText(monitoring.getDate() + " " + monitoring.getHour());
                    textRoom4.setText("Sala: " + monitoring.getRoom());
                } else if (i == 4) {
                    mensage5.setVisible(true);
                    textDiscipline5.setText(monitoring.getDiscipline());
                    textNameAbrev5.setText(resultado);
                    textName5.setText(name);
                    textDate5.setText(monitoring.getDate() + " " + monitoring.getHour());
                    textRoom5.setText("Sala: " + monitoring.getRoom());
                } else {
                }
            }
        }
    }

    public String getCount() {
        String countP = scheduleS.getCount(Integer.parseInt(app.getUser()[0]));

        return countP;
    }

    @FXML
    private void click1() throws IOException {
        createSchedule(0);
    }

    @FXML
    private void click2() throws IOException {
        createSchedule(1);
    }

    @FXML
    private void click3() throws IOException {
        createSchedule(2);
    }

    @FXML
    private void click4() throws IOException {
        createSchedule(3);
    }

    @FXML
    private void click5() throws IOException {
        createSchedule(4);
    }

    public void createSchedule(int index) throws IOException {
        Schedule_delete scheduleD = new Schedule_delete();
        scheduleD.delete(scheduleList.get(index).getIdSchedule());
        alert.showAlert("Agendado", "Mentoria cancelada com sucesso", "Sucess");
        if (Integer.parseInt(app.getUser()[0]) == monitoringList.get(index).getUser()) {
            scheduleD.deleteAll(scheduleList.get(index).getIdSchedule());
            new Time_delete(monitoringList.get(index).getMonitoring());
        } else {
            new Time_update(monitoringList.get(index).getMonitoring(), monitoringList.get(index).getQuantity() + 1);
        }
        app.changeScreen("schedule");

    }

}
