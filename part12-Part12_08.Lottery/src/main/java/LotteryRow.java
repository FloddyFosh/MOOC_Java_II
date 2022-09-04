
import java.util.ArrayList;
import java.util.Random;

public class LotteryRow {

    private ArrayList<Integer> numbers;

    public LotteryRow() {
        // Draw the numbers when the LotteryRow is created
        this.randomizeNumbers();
    }

    public ArrayList<Integer> numbers() {
        return this.numbers;
    }

    public void randomizeNumbers() {
        // Initialize the list for numbers
        this.numbers = new ArrayList<>();
        Random r = new Random();
        // Implement the random number generation here
        // the method containsNumber is probably useful
        int nums = 7;
        while (nums > 0) {
            int newNumber = r.nextInt(40)+1;
            if (!containsNumber(newNumber)) {
                numbers.add(newNumber);
                nums--;
            }
        }
    }

    public boolean containsNumber(int number) {
        // Check here whether the number is among the drawn numbers
        return numbers.contains(number);
    }
}

