package lecture12;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainScreen extends Stage {

    MainScreen() throws IOException {
        FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("MainScreen.fxml"));
        BorderPane borderPane = fXMLLoader.load();
        Scene scene = new Scene(borderPane, 1000, 700);
        this.setScene(scene);
        this.setTitle("Advanced JavaFX Screen");
    }
}
