import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]), M = Integer.parseInt(split[1]), R = Integer.parseInt(split[2]);

        // 배열 초기화
        arr = new int[N][M];

        // 배열 입력
        for (int y = 0; y < N; y++) {
            split = br.readLine().split(" ");
            for (int x = 0; x < M; x++) {
                arr[y][x] = Integer.parseInt(split[x]);
            }
        }

        int count = Math.min(N, M) / 2;
        for (int i = 0; i < R; i++) {

            for (int j = 0; j < count; j++) {
                int temp = arr[j][j];

                for (int k = j + 1; k < M - j; k++)
                    arr[j][k - 1] = arr[j][k];

                for (int k = j + 1; k < N - j; k++)
                    arr[k - 1][M - 1 - j] = arr[k][M - 1 - j];

                for (int k = M - 2 - j; k >= j; k--)
                    arr[N - 1 - j][k + 1] = arr[N - 1 - j][k];

                for (int k = N - 2 - j; k >= j; k--)
                    arr[k + 1][j] = arr[k][j];

                arr[j + 1][j] = temp;
            }
        }

        for (int j = 0; j < N; j++) {
            for (int k = 0; k < M; k++) {
                System.out.print(arr[j][k] + " ");
            }
            System.out.println();
        }
    }
}