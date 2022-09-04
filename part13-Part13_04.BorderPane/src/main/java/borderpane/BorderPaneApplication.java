package borderpane;

import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class BorderPaneApplication extends Application {


    public static void main(String[] args) {
        launch(BorderPaneApplication.class);
    }

    @Override
    public void start(Stage window) {
        window.setTitle("BorderPane");
        
        Label nlabel = new Label("NORTH");
        Label elabel = new Label("EAST");
        Label slabel = new Label("SOUTH");
        
        BorderPane bpane = new BorderPane();
        bpane.setTop(nlabel);
        bpane.setRight(elabel);
        bpane.setBottom(slabel);
        
        Scene view = new Scene(bpane);
        
        window.setScene(view);
        window.show();
    }

}
