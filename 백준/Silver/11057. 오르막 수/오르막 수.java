import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int[][] dp = new int[10_001][10];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 초기화
        for (int i = 0; i < 10; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i <= N; i++) {
            calculate(i);
        }

        System.out.println(dp[N][0]);
    }

    private static void calculate(int input) {
        // 9부터 0까지 오면서
        // 전 테이블의 합을 기록
        int sum = 0;

        for (int i = 9; i >= 0; i--) {
            dp[input][i] = sum = (sum + dp[input - 1][i]) % 10_007;
        }
    }
}