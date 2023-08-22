import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static List<Integer>[] arr;
    private static int[] entrance;
    private static int N;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new List[N + 1];
        entrance = new int[N + 1];

        for (int m = 1; m <= M; m++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (arr[a] == null) {
                arr[a] = new ArrayList<>();
            }

            arr[a].add(b);
        }

        for (int n = 1; n <= N; n++) {
            if (arr[n] != null) {
                for (int i = 0; i < arr[n].size(); i++) {
                    entrance[arr[n].get(i)] += 1;
                }
            }
        }

        sort();

        System.out.println(sb);
    }

    private static void sort() {
        Deque<Integer> queue = new ArrayDeque<>();

        for (int n = 1; n <= N; n++) {
            if (entrance[n] == 0) {
                queue.offerLast(n);
            }
        }

        for (int j = 1; j <= N; j++) {
            if (queue.isEmpty()) {
                return;
            }

            int polled = queue.pollFirst();

            sb.append(polled).append(" ");

            if (arr[polled] == null) {
                continue;
            }

            for (int i = 0; i < arr[polled].size(); i++) {
                entrance[arr[polled].get(i)] -= 1;

                if (entrance[arr[polled].get(i)] == 0) {
                    queue.offerLast(arr[polled].get(i));
                }
            }

            arr[polled].clear();
        }
    }
}