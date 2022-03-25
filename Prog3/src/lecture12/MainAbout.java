package lecture12;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class MainAbout extends Stage {

    MainAbout() throws IOException {
        FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("About.fxml"));
        FlowPane flowPane = fXMLLoader.load();
        Scene scene = new Scene(flowPane);
        this.setScene(scene);
        this.setTitle("About");
    }
}
