package controllers;

import api.insert.user_insert;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application {
    
    private static Stage stage;
    
    private static Scene registration;
    private static Scene home;

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        
        Parent fxmlRegistration = FXMLLoader.load(getClass().getResource("/screens/registration_screen.fxml"));
        registration = new Scene(fxmlRegistration);
        
        Parent fxmlHome = FXMLLoader.load(getClass().getResource("/screens/home_screen.fxml"));
        home = new Scene(fxmlHome);

        primaryStage.setTitle("First Screen");
        primaryStage.setScene(registration);
        primaryStage.show();
    }

    public void changeScreen(String option) {
        switch(option) {
            case "registration":
            stage.setScene(registration);
            break;
            case "home":
            stage.setScene(home);
            break;
        }
    }

}
