package lecture12;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginScreen.fxml"));
        FlowPane flowPane = loader.load();
        Scene scene = new Scene(flowPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFx");
        primaryStage.show();
    }

}
