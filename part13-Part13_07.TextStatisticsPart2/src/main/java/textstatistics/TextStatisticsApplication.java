package textstatistics;

import java.util.Arrays;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class TextStatisticsApplication extends Application {

    private Label lettersLabel;
    private Label wordsLabel;
    private Label longestLabel;
    private TextArea textarea;

    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }

    @Override
    public void start(Stage window) {
        window.setTitle("Text Statistics");
        
        BorderPane bpane = new BorderPane();
        textarea = new TextArea();
        bpane.setCenter(textarea);
        
        HBox hbox = new HBox();
        lettersLabel = new Label("Letters: 0");
        wordsLabel = new Label("Words: 0");
        longestLabel = new Label("The longest word is: ");
        
        textarea.textProperty().addListener((change, oldValue, newValue) -> {
            int characters = newValue.length();
            String[] parts = newValue.split(" ");
            int words = parts.length;
            String longest = Arrays.stream(parts)
                .sorted((s1, s2) -> s2.length() - s1.length())
                .findFirst()
                .get();
            
            updateLettersLabel(characters);
            updateWordsLabel(words);
            updateLongestLabel(longest);
        });
        
        hbox.getChildren().addAll(lettersLabel, wordsLabel, longestLabel);
        hbox.setSpacing(10);
        
        bpane.setBottom(hbox);
        Scene scene = new Scene(bpane);
        
        window.setScene(scene);
        window.show();
    }

    private void updateLettersLabel(int letters) {
        lettersLabel.setText("Letters: " + letters);
    }
    
    private void updateWordsLabel(int words) {
        wordsLabel.setText("Words: " + words);
    }
    
    private void updateLongestLabel(String word) {
        longestLabel.setText("The longest word is: " + word);
    }
    
}
