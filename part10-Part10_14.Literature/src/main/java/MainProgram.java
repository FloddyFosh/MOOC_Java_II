
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Book> books = new ArrayList();
        String s;
        
        while (scanner.hasNext()) {
            System.out.println("Input the name of the book, empty stops: ");
            if ((s = scanner.nextLine()).equals("")) {
                break;
            }
            
            System.out.println("Input the age recommendation:");
            books.add(new Book(s, Integer.parseInt(scanner.nextLine())));
        }
        
        System.out.println(books.size() + " books in total.\n\nBooks:");
        books.stream().sorted().forEach(System.out::println);
        
    }

}
