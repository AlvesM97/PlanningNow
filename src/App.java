import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        String path = "screens/home_screen.fxml";
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Scene tela = new Scene(root);

        primaryStage.setTitle("5Style");
        primaryStage.setScene(tela);
        primaryStage.show();

    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }

}