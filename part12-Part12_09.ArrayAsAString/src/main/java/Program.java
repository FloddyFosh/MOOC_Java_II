
public class Program {

    public static void main(String[] args) {
        // Test your method here
    }

    public static String arrayAsString(int[][] array) {
        StringBuilder sb = new StringBuilder();
        for (int[] array1 : array) {
            for (int j = 0; j < array1.length; j++) {
                sb.append(array1[j]);
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
