
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AverageOfNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Write your program here

        String s;
        List<String> input = new ArrayList();
        
        System.out.println("Input numbers, type \"end\" to stop.");
        while (!(s = scanner.nextLine()).equals("end")) {
            input.add(s);
        }
        
        System.out.println("average of the numbers: " + input.stream().mapToDouble(Double::valueOf).average());
    }
}
