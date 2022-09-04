/*
 * Copyright 2022 Chris Bakker.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package application.viewport;

import java.util.HashMap;
import java.util.Map;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

/**
 *
 * @author Chris Bakker
 */
public class SavingsLinechart {
    private LineChart<Number, Number> lineChart;
    private NumberAxis xAxis;
    private NumberAxis yAxis;
    
    public SavingsLinechart() {
        xAxis = new NumberAxis(0, 30, 1);
        yAxis = new NumberAxis();
        xAxis.setAutoRanging(false);
        
        lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Savings calculator");
    }
    
    public LineChart getLineChart() {
        return this.lineChart;
    }
    
    public void updateLineChart(int savings, double rate) {
        XYChart.Series monthlySavingData = new XYChart.Series();
        
        
    }
    
    private Map<Integer, Integer> getMonthlySavingsAsMap(int monthlySavings) {
        HashMap<Integer, Integer> monthlySavingsMap = new HashMap();
        
        for (int i = 0; i < 30; i++) {
            monthlySavingsMap.put(i, i*(monthlySavings*12));
        }
        
        return monthlySavingsMap;
    }
    
    private Map<Integer, Double> getMonthlySavingsWithInterestAsMap(int monthlySavings, double interestRate) {
        HashMap<Integer, Double> monthlySavingsMap = new HashMap();
        
        double savings = 0;
        for (int i = 0; i < 30; i++) {
            monthlySavingsMap.put(i, savings);
            savings += monthlySavings*12;
            savings = savings + (savings*interestRate);
        }
        
        return monthlySavingsMap;
    }
}
