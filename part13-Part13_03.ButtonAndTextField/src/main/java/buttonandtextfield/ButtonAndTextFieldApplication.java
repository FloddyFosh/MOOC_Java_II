package buttonandtextfield;

import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class ButtonAndTextFieldApplication extends Application {


    public static void main(String[] args) {
        launch(ButtonAndTextFieldApplication.class);
    }

    @Override
    public void start(Stage window){
        window.setTitle("Button and TextField");
        
        Button button = new Button("Button");
        TextField textfield = new TextField();
        
        VBox vbox = new VBox();
        vbox.getChildren().add(button);
        vbox.getChildren().add(textfield);
        
        Scene scene = new Scene(vbox);
        
        window.setScene(scene);
        window.show();
    }

}
