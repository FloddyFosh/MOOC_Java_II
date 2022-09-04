package notifier;

import javafx.application.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class NotifierApplication extends Application {

    public static void main(String[] args) {
        launch(NotifierApplication.class);
    }

    @Override
    public void start(Stage window) {
        window.setTitle("Notifier Application");
        
        VBox vbox = new VBox();
        TextField txtfield = new TextField();
        Label blabel = new Label();
        Button updateButton = new Button("Update");
        
        updateButton.setOnAction((event) -> {
            blabel.setText(txtfield.getText());
        });
        
        vbox.getChildren().addAll(txtfield, updateButton, blabel);
        
        Scene scene = new Scene(vbox);
        
        window.setScene(scene);
        window.show();
    }

}
