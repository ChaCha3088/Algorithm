import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static int N;
    private static int K;
    private static int[][] paper = new int[1001][1001];
    private static StringBuilder sb;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        int[][] input = new int[100][4];

        //입력
        for (int i = 0; i < N; i++) {
            input[i][0] = sc.nextInt();
            input[i][1] = sc.nextInt();
            input[i][2] = sc.nextInt();
            input[i][3] = sc.nextInt();
        }

        int[] result = new int[100];

        //가장 마지막 종이부터
        for (int i = N - 1; i >= 0; i--) {
            int x = input[i][0];
            int y = input[i][1];

            int width = input[i][2];
            int height = input[i][3];

            for (int j = x; j < x + width; j++) {
                for (int k = y; k < y + height; k++) {
                    if (paper[j][k] == 0) {
                        result[i] += 1;
                        paper[j][k] = 1;
                    }
                }
            }
        }

        //출력
        sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            sb.append(result[i]);
            sb.append("\n");
        }

        System.out.println(sb);
    }
}