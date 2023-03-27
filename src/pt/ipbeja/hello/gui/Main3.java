package pt.ipbeja.hello.gui;
/**
 * @author Luiz Fehlberg
 * @version 8/03/23
 */
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main3 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Button button1 = new Button("Button 1");
        Button button2 = new Button("Button 2");

        ButtonHandler handler =  new ButtonHandler();
        button1.setOnAction(handler);
        button2.setOnAction(handler);

        VBox vBox = new VBox(button1, button2);

        Scene scene = new Scene(vBox);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    class ButtonHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {

            Button buttonClicked = (Button) (event.getSource());
            Alert alert = new Alert(Alert.AlertType.INFORMATION, buttonClicked.getText());
            alert.showAndWait();
        }
    }

}
