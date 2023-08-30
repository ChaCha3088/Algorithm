import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N;
    private static boolean[] visited;
    private static int[][] dp;
    private static int minValue = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            visited[i] = true;
            dfs(i, i, 0);
        }
        
        System.out.println(minValue);
    }

    public static void dfs(int start, int current, int cost){
        if (isAllVisited()) {
            if (dp[current][start] != 0){
                minValue = Math.min(minValue, cost + dp[current][0]);
            }
            return;
        }

        for (int i = 1; i < N; i++){
            if (!visited[i] && dp[current][i] != 0) {
                visited[i] = true;
                dfs(start, i, cost + dp[current][i]);
                visited[i] = false;
            }
        }
    }

    public static boolean isAllVisited() {
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }
}