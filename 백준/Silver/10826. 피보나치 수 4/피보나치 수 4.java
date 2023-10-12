import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    private static BigInteger[] fibonaccis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        fibonaccis = new BigInteger[N + 1];
        fibonaccis[0] = new BigInteger("0");
        if (N >= 1) {
            fibonaccis[1] = new BigInteger("1");
        }

        System.out.println(getFibonacci(N));
    }

    private static BigInteger getFibonacci(int target) {
        if (fibonaccis[target] != null) {
            return fibonaccis[target];
        }

        return fibonaccis[target] = getFibonacci(target - 1).add(getFibonacci(target - 2));
    }
}