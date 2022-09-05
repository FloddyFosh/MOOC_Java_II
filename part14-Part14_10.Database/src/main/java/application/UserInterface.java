package application;

import java.sql.SQLException;
import java.util.Scanner;

public class UserInterface {

    private Scanner scanner;
    private TodoDao database;

    public UserInterface(Scanner scanner, TodoDao database) {
        this.scanner = scanner;
        this.database = database;
    }

    public void start() throws SQLException {
        boolean running = true;
        while (running) {
            System.out.println("");
            System.out.println("Enter command:");
            System.out.println("1) list");
            System.out.println("2) add");
            System.out.println("3) mark as done");
            System.out.println("4) remove");
            System.out.println("x) quit");

            System.out.print("> ");
            System.out.flush();
            String command = this.scanner.nextLine();

            // implement the functionality here
            switch (command) {
                case "x":
                    running = false;
                    break;
                case "1":
                    list();
                    break;
                case "2":
                    add();
                    break;
                case "3":
                    done();
                    break;
                case "4":
                    remove();
                    break;
                default:
                    throw new AssertionError();
            }
        }

        System.out.println("Thank you!");
    }
    
    private void list() throws SQLException {
        System.out.println("Listing the database contents");
        database.list().forEach(System.out::println);
    }
    
    private void add() throws SQLException {
        System.out.println("Adding a new todo");
        
        System.out.println("Enter name");
        String name = scanner.nextLine();
        
        System.out.println("Enter description");
        String desc = scanner.nextLine();
        
        database.add(new Todo(name, desc, false));
    }
    
    private void done() throws SQLException {
        System.out.println("Which todo should be marked as done (give the id)?");
        int id = Integer.parseInt(scanner.nextLine());
        database.markAsDone(id);
    }
    
    private void remove() throws SQLException {
        System.out.println("Which todo should be removed (give the id)?");
        int id = Integer.parseInt(scanner.nextLine());
        database.remove(id);
    }

}
