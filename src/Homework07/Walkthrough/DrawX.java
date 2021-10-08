package Homework07.Walkthrough;
import java.util.Arrays;
/**
 * A class that generates a 2-D char array representing an 'X'
 *
 * <p>Purdue University -- CS18000 -- Fall 2021</p>
 *
 * @author Purdue CS
 * @version August 23, 2021
 */
public class DrawX {

    private int size;

    public DrawX(int size) {
        this.size = size;
    }

    public static void main(String[] args) {

        DrawX sample = new DrawX(5);

        char[][] testArray = sample.generateArray();

        for (int i = 0; i < testArray.length; i++) {
            System.out.println(Arrays.toString(testArray[i]));
        }
    }

    public char[][] generateArray() {

        char[][] xArray = new char[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int iJ = i + j + 1;
                if (i == j) {
                    xArray[i][j] = '*';
                } else if (iJ == size) {
                    xArray[i][j] = '*';
                } else xArray[i][j] = ' ';
            }
        }

        return xArray;
    }
}
