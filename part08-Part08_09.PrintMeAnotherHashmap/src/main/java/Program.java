
import java.util.HashMap;

public class Program {

    public static void main(String[] args) {
        // Test your program here!
    }

    public static void printValues(HashMap<String,Book> hashmap) {
        hashmap.values().forEach(System.out::println);
    }
    
    public static void printValueIfNameContains(HashMap<String,Book> hashmap, String text) {
        hashmap.values().stream().filter(b -> b.getName().contains(text)).forEach(System.out::println);
    }
}
