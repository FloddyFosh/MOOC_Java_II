package smiley;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.image.PixelWriter;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class SmileyApplication extends Application {

    public static void main(String[] args) {
        launch(SmileyApplication.class);
    }

    @Override
    public void start(Stage window) {
        window.setTitle("Smiley Application");
        
        BorderPane layout = new BorderPane();
        
        Canvas paintingCanvas = new Canvas(400, 400);
        GraphicsContext gc = paintingCanvas.getGraphicsContext2D();
        
        layout.setCenter(paintingCanvas);
        
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, 400, 400);
        gc.setFill(Color.BLACK);
        gc.fillRect(100, 50, 50, 50);
        gc.fillRect(250, 50, 50, 50);
        gc.fillRect(50, 200, 50, 50);
        gc.fillRect(300, 200, 50, 50);
        gc.fillRect(100, 250, 200, 50);
        

        Scene view = new Scene(layout);

        window.setScene(view);
        window.show();
    }

}
