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

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int answer = Integer.MAX_VALUE;

        int[] memory = new int[N];
        int[] cost = new int[N];
        dp = new int[N][100001];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            memory[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            int c = cost[i];
            int m = memory[i];

            for (int j = 0; j <= 100000; j++) {
                if (i == 0) { // 첫번째 인 경우 -> j가 c 이상이면 m 값을 담는다
                    if (j >= c) {
                        dp[i][j] = m;
                    }
                } 
                else { // 첫번째 행이 아닌 경우
                    if (j >= c) { // j가 c 이상이면 최댓값 계산 ( 1. 이전 행에서 c비용 안쓰고 확보한 메모리 값 + 이번 행에서 c비용으로 확보한 메모리 vs 이전 행에서 같은 비용 써서 확보한 메모리)
                        dp[i][j] = Math.max(dp[i - 1][j - c] + m, dp[i - 1][j]);
                    }
                    else { // j가 c 이상이 아니라면 이전 행
                        dp[i][j] = dp[i - 1][j];
                    }
                }

                // m 바이트 이상의 메모리를 확보하는 최소의 비용 구하기
                if (dp[i][j] >= M) {
                    answer = Math.min(answer, j);
                }
            }
        }

        System.out.println(answer);
    }
}