import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    private static StringBuilder sb = new StringBuilder();
    private static long[] factorials = new long[1_000_001];
    private static int T, N, R;
    private static long answer;
    private static final long divisor = 1_234_567_891;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        factorials[1] = 1;

        for (int i = 2; i < 1_000_001; i++) {
            factorials[i] = factorials[i - 1] * i % divisor;
        }

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());

            answer = (factorials[N] * pow((int) ((factorials[N - R] * factorials[R]) % divisor), (int) (divisor - 2))) % divisor;

            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }

        System.out.println(sb);
    }

    private static long pow(int number, int times) {
        if (times == 0) {
            return 1;
        }
        if (times == 1) {
            return number;
        }

        // 짝수면
        if (times % 2 == 0) {
            long temp = pow(number, times / 2) % divisor;

            return (temp * temp) % divisor;
        }
        // 홀수면
        long temp = pow(number, times - 1) % divisor;
        return (temp * number) % divisor;
    }
}