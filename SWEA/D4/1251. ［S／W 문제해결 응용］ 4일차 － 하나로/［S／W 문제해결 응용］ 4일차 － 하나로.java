import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    private static StringBuilder sb = new StringBuilder();
    private static int T, N;
    private static double e;
    private static long answer;
    private static Island[] islands;
    private static List<Edge> edges;
    private static int[] parents;

    static class Edge {
        private int from;
        private int to;
        private double cost;

        public Edge (int from, int to, double cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    static class Island {
        private int x;
        private int y;

        public Island(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            islands = new Island[N];

            // 입력
            StringTokenizer xs = new StringTokenizer(br.readLine());
            StringTokenizer ys = new StringTokenizer(br.readLine());
            for (int n = 0; n < N; n++) {
                islands[n] = new Island(Integer.parseInt(xs.nextToken()), Integer.parseInt(ys.nextToken()));
            }

            e = Double.parseDouble(br.readLine());

            // 간선 저장
            edges = new ArrayList<>();
            for (int i = 0; i < islands.length; i++) {
                for (int j = i + 1; j < islands.length; j++) {
                    double result = Math.pow(islands[i].x - islands[j].x, 2) + Math.pow(islands[i].y - islands[j].y, 2);
                    edges.add(new Edge(i, j, result));
                }
            }

            // 간선 비용 기준 오름차순 정렬
            edges.sort(Comparator.comparingDouble(o -> o.cost));

            // 정점 초기화
            parents = new int[N];
            for (int i = 1; i < N; i++) {
                parents[i] = i;
            }

            int count = 0;
            answer = 0;

            for (Edge edge : edges) {
                // 사이클이 형성되지 않으면
                if (union(edge.from, edge.to)) {
                    answer += edge.cost;
                    count += 1;

                    if (count == N - 1) {
                        break;
                    }
                }
            }

            // 출력
            sb.append("#").append(t).append(" ").append(Math.round(answer * e)).append("\n");
        }

        System.out.println(sb);
    }

    private static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        // 부모가 같다는건 사이클이 형성된다는 뜻
        if (aRoot == bRoot) {
            return false;
        }

        parents[aRoot] = bRoot;
        return true;
    }

    private static int find(int x) {
        if (parents[x] == x) {
            return x;
        }

        return parents[x] = find(parents[x]);
    }
}