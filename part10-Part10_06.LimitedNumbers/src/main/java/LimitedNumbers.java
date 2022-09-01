
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class LimitedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = new LinkedList();
        
        Integer i;
        while ((i = Integer.valueOf(scanner.nextLine())) > 0 ) {
            list.add(i);
        }
        
        list.stream().filter(j -> (1 <= j && j <= 5)).forEach(System.out::println);
    }
}
