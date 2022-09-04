
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // test your method here
    }

    public static int sum(int[] array, int fromWhere, int toWhere, int smallest, int largest) {
        fromWhere = Math.max(fromWhere, 0);
        toWhere = Math.min(toWhere, array.length);
        int sum = 0;
        for (int i = fromWhere; i < toWhere; i++) {
            if (array[i] >= smallest && array[i] <= largest) {
                sum += array[i];
            }
        }
        return sum;
    }
}
