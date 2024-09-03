import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N;
    private static List<Integer>[] index;
    private static boolean[] visited;
    private static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        index = new List[N + 1];
        visited = new boolean[N + 1];
        visited[1] = true;
        for (int i = 0; i <= N; i++) {
            index[i] = new ArrayList<>();
        }

        int computers = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < computers; i++) {
            st = new StringTokenizer(br.readLine());

            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            index[first].add(second);
            index[second].add(first);
        }

        bfs();

        System.out.println(answer);
    }

    private static void bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);

        while (!queue.isEmpty()) {
            int polled = queue.poll();
            answer += 1;

            for (int next : index[polled]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}