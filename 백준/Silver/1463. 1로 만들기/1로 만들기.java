import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        if (N <= 3) {
            dp = new int[4];
        }
        else {
            dp = new int[N + 1];
        }

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;

        System.out.println(dfs(N));
    }

    private static int dfs(int target) {
        if (dp[target] != Integer.MAX_VALUE) {
            return dp[target];
        }

        int minValue = Integer.MAX_VALUE;

        if (target % 3 == 0) {
            int result = dfs(target / 3);
            if (minValue > result) {
                minValue = result;
            }
        }

        if (target % 2 == 0) {
            int result = dfs(target / 2);
            if (minValue > result) {
                minValue = result;
            }
        }

        int result = dfs(target - 1);
        if (minValue > result) {
            minValue = result;
        }

        dp[target] = minValue + 1;
        return minValue + 1;
    }
}