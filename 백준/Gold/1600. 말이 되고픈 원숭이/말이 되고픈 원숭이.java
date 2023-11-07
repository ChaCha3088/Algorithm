import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static boolean[][] map;
    // 능력이 남은 횟수
    private static int[][][] visited;
    private static int K, W, H;
    private static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1, 0, 0, -1, 1};
    private static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2, 1, -1, 0, 0};
    static class Coordinate {
        public int r;
        public int c;
        public int distance;
        public int k;

        public Coordinate(int r, int c, int distance, int k) {
            this.r = r;
            this.c = c;
            this.distance = distance;
            this.k = k;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        if (W == 1 && H == 1) {
            System.out.println(0);
            return;
        }

        visited = new int[H + 1][W + 1][2];
        for (int h = 1; h <= H; h++) {
            for (int w = 1; w <= W; w++) {
                Arrays.fill(visited[h][w], -1);
            }
        }

        // 지도 입력
        map = new boolean[H + 1][W + 1];
        for (int h = 1; h <= H; h++) {
            st = new StringTokenizer(br.readLine());

            for (int w = 1; w <= W; w++) {
                if (st.nextToken().equals("0")) {
                    map[h][w] = true;
                }
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        int i, newK, isHorse, newDistance;

        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(1, 1, 0, K));
        visited[1][1][0] = K;
        visited[1][1][1] = K;

        while (!queue.isEmpty()) {
            Coordinate polled = queue.poll();

            // 도착하면
            if (polled.r == H && polled.c == W) {
                // 끝내버려
                return polled.distance;
            }

            i = 0;
            // 능력이 없으면
            if (polled.k == 0) {
                // 능력 내리기
                i = 8;
            }

            for (int j = i; j < 12; j++) {
                int newR = polled.r + dy[j];
                int newC = polled.c + dx[j];

                // 능력 설정
                newK = polled.k;
                isHorse = 0;
                if (j < 8) {
                    newK = polled.k - 1;
                    isHorse = 1;
                }

                // 갈 수 없는 곳 쳐내
                if (newR < 1 || newR > H || newC < 1 || newC > W || !map[newR][newC]) {
                    continue;
                }

                newDistance = polled.distance + 1;

                // 방문하지 않았거나 || 남은 능력이 더 많이 남아있으면
                if (visited[newR][newC][isHorse] == -1 || newK > visited[newR][newC][isHorse]) {
                    queue.offer(new Coordinate(newR, newC, newDistance, newK));
                    visited[newR][newC][isHorse] = newK;
                }
            }
        }

        return -1;
    }
}