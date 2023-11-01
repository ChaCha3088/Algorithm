import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int N, M;
    private static List<List<Node>> list = new ArrayList();
    private static List<Node> answer = new ArrayList();

    static class Node implements Comparable<Node> {
        public int from, to, cost;

        Node(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node a) {
            return this.cost - a.cost;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList());
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            list.get(A).add(new Node(A, B, C));
            list.get(B).add(new Node(B, A, C));
        }

        dijkstra();

        sb.append(answer.size()).append("\n");

        for (Node node : answer) {
            sb.append(node.from + " " + node.to).append("\n");
        }

        System.out.println(sb);
    }

    private static void dijkstra() {
        boolean[] visited = new boolean[N + 1];
        int[] distance = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        visited[1] = true;
        distance[1] = 0;

        // 각각의 노드에는 목표 정점(to)과 그 정점으로 가기 직전의 정점(from)
        // 시작 정점에서 목표 정점까지의 거리(cost)를 저장
        Queue<Node> pq = new PriorityQueue();
        pq.offer(new Node(1, 1, 0));

        while(!pq.isEmpty()){
            Node vertex = pq.poll();

            if (!visited[vertex.to]) {
                visited[vertex.to] = true;
                answer.add(vertex);
            }

            for (int i = 0; i< list.get(vertex.to).size(); i++){
                Node nextVertex = list.get(vertex.to).get(i);

                // 갈 수 있으면
                if (distance[nextVertex.to] > distance[vertex.to] + nextVertex.cost) {
                    distance[nextVertex.to] = distance[vertex.to] + nextVertex.cost;
                    pq.offer(new Node(nextVertex.from, nextVertex.to, distance[nextVertex.to]));
                }
            }
        }
    }
}