package myFirstApplication;

import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class MyFirstApplication extends Application {
    

    public static void main(String[] args) {
        launch(MyFirstApplication.class);
    }

    @Override
    public void start(Stage window) {
        window.setTitle("My first application");
        
        Button button = new Button("button");
        Label label = new Label("label");
        
        FlowPane componentGroup = new FlowPane();
        componentGroup.getChildren().add(button);
        componentGroup.getChildren().add(label);
        
        Scene view = new Scene(componentGroup);
        
        window.setScene(view);
        window.show();
    }

}
