package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class PartiesApplication extends Application {

    public static void main(String[] args) {
        launch(PartiesApplication.class);
    }

    @Override
    public void start(Stage stage) {
        // create the x and y axes that the chart is going to use
        NumberAxis xAxis = new NumberAxis(1968, 2008, 1);
        NumberAxis yAxis = new NumberAxis(0, 30, 1);
        xAxis.setAutoRanging(false);
        yAxis.setAutoRanging(false);

        // set the titles for the axes
        //xAxis.setLabel("Year");
        //yAxis.setLabel("Ranking");


        // create the line chart. The values of the chart are given as numbers
        // and it uses the axes we created earlier
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Relative support of the parties");

        //Read the data from a file
        HashMap<String, ArrayList<Double>> data = new HashMap();
        File file = new File("partiesdata.tsv");
        
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                ArrayList<String> pieces = new ArrayList(Arrays.asList(line.split("\t")));
                if (pieces.get(0).equals("Party")) {
                    continue;
                }
                String party = pieces.remove(0);
                data.put(party, pieces.stream().map(d -> (d.equals("-") ? 0.0 : Double.valueOf(d))).collect(Collectors.toCollection(ArrayList::new)));
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PartiesApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // create the data set that is going to be added to the line chart
        data.entrySet().stream().forEach(e -> {
            XYChart.Series pdata = new XYChart.Series();
            pdata.setName(e.getKey());
            
            int year = 1968;
            for (Double d : e.getValue()) {
                pdata.getData().add(new XYChart.Data(year, d));
                year += 4;
            }
            
            lineChart.getData().add(pdata);
        });
        

        // display the line chart
        Scene view = new Scene(lineChart, 640, 480);
        stage.setScene(view);
        stage.show();
    }
    
    

}
