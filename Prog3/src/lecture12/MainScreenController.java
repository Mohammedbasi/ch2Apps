package lecture12;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author rant
 */
public class MainScreenController implements Initializable {

    @FXML
    private Menu file;
    @FXML
    private MenuItem menuItemOpen;
    @FXML
    private MenuItem menuItemSave;
    @FXML
    private MenuItem menuItemClear;
    @FXML
    private MenuItem menuItemExit;
    @FXML
    private Menu color;
    @FXML
    private MenuItem menuItemGold;
    @FXML
    private MenuItem menuItemGrey;
    @FXML
    private MenuItem menuItemCyan;
    @FXML
    private Menu about;
    @FXML
    private MenuItem menuItemAbout;
    @FXML
    private VBox vb1;
    @FXML
    private TextArea textArea;
    @FXML
    private Slider fontSizeSlider;
    @FXML
    private HBox hb1;
    @FXML
    private ComboBox<String> combo;
    @FXML
    private WebView webView;

    FileChooser fileChooser = new FileChooser();
    File fileSelected = null;
    String path = null;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        combo.getItems().removeAll(combo.getItems());
        combo.getItems().addAll("Instructor GitHub", "JavaFX Guide", "My GitHub");
        combo.getSelectionModel().select(2);
        webView.getEngine().load("https://github.com/Mohammedbasi");
        fontSizeSlider.valueProperty().addListener(e -> {
            textArea.setStyle("-fx-font-size: "
                    + fontSizeSlider.getValue() + "pt");
        });
    }

    @FXML
    private void handleOpen(ActionEvent event) throws IOException {
        fileChooser.setInitialDirectory(new File("src/lecture12"));
        fileSelected = fileChooser.showOpenDialog(new MainScreen());
        path = fileSelected.getAbsolutePath();
        try {
            Scanner s = new Scanner(fileSelected);
            while (s.hasNextLine()) {
                textArea.appendText(s.nextLine() + "\n");
            }
            s.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleSave(ActionEvent event) throws IOException {
        if (path != null) {
            try {
                File file = new File(path);
                FileWriter fileWriter = new FileWriter(file);
                PrintWriter printWriter = new PrintWriter(fileWriter);
                printWriter.print(textArea.getText());
                fileWriter.close();
                printWriter.close();
            } catch (IOException ex) {
                Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                fileChooser.setInitialDirectory(new File("src/lecture12"));
                fileSelected = fileChooser.showSaveDialog(new MainScreen());
                File file = new File(fileSelected.getAbsolutePath());
                file.createNewFile();
                FileWriter fileWriter = new FileWriter(file);
                PrintWriter printWriter = new PrintWriter(fileWriter);
                printWriter.print(textArea.getText());
                fileWriter.close();
                printWriter.close();
            } catch (IOException ex) {
                Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void handleClear(ActionEvent event) {
        textArea.setText("");
    }

    @FXML
    private void handleExit(ActionEvent event) {
        Window s = vb1.getScene().getWindow();
        s.hide();
    }

    @FXML
    private void handleGold(ActionEvent event) {
        textArea.setStyle("-fx-text-fill:gold;-fx-font-size: "
                + fontSizeSlider.getValue() + "pt");
    }

    @FXML
    private void handleGrey(ActionEvent event) {
        textArea.setStyle("-fx-text-fill:grey;-fx-font-size: "
                + fontSizeSlider.getValue() + "pt");
    }

    @FXML
    private void handleCyan(ActionEvent event) {
        textArea.setStyle("-fx-text-fill:cyan;-fx-font-size: "
                + fontSizeSlider.getValue() + "pt");
    }

    @FXML
    private void handleAbout(ActionEvent event) throws IOException {
        new MainAbout().show();
    }

    @FXML
    private void handleCombo(ActionEvent event) {
        if (combo.getSelectionModel()
                .getSelectedIndex() == 0) {
            webView.getEngine()
                    .load("https://github.com/aashgar");
        } else if (combo.getSelectionModel()
                .getSelectedIndex() == 1) {
            webView.getEngine().load("https://openjfx.io/openjfx-docs/");
        } else {
            webView.getEngine().load("https://github.com/Mohammedbasi");
        }
    }

}
