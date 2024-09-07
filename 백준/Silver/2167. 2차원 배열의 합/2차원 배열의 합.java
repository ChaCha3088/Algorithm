import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, M, K;
    private static int[][] arr, dp;
    private static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][M + 1];
        dp = new int[N + 1][M + 1];

        for (int n = 1; n <= N; n++) {
            st = new StringTokenizer(br.readLine());

            for (int m = 1; m <= M; m++) {
                arr[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + arr[i][j];
            }
        }

        K = Integer.parseInt(br.readLine());

        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());

            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            sb.append(dp[x][y] - (dp[x][j - 1] + dp[i - 1][y]) + dp[i - 1][j - 1]).append("\n");
        }

        System.out.println(sb);
    }
}