package pablo.ui.gui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import pablo.Pablo;
import pablo.messages.MessageFormatter;

/**
 * A GUI for Pablo using FXML.
 */
public class MainGui extends Application {

    private Pablo pablo = new Pablo("./data/pablo.txt");

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainGui.class.getResource("/view/MainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);
            MainWindow controller = fxmlLoader.getController();
            controller.setPablo(pablo);
            controller.showStartupMessage(MessageFormatter.WELCOME_MESSAGE);
            stage.setScene(scene);
            fxmlLoader.<MainWindow>getController().setPablo(pablo);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
