package textstatistics;

import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class TextStatisticsApplication extends Application {


    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }

    @Override
    public void start(Stage window) {
        window.setTitle("Text Statistics");
        
        BorderPane bpane = new BorderPane();
        bpane.setCenter(new TextArea());
        
        HBox hbox = new HBox();
        hbox.getChildren().add(new Label("Letters: 0"));
        hbox.getChildren().add(new Label("Words: 0"));
        hbox.getChildren().add(new Label("The longest word is:"));
        hbox.setSpacing(10);
        
        bpane.setBottom(hbox);
        
        Scene scene = new Scene(bpane);
        
        window.setScene(scene);
        window.show();
    }

}
