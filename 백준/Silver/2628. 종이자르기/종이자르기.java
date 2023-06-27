import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static int N;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);

        int width = sc.nextInt();
        int height = sc.nextInt();

        N = sc.nextInt();

        int[][] arr = new int[2][101];

        for (int i = 0; i < N; i++) {
             int way = sc.nextInt();
             int much = sc.nextInt();

             arr[way][much] = 1;
        }

        int xMax = 0;
        int yMax = 0;

        arr[0][height] = 1;
        arr[1][width] = 1;

        int xLast = 0;
        for (int i = 1; i <= height; i++) {
             if (arr[0][i] == 1) {
                 int diff = i - xLast;
                 if (diff > xMax) {
                     xMax = diff;
                 }
                 xLast = i;
             }
        }

        int yLast = 0;
        for (int i = 1; i <= width; i++) {
            if (arr[1][i] == 1) {
                int diff = i - yLast;
                if (diff > yMax) {
                    yMax = diff;
                }
                yLast = i;
            }
        }

        System.out.println(xMax * yMax);
    }
}