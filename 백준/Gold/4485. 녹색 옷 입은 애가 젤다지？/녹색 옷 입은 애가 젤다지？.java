import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node {// 다음 노드의 인덱스와, 그 노드로 가는데 필요한 비용을 담고 있다.
        private int x;
        private int y;
        private int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    private static StringBuilder sb = new StringBuilder();
    private static int[][] arr;
    private static int[][] dp;
    private static int N;
    private static int answer = -1;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = 1;
        while (true) {
            N = Integer.parseInt(br.readLine());

            if (N == 0) {
                break;
            }

            // 배열 초기화
            arr = new int[N][N];
            dp = new int[N][N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(dp[i], 99999999);
            }

            // 입력
            for (int n = 0; n < N; n++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int m = 0; m < N; m++) {
                    arr[n][m] = Integer.parseInt(st.nextToken());
                }
            }

            // 알고리즘
            dijkstra();

            answer = dp[N - 1][N - 1];

            // 출력
            sb.append("Problem ").append(T).append(": ").append(answer).append("\n");

            T += 1;
        }

        System.out.println(sb);
    }

    private static void dijkstra() {
        Queue<Node> queue = new PriorityQueue<Node>(Comparator.comparingInt(o -> o.cost));
        queue.offer(new Node(0, 0, arr[0][0]));

        while (!queue.isEmpty()) {
            Node polled = queue.poll();

            // 현재 위치에서 상하좌우 확인
            for (int i = 0; i < 4; i++) {
                int newX = polled.x + dx[i];
                int newY = polled.y + dy[i];

                // 맵을 벗어나는 경우 건너뛰기
                if (newX >= N || newX < 0 || newY >= N || newY < 0) {
                    continue;
                }

                // 현재 위치까지의 비용 + 한 칸 이동한 비용
                int newCost = (polled.cost + arr[newX][newY]);

                // 최소 비용에 등록된 값보다 작을 경우
                if(dp[newX][newY] > newCost ) {
                    // 갱신하고
                    dp[newX][newY] = newCost;

                    // 우선순위 큐에 현재 위치와 비용을 노드로 넣기
                    queue.offer(new Node(newX, newY, newCost));
                }
            }
        }
    }
}