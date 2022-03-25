/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecture11;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author rant
 */
public class About extends Stage {

    private Label name, myName, id, myId, gpa, myGpa, age, myAge;
    private Button closeWindow, highlights;

    About() {
        name = new Label("Name: ");
        name.setStyle("-fx-font-weight: bold");
        myName = new Label("Mohammed basil");

        id = new Label("Id: ");
        id.setStyle("-fx-font-weight: bold");
        myId = new Label("120200694");

        gpa = new Label("Gpa: ");
        gpa.setStyle("-fx-font-weight: bold");
        myGpa = new Label("97.41");

        age = new Label("Age : ");
        age.setStyle("-fx-font-weight: bold");
        myAge = new Label("20");

        closeWindow = new Button("Close");
        highlights = new Button("Highlights");

        VBox vBox1 = new VBox(25, name, id, gpa, age, closeWindow);
        vBox1.setAlignment(Pos.CENTER);

        VBox vBox2 = new VBox(25, myName, myId, myGpa, myAge, highlights);
        vBox2.setAlignment(Pos.CENTER);

        HBox hBox1 = new HBox(30, vBox1, vBox2);
        hBox1.setAlignment(Pos.CENTER);

        VBox vBox3 = new VBox(25, hBox1);
        vBox3.setAlignment(Pos.CENTER);
        vBox3.setPadding(new Insets(10, 20, 10, 20));

        FlowPane flowPane = new FlowPane(vBox3);
        flowPane.setAlignment(Pos.CENTER);

        Scene scene = new Scene(flowPane, 500, 500);
        scene.getStylesheets().add(getClass().getResource("aboutStyle.css").toExternalForm());
        this.setTitle("About Me");
        this.setScene(scene);
        this.show();

        closeWindow.setOnAction(e
                -> {
            this.close();
        });

        highlights.setOnAction(e
                -> {
            myName.setStyle("-fx-background-color:gold;-fx-text-fill: white;-fx-padding:5;");
            myId.setStyle("-fx-background-color:gold;-fx-text-fill: white;-fx-padding:5;");
            myGpa.setStyle("-fx-background-color:gold;-fx-text-fill: white;-fx-padding:5;");
            myAge.setStyle("-fx-background-color:gold;-fx-text-fill: white;-fx-padding:5;");
        });
    }
}
