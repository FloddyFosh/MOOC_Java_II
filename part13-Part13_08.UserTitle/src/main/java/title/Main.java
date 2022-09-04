package title;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Provide a title: ");
        String title = scanner.nextLine();

        UserTitle.launch(UserTitle.class, "--title=" + title);
    }

}
