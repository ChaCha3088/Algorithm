import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, K, Q, M, S, E;
    private static int[] students, sum;
    private static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        students = new int[N + 3];
        sum = new int[N + 3];

        st = new StringTokenizer(br.readLine());
        for (int k = 0; k < K; k++) {
            students[Integer.parseInt(st.nextToken())] = -1;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            check(Integer.parseInt(st.nextToken()));
        }

        for (int i = 3; i < sum.length; i++) {
            sum[i] = sum[i - 1] + (students[i] != 1 ? 1 : 0);
        }

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            sb.append(sum[e] - sum[s - 1]).append("\n");
        }

        System.out.println(sb);
    }

    private static void check(int x) {
        if (students[x] == -1) {
            return;
        }

        int times = 2;

        for (int i = x; i < students.length; i = x * times++) {
            if (students[i] == 0) {
                students[i] = 1;
                check(i);
            }
        }
    }
}