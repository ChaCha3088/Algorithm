import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    private static StringBuilder sb = new StringBuilder();
    private static int T, N, answer;
    private static int[][] arr;
    private static int[][] dp;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {1, -1, 0, 0};

    static class Node {
        private int x;
        private int y;
        private int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            dp = new int[N][N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(dp[i], 99999999);
            }

            for (int n = 0; n < N; n++) {
                String string = br.readLine();

                for (int m = 0; m < N; m++) {
                    arr[n][m] = string.charAt(m) - '0';
                }
            }

            dfs();

            answer = dp[N - 1][N - 1];

            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs() {
        Queue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        pq.offer(new Node(0, 0, arr[0][0]));

        while (!pq.isEmpty()) {
            Node polled = pq.poll();

            for (int i = 0; i < 4; i++) {
                int newY = polled.y + dy[i];
                int newX = polled.x + dx[i];

                if (newY < 0 || newY >= N || newX < 0 || newX >= N) {
                    continue;
                }

                int newCost = polled.cost + arr[newY][newX];

                if (dp[newY][newX] > newCost) {
                    dp[newY][newX] = newCost;
                    pq.offer(new Node(newX, newY, newCost));
                }
            }
        }
    }
}