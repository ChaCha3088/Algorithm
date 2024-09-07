import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int R;
    private static BigInteger[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        dp = new BigInteger[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                dp[i][j] = BigInteger.ZERO;
            }
            dp[i][0] = BigInteger.ONE;
            dp[i][i] = BigInteger.ONE;
        }

        BigInteger result = combinate(N, R);

        System.out.println(result);
    }

    private static BigInteger combinate(int n, int r) {
        if (dp[n][r].compareTo(BigInteger.ZERO) > 0) {
            return dp[n][r];
        }

        if (r == 0 || n == r) {
            return dp[n][r];
        }

        return dp[n][r] = combinate(n - 1, r - 1).add(combinate(n - 1, r));
    }
}