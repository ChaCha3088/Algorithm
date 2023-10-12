import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    private static int[] fibonaccis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger N = new BigInteger(br.readLine());

        if (N.equals(0)) {
            System.out.println(0);
            return;
        }

        if (N.equals(1)) {
            System.out.println(1);
            return;
        }

        int M = 1_000_000;

        int R = 15 * 100_000;

        fibonaccis = new int[R + 1];
        fibonaccis[0] = 0;
        fibonaccis[1] = 1;

        int div = (N.mod(BigInteger.valueOf(R))).intValue();

        for (int i = 2; i <= R; i++) {
            fibonaccis[i] = (fibonaccis[i - 1] + fibonaccis[i - 2]) % M;
        }

        System.out.println(fibonaccis[div]);
    }
}