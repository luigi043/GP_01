package pt.ipbeja.hello.gui;
/**
 * @author Luiz Fehlberg
 * @version 3/03/23
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Main2 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Button button = new Button("Click me");

        ButtonHandler handler = new ButtonHandler();
        button.setOnAction(handler);


        Scene scene = new Scene(button);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    class ButtonHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Hello World");
            alert.showAndWait();
        }
    }
}
