import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int[][] arr;
    private static int[][] dp;
    private static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        // 배열 초기화
        arr = new int[N][2];
        dp = new int[N][N];

        // 입력
        for (int n = 1; n <= N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            arr[n - 1][0] = Integer.parseInt(st.nextToken());
            arr[n - 1][1] = Integer.parseInt(st.nextToken());
        }

        // 초기값 계산
        for (int i = 0; i < N - 1; i++) {
            dp[i][i + 1] = arr[i][0] * arr[i][1] * arr[i + 1][1];
        }

        for (int diff = 2; diff < N; diff++) {
            for (int i = 0; i + diff < N; i++) {
                int j = i + diff;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + arr[i][0] * arr[k][1] * arr[j][1]);
                }
            }
        }

        System.out.println(dp[0][N - 1]);
    }
}