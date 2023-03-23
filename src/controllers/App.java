package controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    
    private static Stage stage;

    private static Scene home;
    private static Scene login;
    private static Scene register;

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;

        Parent fxmlLogin = FXMLLoader.load(getClass().getResource("/screens/login_screen.fxml"));
        login = new Scene(fxmlLogin);
        
        Parent fxmlRegister = FXMLLoader.load(getClass().getResource("/screens/register_screen.fxml"));
        register = new Scene(fxmlRegister);
        
        Parent fxmlHome = FXMLLoader.load(getClass().getResource("/screens/home_screen.fxml"));
        home = new Scene(fxmlHome);

        primaryStage.setTitle("5Style");
        primaryStage.setScene(home);
        primaryStage.show();
    }

    public void changeScreen(String option) {
        switch(option) {
            case "register":
            stage.setScene(register);
            break;
            case "home":
            stage.setScene(home);
            break;
            case "login":
            stage.setScene(login);
        }
    }

}
