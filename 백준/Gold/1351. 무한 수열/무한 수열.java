import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static long N;
    private static int P, Q;
    private static Map<Long, Long> dp = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        dp.put(0l, 1l);

        dpdp(N);

        System.out.println(dp.get(N));
    }

    private static long dpdp(long target) {
        Long getResult = dp.getOrDefault(target, -1l);

        if (getResult != -1l) {
            return getResult;
        }

        long first = target / P;
        long pResult = dpdp(first);

        long second = target / Q;
        long qResult = dpdp(second);

        long sum = pResult + qResult;
        dp.put(target, sum);

        return sum;
    }
}