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

        dp = new int[N + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);

        dfs(N, N, 0);

        System.out.println(dp[N]);
    }

    private static void dfs(int target, int current, int count) {
        if (current == 1) {
            if (count < dp[target]) {
                dp[target] = count;
            }

            return;
        }

        if (count + 1 < dp[target]) {
            if (current % 3 == 0) {
                dfs(target, current / 3, count + 1);
            }
            if (current % 2 == 0){
                dfs(target,current / 2,count + 1);
            }
            dfs(target, current - 1, count + 1);
        }
    }
}