package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class ShanghaiApplication extends Application {

    public static void main(String[] args) {
        launch(ShanghaiApplication.class);
    }

    @Override
    public void start(Stage stage) {
        // create the x and y axes that the chart is going to use
        NumberAxis xAxis = new NumberAxis(2006, 2018, 1);
        NumberAxis yAxis = new NumberAxis(40, 80, 4);
        xAxis.setAutoRanging(false);
        yAxis.setAutoRanging(false);

        // set the titles for the axes
        xAxis.setLabel("Year");
        yAxis.setLabel("Ranking");


        // create the line chart. The values of the chart are given as numbers
        // and it uses the axes we created earlier
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("University of Helsinki, Shanghai ranking");

        // create the data set that is going to be added to the line chart
        XYChart.Series uohData = new XYChart.Series();
        uohData.setName("University of Helsinki");
        
        // and single points into the data set
        uohData.getData().add(new XYChart.Data(2007, 73));
        uohData.getData().add(new XYChart.Data(2008, 68));
        uohData.getData().add(new XYChart.Data(2009, 72));
        uohData.getData().add(new XYChart.Data(2010, 72));
        uohData.getData().add(new XYChart.Data(2011, 74));
        uohData.getData().add(new XYChart.Data(2012, 73));
        uohData.getData().add(new XYChart.Data(2013, 76));
        uohData.getData().add(new XYChart.Data(2014, 73));
        uohData.getData().add(new XYChart.Data(2015, 67));
        uohData.getData().add(new XYChart.Data(2016, 56));
        uohData.getData().add(new XYChart.Data(2017, 56));

        // add the data set to the line chart
        lineChart.getData().add(uohData);

        // display the line chart
        Scene view = new Scene(lineChart, 640, 480);
        stage.setScene(view);
        stage.show();
    }
    
    

}
