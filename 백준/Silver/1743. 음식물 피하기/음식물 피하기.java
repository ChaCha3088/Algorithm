import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N, M, K, answer, count;
    private static boolean[][] map, visited;
    private static int[] dx = {0, 0, -1, 1}; // 상하좌우
    private static int[] dy = {1, -1, 0, 0}; // 상하좌우

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        answer = 0;

        map = new boolean[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[r][c] = true;
        }

        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= M; c++) {
                // 방문하지 않았고, 음식물이 있으면
                if (!visited[r][c] && map[r][c]) {
                    // bfs
                    bfs(r, c);
                }
            }
        }

        System.out.println(answer);
    }

    private static void bfs(int r, int c) {
        Queue<int[]> queue = new ArrayDeque();
        queue.offer(new int[] {r, c});
        visited[r][c] = true;
        count = 1;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int newR = poll[0] + dy[i];
                int newC = poll[1] + dx[i];

                // 범위를 벗어나면
                if (newR < 1 || newR > N || newC < 1 || newC > M) {
                    continue;
                }

                // 아직 방문하지 않았고, 음식물이 있으면
                if (!visited[newR][newC] && map[newR][newC]) {
                    // 방문 체크
                    visited[newR][newC] = true;
                    count++;

                    // queue에 넣기
                    queue.offer(new int[] {newR, newC});
                }
            }
        }

        // count의 최댓값을 구한다.
        answer = Math.max(answer, count);
    }
}