
import java.util.HashMap;

public class Program {

    public static void main(String[] args) {
        // Test your program here!
    }

    public static void printKeys(HashMap<String,String> hashmap) {
        hashmap.keySet().stream().forEach(System.out::println);
    }
    
    public static void printKeysWhere(HashMap<String,String> hashmap, String text) {
        hashmap.keySet().stream().filter(s -> s.contains(text)).forEach(System.out::println);
    }
    
    public static void printValuesOfKeysWhere(HashMap<String,String> hashmap, String text) {
        hashmap.keySet().stream().filter(s -> s.contains(text)).map(k -> hashmap.get(k)).forEach(System.out::println);
    }
}
