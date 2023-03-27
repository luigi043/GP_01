package pt.ipbeja.hello.gui;
/**
 * @author Luiz Fehlberg
 * @version 3/03/23
 */

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Main1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Label label = new Label("Hello World!");
        label.setAlignment(Pos.CENTER);
        Scene scene = new Scene(label, 200, 100);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
