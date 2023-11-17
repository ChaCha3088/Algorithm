import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N, M;
    private static int[][] map, virusMap;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {1, -1, 0, 0};
    private static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        // 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int input = Integer.parseInt(st.nextToken());
                if (input != 0) {
                    map[i][j] = input;
                }
            }
        }

        dfs(0);

        System.out.println(answer);
    }

    private static void dfs(int wallCount) {
        if (wallCount == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(wallCount + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static void bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        virusMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                virusMap[i][j] = map[i][j];
                if (virusMap[i][j] == 2) {
                    queue.offer(new int[] {i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] polled = queue.poll();
            int r = polled[0];
            int c = polled[1];

            for (int i = 0; i < 4; i++) {
                int newR = r + dy[i];
                int newC = c + dx[i];

                if (0 <= newR && newR < N && 0 <= newC && newC < M && virusMap[newR][newC] == 0) {
                    virusMap[newR][newC] = 2;
                    queue.offer(new int[] {newR, newC});
                }
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (virusMap[i][j] == 0) {
                    count++;
                }
            }
        }

        answer = Math.max(answer, count);
    }
}