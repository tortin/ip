package pablo.ui.gui;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import pablo.Pablo;
import pablo.command.CommandResult;

/**
 * Controller for the main GUI.
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private Pablo pablo;

    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/pablo_user.jpg"));
    private Image pabloImage = new Image(this.getClass().getResourceAsStream("/images/pablo.jpg"));

    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
    }

    /** Injects the Pablo instance */
    public void setPablo(Pablo p) {
        pablo = p;
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing Pablo's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        CommandResult result = pablo.parseAndExecute(input);
        boolean isExit = result.getIsExit();
        String response = result.getResponse();
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage),
                DialogBox.getPabloDialog(response, pabloImage)
        );
        userInput.clear();
        if (isExit) {
            Platform.exit(); // clean JavaFX shutdown
        }
    }

    /**
     * Shows a message on startup, instead of waiting for the first user prompt.
     * @param message The message to show.
     */
    public void showStartupMessage(String message) {
        dialogContainer.getChildren().add(
                DialogBox.getPabloDialog(message, pabloImage)
        );
    }
}
