
import java.util.HashMap;

public class Nicknames {

    public static void main(String[] args) {
        // Do the operations required here!
        HashMap<String, String> namesMap = new HashMap();
        
        namesMap.put("Matthew", "Matt");
        namesMap.put("Michael", "Mix");
        namesMap.put("Arthur", "Artie");
        
        System.out.println(namesMap.get("Matthew"));
    }

}
