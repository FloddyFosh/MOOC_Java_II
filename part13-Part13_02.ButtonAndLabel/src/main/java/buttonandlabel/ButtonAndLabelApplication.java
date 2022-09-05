package buttonandlabel;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class ButtonAndLabelApplication extends Application {

    public static void main(String[] args) {
        launch(ButtonAndLabelApplication.class);
    }

    @Override
    public void start(Stage window){
       window.setTitle("Button and Label Application");
       
       Button button = new Button("Button");
       Label label = new Label("Label");
       
       FlowPane componentGroup = new FlowPane();
       componentGroup.getChildren().add(button);
       componentGroup.getChildren().add(label);
       
       Scene scene = new Scene(componentGroup);
       
       window.setScene(scene);
       window.show();
    }

}
