import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        dp = new int[31][31];
        for (int i = 0; i <= 30; i++) {
            dp[i][0] = 1;
            dp[i][i] = 1;
        }

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            int R = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken());

            int result = combinate(N, R);

            System.out.println(result);
        }
    }

    private static int combinate(int n, int r) {
        if (dp[n][r] > 0) {
            return dp[n][r];
        }

        if (r == 0 || n == r) {
            return dp[n][r];
        }

        return dp[n][r] = combinate(n - 1, r - 1) + combinate(n - 1, r);
    }
}