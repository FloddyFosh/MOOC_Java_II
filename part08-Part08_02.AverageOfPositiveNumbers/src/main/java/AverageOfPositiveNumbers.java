
import java.util.Scanner;

public class AverageOfPositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numbers = 0;
        double sum = 0;
        double n;
        
        do {
            System.out.println("Give a number:");
            n = scanner.nextDouble();
            
            if (n > 0) {
                numbers++;
                sum += n;
            }
        } while (n != 0);
        
        if (numbers > 0) {
            System.out.println("Average of the numbers: " + (sum / numbers));
        } else {
            System.out.println("Cannot calculate the average");
        }
    }
}
