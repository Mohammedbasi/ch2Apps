package lecture9;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {

    private ListView<String> listViewSource, listViewDest;
    private TextField textFieldName;
    private CheckBox checkBoxAll;
    private RadioButton radioGold, radioCyan, radioGrey;
    private Button add, update, copy, delete, clear;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        String names[] = {"Ahmad", "Tamer", "mohammed", "ali"};
        listViewSource = new ListView<>(FXCollections.observableArrayList(names));
        listViewSource.getSelectionModel().selectedItemProperty()
                .addListener(e
                        -> textFieldName.setText(listViewSource.getSelectionModel().getSelectedItem())
                );
        listViewSource.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        listViewSource.setPrefSize(128, 200);

        listViewDest = new ListView<>();
        listViewDest.setPrefSize(128, 200);

        HBox hb1 = new HBox(10, listViewSource, listViewDest);
        hb1.setAlignment(Pos.CENTER);

        textFieldName = new TextField();

        checkBoxAll = new CheckBox("Select All");

        radioGold = new RadioButton("Gold");
        radioGrey = new RadioButton("Grey");
        radioCyan = new RadioButton("Cyan");
        HBox hb2 = new HBox(radioGold, radioGrey, radioCyan);
        hb2.setSpacing(10);
        hb2.setAlignment(Pos.CENTER);
        ToggleGroup myToggleGroup = new ToggleGroup();
        radioGold.setToggleGroup(myToggleGroup);
        radioGrey.setToggleGroup(myToggleGroup);
        radioCyan.setToggleGroup(myToggleGroup);

        add = new Button("Add");
        update = new Button("Update");
        copy = new Button("Copy");
        delete = new Button("Delete");
        clear = new Button("Clear");

        HBox hb3 = new HBox(add, update, copy, delete, clear);
        hb3.setSpacing(10);
        hb3.setAlignment(Pos.CENTER);

        VBox vb1 = new VBox(hb1, textFieldName, checkBoxAll, hb2, hb3);
        vb1.setPadding(new Insets(20));
        vb1.setSpacing(20);
        vb1.setAlignment(Pos.CENTER);

        FlowPane flowPane = new FlowPane(vb1);
        flowPane.setAlignment(Pos.CENTER);

        radioGold.setOnAction(event
                -> {
            flowPane.setStyle("-fx-background-color:gold");
        });

        radioGrey.setOnAction(event
                -> {
            flowPane.setStyle("-fx-background-color:grey");
        });

        radioCyan.setOnAction(event
                -> {
            flowPane.setStyle("-fx-background-color:cyan");
        });

        add.setOnAction(event
                -> {
            if (!textFieldName.getText().equals("")) {
                listViewSource.getItems().add(textFieldName.getText());
                textFieldName.setText("");
            }
        });

        update.setOnAction(event
                -> {
            if (!textFieldName.getText().equals("")) {
                int index = listViewSource.getSelectionModel().getSelectedIndex();
                listViewSource.getItems().set(index, textFieldName.getText());
                textFieldName.setText("");
            }

        });

        copy.setOnAction(event -> {
            if (listViewSource.getItems() != null) {
                listViewDest.getItems().addAll(listViewSource.getSelectionModel().getSelectedItems());
            }

        });

        delete.setOnAction(event -> {
            if (listViewSource.getItems() != null) {
                listViewSource.getItems().removeAll(listViewSource.getSelectionModel().getSelectedItems());
            }
        });

        clear.setOnAction(event -> {
            listViewSource.getItems().removeAll(listViewSource.getItems());
            listViewDest.getItems().removeAll(listViewDest.getItems());
            textFieldName.setText("");
        });

        checkBoxAll.setOnAction(event
                -> {
            if (checkBoxAll.isSelected()) {
                listViewSource.getSelectionModel().selectAll();
            } else {
                listViewSource.getSelectionModel().clearSelection();
            }

        });
        Scene scene = new Scene(flowPane, 500, 500);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}
