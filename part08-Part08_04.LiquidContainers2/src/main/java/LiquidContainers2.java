
import java.util.Scanner;

public class LiquidContainers2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Container first = new Container();
        Container second = new Container();
        
        int amount;
        String cmd;
        String[] cmda;
        
        do {
            System.out.println("First: " + first);
            System.out.println("Second: " + second);
            
            cmd = scan.nextLine();
            cmda = cmd.split(" ");
            switch (cmda[0]) {
                case "quit":
                    break;
                case "add":
                    amount = Integer.valueOf(cmda[1]);
                    first.add(amount);
                    break;
                case "move":
                    amount = Integer.valueOf(cmda[1]);
                    if (amount > first.contains()) {
                        second.add(first.contains());
                        first.remove(first.contains());
                    } else if (amount <= first.contains() && amount > 0) {
                        first.remove(amount);
                        second.add(amount);
                    }
                    break;
                case "remove":
                    amount = Integer.valueOf(cmda[1]);
                    second.remove(amount);
                    break;
                default:
                    System.out.println("Unknown command");
            }
            
        } while (!cmd.equals("quit"));
    }

}
