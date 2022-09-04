package application;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class GreeterApplication extends Application {

    @Override
    public void start(Stage window) throws Exception {

        // 1. Creating the view for asking a username

        // 1.1 Creating components to be used
        Label instructionText = new Label("Enter your name and start.");
        TextField usernameField = new TextField();
        Button startButton = new Button("Start");

        // 1.2 creating layout and adding components to it
        GridPane layout = new GridPane();

        layout.add(instructionText, 0, 0);
        layout.add(usernameField, 0, 1);
        layout.add(startButton, 0, 2);

        // 1.3 styling the layout
        layout.setPrefSize(300, 180);
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(20, 20, 20, 20));

        // 1.4 creating the view itself and setting it to use the layout
        Scene userNameView = new Scene(layout);

        // 2. Creating a view for showing the welcome message
        Label welcomeText = new Label("Welcome");

        StackPane welcomeLayout = new StackPane();
        welcomeLayout.setPrefSize(300, 180);
        welcomeLayout.getChildren().add(welcomeText);
        welcomeLayout.setAlignment(Pos.CENTER);

        Scene welcomeView = new Scene(welcomeLayout);

        // 3. Adding an event handler to the Start button.
        startButton.setOnAction((event) -> {
            welcomeText.setText("Welcome " + usernameField.getText() + "!");

            window.setScene(welcomeView);
        });

        window.setScene(userNameView);
        window.show();
    }

    public static void main(String[] args) {
        launch(GreeterApplication.class);
    }
}
