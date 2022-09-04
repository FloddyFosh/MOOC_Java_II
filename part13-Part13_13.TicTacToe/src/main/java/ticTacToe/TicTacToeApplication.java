package ticTacToe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ticTacToe.domain.TicTacToe;


public class TicTacToeApplication extends Application {
    private TicTacToe tictactoe;

    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }

    /*@Override
    public void init() {
        //1. Initialize a new TicTacToe game
        this.tictactoe = new TicTacToe();
    }*/
    
    @Override
    public void start(Stage stage) {
    this.tictactoe = new TicTacToe();  
    
    //2. Main Window Settings
        stage.setTitle("TicTacToe");
        
        //3. Create the Window Layout
        BorderPane layout = new BorderPane();
        GridPane tttlayout = new GridPane();
        
        //4. Label keeping track of the turn and gamestate
        Label turnLabel = new Label("Turn: " + tictactoe.getTurn().name());
        turnLabel.setFont(Font.font("Monospaced", 40));
        
        
        //5. Create the TicTacToe layout (buttons)
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Button button = new Button(" ");
                button.setFont(Font.font("Monospaced", 40));
                button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                
                tttlayout.add(button, i, j);
                int x = i;
                int y = j;
                
                button.setOnMouseClicked((event) -> {
                    String player = tictactoe.getTurn().name();
                    if(tictactoe.placeSymbol(x, y)) {
                        button.setText(player);
                        if (tictactoe.hasWinner()) {
                            turnLabel.setText("The end!");
                        } else {
                            turnLabel.setText("Turn: " + tictactoe.getTurn().name());
                        }
                    }
                    
                });
            }
        }
        
        tttlayout.setAlignment(Pos.CENTER);
        tttlayout.setVgap(10);
        tttlayout.setHgap(10);
        
        for (int j = 0; j < 3; j++) {
            ColumnConstraints cc = new ColumnConstraints();
            cc.setHgrow(Priority.ALWAYS);
            tttlayout.getColumnConstraints().add(cc);
        }

        for (int j = 0; j < 3; j++) {
            RowConstraints rc = new RowConstraints();
            rc.setVgrow(Priority.ALWAYS);
            tttlayout.getRowConstraints().add(rc);
        }
        
        tttlayout.setPadding(new Insets(10, 10, 10, 10));
        
        //6. Add the label and the TicTacToe layout
        layout.setTop(turnLabel);
        layout.setCenter(tttlayout);
        
        //7. Create the main view and add the high level layout
        Scene view = new Scene(layout, 300, 320);
        
        //8. Show the application
        stage.setScene(view);
        stage.sizeToScene();
        
        stage.show();
        stage.setMinWidth(stage.getWidth());
        stage.setMinHeight(stage.getHeight());
    }

}
