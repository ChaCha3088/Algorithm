import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    private static int[][] arr;
    private static int[][] map;
    private static int N;
    private static StringBuilder sb;
    private static boolean result;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);

        int T = 10;

        arr = new int[4][4];

        map = new int[101][101];

        //입력
        for (int i = 0; i < 4; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            arr[i][2] = sc.nextInt();
            arr[i][3] = sc.nextInt();

            for (int j = arr[i][0]; j < arr[i][2]; j++) {
                for (int k = arr[i][1]; k < arr[i][3]; k++) {
                    map[j][k] = 1;
                }
            }
        }

        int sum = 0;

        //면적 계산
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                if (map[i][j] == 1) {
                    sum += 1;
                }
            }
        }

        System.out.println(sum);
    }
}