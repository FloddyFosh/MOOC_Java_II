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

import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Chris Bakker
 */
public class SlidersView {
    private Slider mSavingsSlider;
    private Slider yIntRateSlider;
    private Label mSavingsLabel;
    private Label yIntRateLabel;
    
    public SlidersView() {
        mSavingsSlider = new Slider(25, 250, 50);
        yIntRateSlider = new Slider(0, 10, 2);
        
        mSavingsLabel = new Label(Double.toString(mSavingsSlider.getValue()));
        yIntRateLabel = new Label(Double.toString(yIntRateSlider.getValue()));
        
        mSavingsSlider.valueProperty().addListener((obs, oldValue, newValue) -> {
            mSavingsLabel.setText(Integer.toString(newValue.intValue()));
        });
        yIntRateSlider.valueProperty().addListener((obs, oldValue, newValue) -> {
            yIntRateLabel.setText(String.format( "%.2f", newValue.doubleValue()));
        });
    }
    
    public Parent getView() {
        //Create the general layout
        VBox layout = new VBox();
        
        //Monthly Savings Slider
        BorderPane mSavingsPane = new BorderPane();
        
        mSavingsPane.setLeft(new Label("Monthly savings"));
        mSavingsPane.setCenter(mSavingsSlider);
        mSavingsPane.setRight(mSavingsLabel);
        
        mSavingsSlider.setShowTickMarks(true);
        mSavingsSlider.setShowTickLabels(true);
        mSavingsSlider.setMajorTickUnit(25);
        mSavingsSlider.setBlockIncrement(1);
        mSavingsSlider.setSnapToTicks(true);
        
        //Yearly Interest Rate Slider
        BorderPane yIntRatePane = new BorderPane();
       
        yIntRatePane.setLeft(new Label("Yearly interest rate"));
        yIntRatePane.setCenter(yIntRateSlider);
        yIntRatePane.setRight(yIntRateLabel);
        
        yIntRateSlider.setShowTickMarks(true);
        yIntRateSlider.setShowTickLabels(true);
        yIntRateSlider.setMajorTickUnit(1);
        yIntRateSlider.setBlockIncrement(0.01f);
        yIntRateSlider.setSnapToTicks(true);
        
        //Add all components to the layout
        layout.getChildren().addAll(mSavingsPane, yIntRatePane);
        
        return layout;
    }
    
    public Slider getMSavingsSlider() {
        return this.mSavingsSlider;
    }
    
    public Slider getYIntRateSlider() {
        return this.yIntRateSlider;
    }
}
