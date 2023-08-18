import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static List<Integer>[] arr;
    private static Queue<Integer> results = new ArrayDeque();
    private static boolean[] visited;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N  = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        arr = new List[N + 1];
        for (int n = 0; n <= N; n++) {
            arr[n] = new ArrayList();
        }

        for (int m = 1; m <= M; m++) {
            st = new StringTokenizer(br.readLine());

            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            arr[first].add(second);
            arr[second].add(first);
        }

        // 정렬
        for (int n = 0; n <= N; n++) {
            arr[n].sort(Comparator.comparingInt(o -> o));
        }

        // 기록 초기화
        visited = new boolean[N + 1];
        dfs(V);
        while (!results.isEmpty()) {
            sb.append(results.poll()).append(" ");
        }

        sb.append("\n");

        // 기록 초기화
        visited = new boolean[N + 1];
        bfs(V);
        while (!results.isEmpty()) {
            sb.append(results.poll()).append(" ");
        }

        System.out.println(sb);
    }

    private static void dfs(int start) {
        Deque<Integer> stack = new ArrayDeque();
        stack.offerLast(start);

        while (!stack.isEmpty()) {
            int polled = stack.pollLast();

            if (visited[polled]) {
                continue;
            }

            visited[polled] = true;

            // 기록
            results.offer(polled);

            // 뒤에서 부터 넣어
            for (int i = arr[polled].size() - 1; i >= 0; i--) {
                stack.offerLast(arr[polled].get(i));
            }
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new ArrayDeque();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int polled = queue.poll();

            // 기록
            results.offer(polled);

            // 앞에서 부터 넣어
            for (int i = 0; i < arr[polled].size(); i++) {
                if (!visited[arr[polled].get(i)]) {
                    visited[arr[polled].get(i)] = true;
                    queue.offer(arr[polled].get(i));
                }
            }
        }
    }
}