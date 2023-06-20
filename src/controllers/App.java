package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.User;

public class App extends Application {
    User user = new User();
    ArrayList<String> userArrayList = new ArrayList<String>();
    String nome = "";

    private static Stage stage;
    private static Scene home;
    private static Scene login;
    private static Scene register;
    private static Scene timeM;
    private static Scene timeA;
    private static Scene schedule;


    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;

        Parent fxmlLogin = FXMLLoader.load(getClass().getResource("/screens/login_screen.fxml"));
        login = new Scene(fxmlLogin);

        Parent fxmlRegister = FXMLLoader.load(getClass().getResource("/screens/create_screen.fxml"));
        register = new Scene(fxmlRegister);

        primaryStage.setTitle("Planning Now");
        primaryStage.setScene(login);
        primaryStage.show();

    }

    public void changeScreen(String option) throws IOException {
        switch (option) {
            case "register":
                stage.setScene(register);
                break;
            case "feed":
                Parent fxmlHome = FXMLLoader.load(getClass().getResource("/screens/feed_screen.fxml"));
                home = new Scene(fxmlHome);
                stage.setScene(home);
                break;
            case "login":
                stage.setScene(login);
                break;
            case "schedule":
                Parent fxmlSchedule = FXMLLoader.load(getClass().getResource("/screens/schedule_screen.fxml"));
                schedule = new Scene(fxmlSchedule);
                stage.setScene(schedule);
                break;
            case "time":
                String type = System.getProperty("type");
                if (type.equals("0")) {
                    Parent fxmlTimeA = FXMLLoader.load(getClass().getResource("/screens/timeA_screen.fxml"));
                    timeA = new Scene(fxmlTimeA);
                    stage.setScene(timeA);
                } else {
                    Parent fxmlTimeM = FXMLLoader.load(getClass().getResource("/screens/timeM_screen.fxml"));
                    timeM = new Scene(fxmlTimeM);
                    stage.setScene(timeM);
                }
        }
    }
    public void addUser(String ra, String name, int type) {
        System.setProperty("ra", ra);
        System.setProperty("name", name);
        System.setProperty("type", Integer.toString(type));
        System.out.println(System.getProperty("ra"));
    }

    public String[] getUser() {
        String[] user = { System.getProperty("ra"), System.getProperty("name"), System.getProperty("type") };

        return user;
    }

    public void removeUser() {
        System.clearProperty("ra");
        System.clearProperty("name");
        System.clearProperty("type");
    }

}
