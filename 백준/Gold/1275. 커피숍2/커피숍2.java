import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int N, Q;
    private static long[] arr, temp;
    private static FenWick fenWick;

    static class FenWick {
        private long[] tree;

        public FenWick(int size) {
            this.tree = new long[size];
        }

        private void update(int idx, long num) {
            while (idx < this.tree.length) {
                this.tree[idx] += num;
                idx += (idx & -idx);
            }
        }

        private long sum(int idx) {
            long allSum = 0;
            while (idx > 0) {
                allSum += this.tree[idx];
                idx -= (idx & -idx);
            }
            return allSum;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        // 초기화
        arr = new long[N + 1];
        fenWick = new FenWick(N + 1);

        // N개의 수가 주어짐
        st = new StringTokenizer(br.readLine());
        for (int n = 1; n <= N; n++) {
            long input = Long.parseLong(st.nextToken());

            arr[n] = input;
            fenWick.update(n, input);
        }

        for (int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine());

            temp = new long[4];

            for (int i = 0; i < 4; i++) {
                temp[i] = Long.parseLong(st.nextToken());
            }

            // swap
            if (temp[0] > temp[1]) {
                long t = temp[0];

                temp[0] = temp[1];
                temp[1] = t;
            }

            sb.append(fenWick.sum((int) temp[1]) - fenWick.sum((int) (temp[0] - 1))).append("\n");
            long diff = temp[3] - arr[(int) temp[2]];
            fenWick.update((int) temp[2], diff);
            arr[(int) temp[2]] = temp[3];
        }

        System.out.println(sb);
    }
}