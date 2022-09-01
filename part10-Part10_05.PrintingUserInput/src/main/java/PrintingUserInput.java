
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class PrintingUserInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = new LinkedList();
        
        String s;
        while (!(s = scanner.nextLine()).equals("")) {
            list.add(s);
        }
        
        list.stream().forEach(System.out::println);
    }
}
