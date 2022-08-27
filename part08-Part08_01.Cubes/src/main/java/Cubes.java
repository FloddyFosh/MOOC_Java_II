
import java.util.Scanner;

public class Cubes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s;
        while (!(s = scanner.nextLine()).equals("end")) {
            System.out.println((int)Math.pow(Integer.parseInt(s), 3));
        }
    }
}
