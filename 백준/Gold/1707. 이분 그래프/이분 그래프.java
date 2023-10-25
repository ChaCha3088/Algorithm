import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static List<List<Integer>> graph;
    private static int[] visited;
    private static int K, V, E;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());

        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());

            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            visited = new int[V + 1];

            // 정점 초기화
            for (int v = 0; v <= V; v++) {
                graph.add(new ArrayList());
            }

            // 간선 입력
            for (int e = 0; e < E; e++) {
                st = new StringTokenizer(br.readLine());

                int first = Integer.parseInt(st.nextToken());
                int second = Integer.parseInt(st.nextToken());

                graph.get(first).add(second);
                graph.get(second).add(first);
            }

            boolean answer = false;

            for (int v = 1; v <= V; v++) {
                // 아직 정해지지 않았으면
                if (visited[v] == 0) {
                    // 탐색
                    answer = isBipartiteGraph(v, 1);
                }

                // 이분 탐색 그래프가 아니면
                if (!answer) {
                    // 그만
                    break;
                }
            }

            if (answer) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
    }

    private static boolean isBipartiteGraph(int start, int color) {
        Queue<Integer> queue = new ArrayDeque();
        queue.add(start);

        // 시작 정점 임의의 색상으로 색칠
        visited[start] = color;

        while(!queue.isEmpty()) {
            int currentVertex = queue.poll();
            for(int next : graph.get(currentVertex)) {
                // 인접 정점 색이 동일하면 이분 그래프가 아님
                if (visited[currentVertex] == visited[next]) {
                    return false;
                }

                // 인접 정점 색칠 안된 경우 현재 정점 반대 색깔로 색칠
                // 색상 배열을 통해 방문 여부 확인 가능
                if (visited[next] == 0) {
                    visited[next] = visited[currentVertex] * -1;
                    queue.add(next);
                }
            }
        }

        return true;
    }
}