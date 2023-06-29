import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    private static int[] first, second;
    private static int xDiff, yDiff;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);

        first = new int[4];
        second = new int[4];

        //입력
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                first[j] = sc.nextInt();
            }
            for (int j = 0; j < 4; j++) {
                second[j] = sc.nextInt();
            }

            String answer = "";

            int xl = Math.max(first[0], second[0]);
            int xr = Math.min(first[2], second[2]);
            int yb = Math.max(first[1], second[1]);
            int yt = Math.min(first[3], second[3]);

            xDiff = xr - xl;
            yDiff = yt - yb;

            if (xDiff > 0 && yDiff > 0) {
                System.out.println("a");
            }
            else if (xDiff < 0  || yDiff < 0) {
                System.out.println("d");
            }
            else if (xDiff == 0 && yDiff == 0) {
                System.out.println("c");
            }
            else {
                System.out.println("b");
            }
        }
    }
}