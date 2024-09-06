import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    private static int[] arr;
    private static List<int[]>[] info;
    private static int V, E, K;
    private static Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
    private static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        arr = new int[V + 1];

        info = new List[V + 1];

        for (int v = 1; v <= V; v++) {
            info[v] = new LinkedList<>();

            arr[v] = Integer.MAX_VALUE;
        }

        for (int e = 0; e < E; e++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            info[from].add(new int[] {to, weight});
        }

        bfs();

        for (int v = 1; v <= V; v++) {
            if (arr[v] != Integer.MAX_VALUE) {
                sb.append(arr[v]).append("\n");
            }
            else {
                sb.append("INF").append("\n");
            }
        }

        System.out.println(sb);
    }

    private static void bfs() {
        arr[K] = 0;

        pq.offer(new int[] {K, 0});

        while (!pq.isEmpty()) {
            int[] polled = pq.poll();

            for (int[] e : info[polled[0]]) {
                int to = e[0];
                int weight = e[1];

                if (arr[to] > arr[polled[0]] + weight) {
                    arr[to] = arr[polled[0]] + weight;

                    pq.offer(new int[] {to, arr[to]});
                }
            }
        }
    }
}