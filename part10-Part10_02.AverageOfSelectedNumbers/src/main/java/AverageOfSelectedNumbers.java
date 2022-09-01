
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AverageOfSelectedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // toteuta ohjelmasi tänne

        String s;
        List<String> input = new ArrayList();
        
        System.out.println("Input numbers, type \"end\" to stop.");
        while (!(s = scanner.nextLine()).equals("end")) {
            input.add(s);
        }
        
        System.out.println("Print the average of the negative numbers or the positive numbers? (n/p)");
        switch (scanner.nextLine()) {
            case "n":
                System.out.println("Average of the negative numbers: " + input.stream().mapToDouble(Double::valueOf).filter(d -> d < 0).average());
                break;
            case "p":
                System.out.println("Average of the positive numbers: " + input.stream().mapToDouble(Double::valueOf).filter(d -> d > 0).average());
                break;
            default:
                throw new AssertionError();
        }
    }
}
