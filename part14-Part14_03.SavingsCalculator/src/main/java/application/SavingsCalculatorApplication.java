package application;

import application.viewport.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SavingsCalculatorApplication extends Application {

    public static void main(String[] args) {
        launch(SavingsCalculatorApplication.class);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Savings Calculator Application");
        
        SlidersView slidersview = new SlidersView();
        SavingsLinechart linechart = new SavingsLinechart();
        
        
        BorderPane layout = new BorderPane();
         
        layout.setTop(slidersview.getView());
        slidersview.getMSavingsSlider().valueProperty().addListener((obs, oldValue, newValue) -> {
            linechart.updateLineChart(newValue.intValue(), slidersview.getYIntRateSlider().getValue());
        });
        slidersview.getYIntRateSlider().valueProperty().addListener((obs, oldValue, newValue) -> {
            linechart.updateLineChart((int) slidersview.getMSavingsSlider().getValue(), newValue.doubleValue());
        });
        
        layout.setCenter(linechart.getLineChart());
        
        // Create the main view and add the high level layout
        Scene view = new Scene(layout, 400, 300);

        // Show the application
        stage.setScene(view);
        stage.show();
    }

}
