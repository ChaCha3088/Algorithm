import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<int[]> steps;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        steps = new ArrayList<>();

        BigInteger two = new BigInteger("2");
        System.out.println(two.pow(N).subtract(new BigInteger("1")));

        if (N <= 20) {
            hanoi(N, 1, 3, 2);

            for (int i = 0; i < steps.size(); i++) {
                System.out.println(steps.get(i)[0] + " " + steps.get(i)[1]);
            }
        }
    }

    private static void hanoi(int n, int from, int to, int via) {
        if (n == 1) { //하나의 원판만 남았으면 1 -> 3
            steps.add(new int[] {from, to});
        }
        else {
            //1. N-1개의 원판을 1 -> 2
            hanoi(n - 1, from, via, to);
            steps.add(new int[] {from, to});

            //2. N-1개의 원판을 2 -> 3
            hanoi(n - 1, via, to, from);
        }
    }
}