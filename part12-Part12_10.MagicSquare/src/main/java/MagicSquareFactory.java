
public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int size) {

        MagicSquare square = new MagicSquare(size);
        int x = size / 2;
        int y = 0;
        for (int i = 0; i < size*size; i++) {
            square.placeValue(x, y, i+1);
            x = (x + 1) % size;
            y = (y - 1 + size) % size;
            if (square.readValue(x, y) != 0) {
                x = (x - 1 + size) % size;
                y = (y + 2) % size;
            }
        }
         
        // implement the creation of a magic square with the Siamese method algorithm here
        return square;
    }
    
    

}
