import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N;
    private static int[][] info;
    private static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        info = new int[N + 1][N + 1];
        dp = new int[N + 1][N + 1][2];

        // 입력
        for (int n = 1; n <= N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 3; j++) {
                info[n][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= 3; i++) {
            dp[1][i][0] = info[1][i];
            dp[1][i][1] = info[1][i];
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= 3; j++) {
                dfs(i, j);
            }
        }

        int minValue = Integer.MAX_VALUE;
        for (int i = 1; i <= 3; i++) {
            for (int j = 0; j < 2; j++) {
                if (dp[N][i][j] < minValue) {
                    minValue = dp[N][i][j];
                }
            }
        }

        System.out.println(minValue);
    }

    private static void dfs(int y, int x) {
        // 계산
        if (x == 1) {
            int index = 0;
            if (dp[y - 1][x + 1][1] < dp[y - 1][x + 1][0]) {
                index = 1;
            }
            dp[y][x][0] = dp[y - 1][x + 1][index] + info[y][x];

            index = 0;
            if (dp[y - 1][x + 2][1] < dp[y - 1][x + 2][0]) {
                index = 1;
            }
            dp[y][x][1] = dp[y - 1][x + 2][index] + info[y][x];
        }
        else if (x == 2) {
            int index = 0;
            if (dp[y - 1][x - 1][1] < dp[y - 1][x - 1][0]) {
                index = 1;
            }
            dp[y][x][0] = dp[y - 1][x - 1][index] + info[y][x];

            index = 0;
            if (dp[y - 1][x + 1][1] < dp[y - 1][x + 1][0]) {
                index = 1;
            }
            dp[y][x][1] = dp[y - 1][x + 1][index] + info[y][x];
        }
        else if (x == 3) {
            int index = 0;
            if (dp[y - 1][x - 2][1] < dp[y - 1][x - 2][0]) {
                index = 1;
            }
            dp[y][x][0] = dp[y - 1][x - 2][index] + info[y][x];

            index = 0;
            if (dp[y - 1][x - 1][1] < dp[y - 1][x - 1][0]) {
                index = 1;
            }
            dp[y][x][1] = dp[y - 1][x - 1][index] + info[y][x];
        }
    }
}