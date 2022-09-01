
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LiteracyComparison {
    
    public static void main(String[] args) {
        try {
            //Read every line in the file 'literacy.csv'
            Files.lines(Paths.get("literacy.csv"))
                    //Split the lines around the comma
                    .map(l -> l.split(","))
                    //Sort the lines from smallest to largest rate, converting the String representations to Double
                    .sorted((s1, s2) -> Double.valueOf(s1[5]).compareTo(Double.valueOf(s2[5])))
                    //Reduce the entries to the 5 smallest
                    //.limit(5)
                    //Map to the requested String representation
                    .map(s -> s[3] + " (" + s[4] + "), " + s[2].substring(1, s[2].length() - 4) + ", " + s[5])
                    //Print to Output
                    .forEach(System.out::println);
        } catch (IOException ex) {
            Logger.getLogger(LiteracyComparison.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
