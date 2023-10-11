import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int N;
    private static int maxDepth = 0;
    private static int[][] arr, dp;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        dp = new int[N][N];
        maxDepth = 0;

        // 입력
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (dp[i][j] < 1) {
                    dfs(i, j, 1);
                }
            }
        }

        System.out.println(maxDepth);
    }

    private static int dfs(int row, int column, int depth) {
        // 0이 아니면 무조건 최대값이니까 반환
        if (dp[row][column] != 0) {
            if (dp[row][column] > maxDepth) {
                maxDepth = dp[row][column];
            }

            return dp[row][column];
        }

        // 4방 아무것도 못가면 dp가 1
        dp[row][column] = 1;

        // 4방향 뭐라도 있으면 dp 업데이트됨
        for (int i = 0; i < 4; i++) {
            int newRow = row + dy[i];
            int newColumn = column + dx[i];

            // 범위 밖 넘어가기 || 전보다 크지 않으면 넘어가기
            if (newRow < 0 || newRow >= N || newColumn < 0 || newColumn >= N || arr[row][column] >= arr[newRow][newColumn]) {
                continue;
            }

            dp[row][column] = Math.max(dp[row][column], dfs(newRow, newColumn, depth + 1) + 1);
        }

        if (dp[row][column] > maxDepth) {
            maxDepth = dp[row][column];
        }
        // 그걸 반환
        return dp[row][column];
    }
}