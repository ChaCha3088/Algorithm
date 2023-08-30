import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int answer = 0;
    private static int N;
    private static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        dp = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    dp[i][j] = -1;
                }
            }
        }
        
        if (dp[N][N] == -1) {
            System.out.println(0);
            return;
        }

        dp[1][2] = 1;
        move(1, 2, 0);

        System.out.println(dp[N][N]);
    }

    private static void move(int r, int c, int status) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{r, c, status});

        while (!queue.isEmpty()) {
            int[] polled = queue.poll();

            if (polled[0] == N && polled[1] == N) {
                continue;
            }

            // 가로인 경우
            if (polled[2] == 0) {
                // 오른쪽으로 가는 경우
                // 갈 수 있으면
                if (polled[0] <= N && polled[1] + 1 <= N && dp[polled[0]][polled[1] + 1] != -1) {
                    dp[polled[0]][polled[1] + 1] += 1;

                    queue.offer(new int[]{polled[0], polled[1] + 1, 0});
                }

                // 오른쪽 아래로 가는 경우
                // 갈 수 있으면
                if (polled[1] + 1 <= N && polled[0] + 1 <= N && dp[polled[0]][polled[1] + 1] != -1 && dp[polled[0] + 1][polled[1] + 1] != -1 && dp[polled[0] + 1][polled[1]] != -1) {
                    dp[polled[0] + 1][polled[1] + 1] += 1;

                    queue.offer(new int[]{polled[0] + 1, polled[1] + 1, 2});
                }
            }
            // 세로인 경우
            else if (polled[2] == 1) {
                // 오른쪽 아래로 가는 경우
                // 갈 수 있으면
                if (polled[1] + 1 <= N && polled[0] + 1 <= N && dp[polled[0]][polled[1] + 1] != -1 && dp[polled[0] + 1][polled[1] + 1] != -1 && dp[polled[0] + 1][polled[1]] != -1) {
                    dp[polled[0] + 1][polled[1] + 1] += 1;

                    queue.offer(new int[]{polled[0] + 1, polled[1] + 1, 2});
                }

                // 아래로 가는 경우
                // 갈 수 있으면
                if (polled[0] + 1 <= N && polled[1] <= N && dp[polled[0] + 1][polled[1]] != -1) {
                    dp[polled[0] + 1][polled[1]] += 1;

                    queue.offer(new int[]{polled[0] + 1, polled[1], 1});
                }
            }
            // 대각선인 경우
            else if (polled[2] == 2) {
                // 오른쪽으로 가는 경우
                // 갈 수 있으면
                if (polled[0] <= N && polled[1] + 1 <= N && dp[polled[0]][polled[1] + 1] != -1) {
                    dp[polled[0]][polled[1] + 1] += 1;

                    queue.offer(new int[]{polled[0], polled[1] + 1, 0});
                }

                // 오른쪽 아래로 가는 경우
                // 갈 수 있으면
                if (polled[1] + 1 <= N && polled[0] + 1 <= N && dp[polled[0]][polled[1] + 1] != -1 && dp[polled[0] + 1][polled[1] + 1] != -1 && dp[polled[0] + 1][polled[1]] != -1) {
                    dp[polled[0] + 1][polled[1] + 1] += 1;

                    queue.offer(new int[]{polled[0] + 1, polled[1] + 1, 2});
                }

                // 아래로 가는 경우
                // 갈 수 있으면
                if (polled[0] + 1 <= N && polled[1] <= N && dp[polled[0] + 1][polled[1]] != -1) {
                    dp[polled[0] + 1][polled[1]] += 1;

                    queue.offer(new int[]{polled[0] + 1, polled[1], 1});
                }
            }
        }
    }
}