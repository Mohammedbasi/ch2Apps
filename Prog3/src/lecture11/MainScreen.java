package lecture11;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MainScreen extends Stage {

    private MenuBar menuBar;
    private Menu menuFile, menuColor, menuAbout;
    private MenuItem menuItemOpen, menuItemClear, menuItemSave, menuItemExit,
            menuItemGold, menuItemCyan, menuItemGrey, menuItemAbout;
    private TextArea textArea;
    private Slider sliderFontSize;
    Stage stage;
    String path = null;

    public MainScreen() {
        stage = this;
        menuBar = new MenuBar();

        menuFile = new Menu("File");
        menuColor = new Menu("Color");
        menuAbout = new Menu("About");

        menuItemOpen = new MenuItem("Open");
        menuItemClear = new MenuItem("Clear");
        menuItemSave = new MenuItem("Save");
        menuItemExit = new MenuItem("Exit");

        menuItemGold = new MenuItem("Gold");
        menuItemCyan = new MenuItem("Cyan");
        menuItemGrey = new MenuItem("Grey");

        menuItemAbout = new MenuItem("About");

        menuFile.getItems().addAll(menuItemOpen, menuItemSave, menuItemClear, menuItemExit);
        menuColor.getItems().addAll(menuItemGold, menuItemCyan, menuItemGrey);
        menuAbout.getItems().addAll(menuItemAbout);

        menuBar.getMenus().addAll(menuFile, menuColor, menuAbout);

        textArea = new TextArea("Playing with JavaFX Advanced Controls");
        textArea.setMaxHeight(300);
        textArea.setMaxWidth(500);
        textArea.appendText("\n");

        sliderFontSize = new Slider(5, 35, 12);
        sliderFontSize.setMajorTickUnit(5);
        sliderFontSize.setMinorTickCount(4);
        sliderFontSize.setShowTickLabels(true);
        sliderFontSize.setShowTickMarks(true);
        sliderFontSize.setSnapToTicks(true);

        ComboBox<String> comboBoxLinks = new ComboBox<>();
        comboBoxLinks.getItems().addAll("Instructor GitHub", "JavaFX Guide", "My GitHub");
        comboBoxLinks.getSelectionModel().select(2);

        WebView webView = new WebView();
        webView.getEngine().load("https://github.com/Mohammedbasi");

        HBox hBox1 = new HBox(15, comboBoxLinks, webView);
        hBox1.setAlignment(Pos.CENTER);
        VBox vBox1 = new VBox(15, textArea, sliderFontSize, hBox1);
        vBox1.setAlignment(Pos.CENTER);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(menuBar);
        borderPane.setCenter(vBox1);

        Scene scene = new Scene(borderPane, 1000, 700);
        this.setScene(scene);
        this.setTitle("Advanced JavaFX Screen");

        sliderFontSize.valueProperty().addListener(e -> {
            textArea.setStyle("-fx-font-size: "
                    + sliderFontSize.getValue() + "pt");
        });

        comboBoxLinks.setOnAction(e -> {
            if (comboBoxLinks.getSelectionModel()
                    .getSelectedIndex() == 0) {
                webView.getEngine()
                        .load("https://github.com/aashgar");
            } else if (comboBoxLinks.getSelectionModel()
                    .getSelectedIndex() == 1) {
                webView.getEngine().load("https://openjfx.io/openjfx-docs/");
            } else {
                webView.getEngine().load("https://github.com/Mohammedbasi");
            }

        });

        menuItemOpen.setOnAction(new MyEventHandler());
        menuItemSave.setOnAction(new MyEventHandler());
        menuItemClear.setOnAction(new MyEventHandler());
        menuItemExit.setOnAction(new MyEventHandler());
        menuItemAbout.setOnAction(e
                -> {
            new About();
        });
        // menu color handle
        menuItemGold.setOnAction(e
                -> {
            textArea.setStyle("-fx-text-fill:gold;-fx-font-size: "
                    + sliderFontSize.getValue() + "pt");
        });
        menuItemCyan.setOnAction(e
                -> {
            textArea.setStyle("-fx-text-fill:cyan;-fx-font-size: "
                    + sliderFontSize.getValue() + "pt");
        });
        menuItemGrey.setOnAction(e
                -> {
            textArea.setStyle("-fx-text-fill:grey;-fx-font-size: "
                    + sliderFontSize.getValue() + "pt");
        });

    }

    private class MyEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setInitialDirectory(new File("src/lecture11"));
            File fileSelected = null;

            if (event.getSource() == menuItemOpen) {
                fileSelected = fileChooser.showOpenDialog(stage);
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
            } else if (event.getSource() == menuItemSave) {
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
                        fileSelected = fileChooser.showSaveDialog(stage);
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
            } else if (event.getSource() == menuItemClear) {
                textArea.setText("");
            } else if (event.getSource() == menuItemExit) {
                stage.close();
            }
        }

    }
}
