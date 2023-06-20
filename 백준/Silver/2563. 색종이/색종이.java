import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static int[][] map;
    private static int[][] arr;
    private static int N;
    private static StringBuilder sb;
    private static boolean result;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        map = new int[101][101];
        arr = new int[N + 1][2];

        //입력
        for (int i = 1; i <= N; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        for (int i = 1; i <= N; i++) {
            int x = arr[i][0];
            int y = arr[i][1];

            for (int j = x; j < x + 10; j++) {
                for (int k = y; k < y + 10; k++) {
                    map[j][k] = 1;
                }
            }
        }

        int sum = 0;

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                 if (map[i][j] == 1) {
                     sum += 1;
                 }
            }
        }

        //출력
        System.out.println(sum);
    }
}