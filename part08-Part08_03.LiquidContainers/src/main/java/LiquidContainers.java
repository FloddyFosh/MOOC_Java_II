
import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        int first = 0;
        int second = 0;
        int amount;
        String cmd;
        String[] cmda;
        
        Scanner scan = new Scanner(System.in);

        
        do {
            System.out.println("First: " + first + "/100");
            System.out.println("Second: " + second + "/100");
            
            cmd = scan.nextLine();
            cmda = cmd.split(" ");
            switch (cmda[0]) {
                case "quit":
                    break;
                case "add":
                    amount = Integer.valueOf(cmda[1]);
                    if (amount > 0) {
                        first = Math.min(100, first + amount);
                    }
                    break;
                case "move":
                    amount = Integer.valueOf(cmda[1]);
                    if (amount > first) {
                        second = Math.min(100, second + first);
                        first = 0;
                    } else if (amount <= first && amount > 0) {
                        first -= amount;
                        second = Math.min(100, second + amount);
                    }
                    break;
                case "remove":
                    amount = Integer.valueOf(cmda[1]);
                    second = Math.max(0, second - amount);
                    break;
                default:
                    System.out.println("Unknown command");
            }
            
        } while (!cmd.equals("quit"));
        
    }

}
