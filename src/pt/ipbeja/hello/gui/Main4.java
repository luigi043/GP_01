package pt.ipbeja.hello.gui;
/**
 * @author Luiz Fehlberg
 * @version 8/03/23
 */
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main4 extends Application {

    private Button button1;
    private Button button2;

    private int counter1 = 0;
    private int counter2 = 0;
    private Label label2;
    private Label label1;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        ButtonHandler handler =  new ButtonHandler();

        this.button1 = new Button("Button 1");
        this.button1.setOnAction(handler);
        this.label1 = new Label("0");

        this.button2 = new Button("Button 2");
        this.button2.setOnAction(handler);
        this.label2 = new Label("0");

        HBox top = new HBox(10, this.button1, this.label1);
        HBox bot = new HBox(10, this.button2, this.label2);

        VBox box = new VBox(10, top, bot);

        Scene scene = new Scene(box);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    class ButtonHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {

            Button clicked = (Button) event.getSource();

            if (clicked == button1) {
                //int value = Integer.parseInt(label1.getText());
                //label1.setText(value + "");
                counter1++;
                label1.setText( String.valueOf(counter1));
            }
            else {
                //int value = Integer.parseInt(label1.getText());
                label2.setText( String.valueOf(++counter2));
            }
    }   }

}
