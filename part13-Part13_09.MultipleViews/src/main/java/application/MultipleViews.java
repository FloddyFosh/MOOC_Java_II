package application;

import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

public class MultipleViews extends Application {

    public static void main(String[] args) {
        launch(MultipleViews.class);
    }

    @Override
    public void start(Stage window) {
        window.setTitle("MultipleViews");
        
        BorderPane firstPane = new BorderPane();
        firstPane.setTop(new Label("First view!"));
        Button toSecondButton = new Button("To the second view!");
        firstPane.setCenter(toSecondButton);
        
        VBox secondPane = new VBox();
        Button toThirdButton = new Button("To the third view!");
        secondPane.getChildren().addAll(toThirdButton, new Label("Second view!"));
        
        
        GridPane thirdPane = new GridPane();
        thirdPane.add(new Label("Third view!"), 0, 0);
        Button toFirstButton = new Button("To the first view!");
        thirdPane.add(toFirstButton, 1, 1);
        
        Scene first = new Scene(firstPane, 400, 400);
        Scene second = new Scene(secondPane, 400, 400);
        Scene third = new Scene(thirdPane, 400, 400);
        
        toFirstButton.setOnAction((event) -> {
            window.setScene(first);
        });
        toSecondButton.setOnAction((event) -> {
            window.setScene(second);
        });
        toThirdButton.setOnAction((event) -> {
            window.setScene(third);
        });
        
        window.setScene(first);
        window.show();
    }

}
