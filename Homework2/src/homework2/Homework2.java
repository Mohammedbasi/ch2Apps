package homework2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Homework2 extends Application {

    FontWeight fw = FontWeight.NORMAL;
    FontPosture fp = FontPosture.REGULAR;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        // the bottom controll 
        TextArea area = new TextArea("JavaFx - Lab");
        
        // text align label 
        Label textAlign = new Label("Text Align");
        textAlign.setFont(Font.font("Arial", FontWeight.MEDIUM, FontPosture.REGULAR, 18));

        // left and right button align 
        ToggleButton left = new ToggleButton();
        left.setPadding(new Insets(5));
        left.setSelected(true);

        ToggleButton right = new ToggleButton();
        right.setPadding(new Insets(5));
        // image for left align 
        Image leftIcon = new Image("images/align-left.png");
        ImageView leftIconView = new ImageView(leftIcon);
        leftIconView.setFitWidth(20);
        leftIconView.setFitHeight(17);

        // image for right align
        Image rightIcon = new Image("images/align-right.png");
        ImageView rightIconView = new ImageView(rightIcon);
        rightIconView.setFitWidth(20);
        rightIconView.setFitHeight(17);

        left.setGraphic(leftIconView);
        right.setGraphic(rightIconView);

        ToggleGroup group = new ToggleGroup();
        left.setToggleGroup(group);
        right.setToggleGroup(group);

        // comboBox fonts 
        ComboBox fonts = new ComboBox();
        fonts.getItems().addAll("Arial", "Times New Roman", "Freestyle Script", new Separator(),
                "Andalus", "KufiLTRegular");
        fonts.getSelectionModel().selectFirst();

        // the top (dir) of the page
        HBox top = new HBox(20, textAlign, left, right, fonts);
        
        //*****************************The end ot the top ****************************************

        // the center (dir) of the page 
        // the type of the font buttons
        RadioButton plain = new RadioButton("Plain");
        plain.setSelected(true);
        RadioButton bold = new RadioButton("Bold");
        RadioButton italic = new RadioButton("Italic");
        RadioButton italicBold = new RadioButton("Bold/Italic");

        // button toggle 
        ToggleGroup fontTypeGroup = new ToggleGroup();
        plain.setToggleGroup(fontTypeGroup);
        bold.setToggleGroup(fontTypeGroup);
        italic.setToggleGroup(fontTypeGroup);
        italicBold.setToggleGroup(fontTypeGroup);

        // the size text field
        TextField sizeTextField = new TextField("18");
        sizeTextField.setPrefColumnCount(4);
        area.setFont(Font.font((String)fonts.getValue(), fw, fp, Integer.parseInt(sizeTextField.getText())));
        // The center HBox

        HBox center = new HBox(18.5, plain, bold, italic, italicBold, sizeTextField);
        

        // VBbox Root
        VBox vbRoot = new VBox(20, top, center, area);
        vbRoot.setPadding(new Insets(10));
        vbRoot.setAlignment(Pos.CENTER);
        Image back = new Image("images/background.png");
        BackgroundImage background = new BackgroundImage(back, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        vbRoot.setBackground(new Background(background));

        // The App Actions
        // 1 - text align left
        left.setOnAction(e -> {
            area.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        });

        // 2 - text align right
        right.setOnAction(e -> {
            area.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        });

        // 3 - Font Actoins
        fonts.setOnAction(e -> {
            if (fonts.getValue() == "Arial") {
                area.setFont(Font.font("Arial", fw,
                        fp, Integer.parseInt(sizeTextField.getText())));

            } else if (fonts.getValue() == "Times New Roman") {
                area.setFont(Font.font("Times New Roman", fw,
                        fp, Integer.parseInt(sizeTextField.getText())));

            } else if (fonts.getValue() == "Freestyle Script") {
                area.setFont(Font.font("Freestyle Script", fw,
                        fp, Integer.parseInt(sizeTextField.getText())));

            } else if (fonts.getValue() == "Andalus") {
                area.setFont(Font.font("Andalus", fw,
                        fp, Integer.parseInt(sizeTextField.getText())));

            } else if (fonts.getValue() == "KufiLTRegular") {
                area.setFont(Font.font("KufiLTRegular", fw,
                        fp, Integer.parseInt(sizeTextField.getText())));

            } else {
                System.out.println("There is no font in the box");
            }
        });
        // 4 - Font weight
        fontTypeGroup.selectedToggleProperty().addListener(e -> {
            if (fontTypeGroup.getSelectedToggle() == plain) {
                fw = FontWeight.NORMAL;
                fp = FontPosture.REGULAR;
                area.setFont(Font.font((String) fonts.getValue(),
                        fw, fp, Integer.parseInt(sizeTextField.getText())));

            } else if (fontTypeGroup.getSelectedToggle() == bold) {
                fw = FontWeight.BOLD;
                fp = FontPosture.REGULAR;
                area.setFont(Font.font((String) fonts.getValue(),
                        fw, fp, Integer.parseInt(sizeTextField.getText())));

            } else if (fontTypeGroup.getSelectedToggle() == italic) {
                fw = FontWeight.NORMAL;
                fp = FontPosture.ITALIC;
                area.setFont(Font.font((String) fonts.getValue(), fw,
                        fp, Integer.parseInt(sizeTextField.getText())));

            } else if (fontTypeGroup.getSelectedToggle() == italicBold) {
                fw = FontWeight.BOLD;
                fp = FontPosture.ITALIC;
                area.setFont(Font.font((String) fonts.getValue(), fw,
                        fp, Integer.parseInt(sizeTextField.getText())));
            }
        });

        sizeTextField.setOnAction(e -> {
            area.setFont(Font.font((String) fonts.getValue(), fw, fp, Integer.parseInt(sizeTextField.getText())));
        });
        // Stage and Scene
        Scene scene = new Scene(vbRoot, 400, 250);
        stage.setScene(scene);
        stage.setTitle("Assigment 2");
        stage.setResizable(false);
        stage.getIcons().add(new Image("images/icon.png"));
        stage.show();
    }

}
