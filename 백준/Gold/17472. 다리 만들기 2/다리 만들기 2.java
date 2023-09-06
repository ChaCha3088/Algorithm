import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        public int startIslandNumber;
        public int targetIslandNumber;
        public int length;

        public Node(int startIslandNumber, int targetIslandNumber, int length) {
            this.startIslandNumber = startIslandNumber;
            this.targetIslandNumber = targetIslandNumber;
            this.length = length;
        }

        @Override
        public int compareTo(Node node) {
            return this.length - node.length;
        }
    }

    private static int N, M;
    private static int[][] arr;
    private static boolean[][] visited;
    private static List<List<int[]>> islands = new ArrayList();
    private static List<int[]> tempOfIsland = new ArrayList();
    private static int islandNumber = 1;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {1, -1, 0, 0};
    private static int[] parent;
    private static Queue<Node> pq = new PriorityQueue((o1, o2) -> {
        Node node1 = (Node) o1;
        Node node2 = (Node) o2;

        return node1.length - node2.length;
    });
    private static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        // 입력
        for (int n = 1; n <= N; n++) {
            st = new StringTokenizer(br.readLine());

            for (int m = 1; m <= M; m++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    arr[n][m] = 1;
                }
            }
        }

        // 섬 인식 및 저장
        for (int n = 1; n <= N; n++) {
            for (int m = 1; m <= M; m++) {
                // 땅이고, 방문한적 없으면
                if (arr[n][m] != 0 && !visited[n][m]) {
                    recogniseIsland(n, m, 0);

                    islandNumber += 1;
                }
            }
        }

        // 섬을 연결할 수 있는 방법 찾기
        for (int i = 1; i < islandNumber; i++) {
            for (int j = 0; j < islands.get(i - 1).size(); j++) {
                int[] island = islands.get(i - 1).get(j);
                for (int k = 0; k < 4; k++) {
                    makeBridge(island[0], island[1], i, k, -1);
                }
            }
        }

        // MST 알고리즘으로 최소 간선 구하기
        kruskal();

        System.out.println(answer);
    }

    private static void recogniseIsland(int n, int m, int depth) {
        // 방문 처리
        visited[n][m] = true;
        arr[n][m] = islandNumber;
        tempOfIsland.add(new int[]{n, m});

        for (int i = 0; i < 4; i++) {
            int newN = n + dy[i];
            int newM = m + dx[i];

            // 범위 안이고, 방문 안했으면
            if (1 <= newN && newN <= N && 1 <= newM && newM <= M && !visited[newN][newM] && arr[newN][newM] != 0) {
                recogniseIsland(newN, newM, depth + 1);
            }
        }

        if (depth == 0) {
            if (tempOfIsland.size() > 0) {
                islands.add(tempOfIsland);
                tempOfIsland = new ArrayList();
            }
        }
    }

    private static void makeBridge(int n, int m, int islandNumber, int direction, int length) {
        if (arr[n][m] != 0 && arr[n][m] != islandNumber) {
            if (length >= 2) {
                pq.offer(new Node(islandNumber, arr[n][m], length));
            }

            return;
        }

        int newN = n + dy[direction];
        int newM = m + dx[direction];

        if (!(1 <= newN && newN <= N && 1 <= newM && newM <= M)) {
            return;
        }

        if (arr[newN][newM] == islandNumber) {
            return;
        }

        makeBridge(newN, newM, islandNumber, direction, length + 1);
    }

    private static void kruskal() {
        parent = new int[islandNumber];

        for (int i = 1; i < islandNumber; i++) {
            parent[i] = i;
        }

        int result = 0;
        int bridge = 0;

        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();

            int parent1 = find(currentNode.startIslandNumber);
            int parent2 = find(currentNode.targetIslandNumber);

            if (parent1 != parent2) {
                union(parent1, parent2);

                result += currentNode.length;
                bridge += 1;
            }
        }

        if (result == 0) {
            return;
        }

        if (bridge != islandNumber - 2) {
            return;
        }

        answer = result;
    }

    private static int find(int nodeNumber) {
        if (parent[nodeNumber] == nodeNumber) {
            return nodeNumber;
        }
        else {
            return parent[nodeNumber] = find(parent[nodeNumber]);
        }
    }

    private static void union(int a, int b) {
        parent[a] = b;
    }
}