import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N;
    private static long[][][] dp;
    private static boolean[][] wall;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        dp = new long[N + 1][N + 1][3];
        wall = new boolean[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    wall[i][j] = true;
                }
            }
        }

        if (wall[N][N]) {
            System.out.println(0);
            return;
        }

        dp[1][2][0] = 1;

        for (int i = 1; i <= N; i++) {
            for (int j = 3; j <= N; j++) {
                if (wall[i][j]) {
                    continue;
                }

                // 가로 (0)
                dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2];

                if (i == 1) continue; // 맨 윗줄이면 continue

                // 세로 (1)
                dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2];

                if (wall[i - 1][j] || wall[i][j - 1]) {
                    continue;
                }

                // 대각선 (2)
                dp[i][j][2] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
            }
        }

        System.out.println(dp[N][N][0]+dp[N][N][1]+dp[N][N][2]);
    }
}