package lecture12;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author rant
 */
public class LoginScreenController implements Initializable {

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Label labelError;
    @FXML
    private Button buttonSubmit;
    @FXML
    private Button buttonClear;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleButtonSubmit(ActionEvent event) throws IOException {
        FConnection fConnection = FConnection.getFConnection();
        if (fConnection.verifyUser(username.getText(), password.getText())) {
            labelError.setText("Valid User");
            new MainScreen().show();
        } else {
            labelError.setText("InValid User");
        }
    }

    @FXML
    private void handleButtonClear(ActionEvent event) {
        username.setText("");
        password.setText("");
    }

}
