package lecture11;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {

    private Label labelTitle, labelError;
    private TextField textFieldLoginName;
    private PasswordField passwordField;
    private Button buttonSubmit, buttonCancel;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        labelTitle = new Label("Login Information");
        textFieldLoginName = new TextField();
        textFieldLoginName.setPromptText("Login Name");
        passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        labelError = new Label("Initial text");
        labelError.setId("label-error");

        VBox vBox1 = new VBox(10, labelTitle, textFieldLoginName, passwordField, labelError);
        vBox1.setAlignment(Pos.CENTER);

        buttonSubmit = new Button("Submit");
        buttonCancel = new Button("Cancel");
        buttonSubmit.setOnAction(new MyEventHandler());
        buttonCancel.setOnAction(new MyEventHandler());
        HBox hBox1 = new HBox();
        hBox1.getChildren().addAll(buttonSubmit, buttonCancel);
        hBox1.setSpacing(20);
        hBox1.setAlignment(Pos.CENTER);

        VBox vBox2 = new VBox(10, vBox1, hBox1);
        vBox2.setAlignment(Pos.CENTER);
        vBox2.setPadding(new Insets(10, 20, 10, 20));
        vBox2.getStyleClass().add("vbox");

        FlowPane flowPane = new FlowPane(vBox2);
        flowPane.setAlignment(Pos.CENTER);

        Scene scene = new Scene(flowPane, 500, 500);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.setTitle("Login Screen");
        primaryStage.show();

    }

    private class MyEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            FConnection fConnection = FConnection.getFConnection();
            if (event.getSource() == buttonSubmit) {
                if (fConnection.verifyUser(textFieldLoginName.getText(),
                        passwordField.getText())) {
                    labelError.setText("Valid User");
                    new MainScreen().show();

                } else {
                    labelError.setText("Invalid Data");
                }
            } else if (event.getSource() == buttonCancel) {
                textFieldLoginName.setText("");
                passwordField.setText("");
            }
        }
    }

}
