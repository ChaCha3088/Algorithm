import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static Boolean[][] map;
    private static boolean[][] visited;

    private static int totalTargetTomatoes = 0;
    private static int rippedTomatoes = 0;
    private static int lastRippedTomatoes = 0;

    private static int days = 0;

    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {1, -1, 0, 0};

    // 목표: 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지, 그 최소 일수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new Boolean[N][M];
        visited = new boolean[N][M];

        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
                int input = Integer.parseInt(st.nextToken());

                if (input == -1) {
                    map[n][m] = null;
                    visited[n][m] = true;
                }
                else if (input == 0) {
                    map[n][m] = false;
                    totalTargetTomatoes += 1;
                }
                else if (input == 1) {
                    map[n][m] = true;
                    visited[n][m] = true;
                    totalTargetTomatoes += 1;
                    rippedTomatoes += 1;
                }
            }
        }

        // 저장될 때부터 모든 토마토가 익어있는 상태
        if (rippedTomatoes == totalTargetTomatoes) {
            System.out.println(0);
            return;
        }

        lastRippedTomatoes = rippedTomatoes;

        // 익힌다.
        boolean result = ripe();

        if (result) {
            System.out.println(days);
        }
        else {
            System.out.println(-1);
        }
    }

    private static boolean ripe() {
        Queue<int[]> queue = new LinkedList<>();

        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                // 이미 익어있는 애들
                if (map[n][m] != null && map[n][m]) {
                    queue.offer(new int[] {n, m, 0});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] polled = queue.poll();
            int y = polled[0];
            int x = polled[1];
            int day = polled[2];

            // day가 처음으로 증가할 때
            if (day > days) {
                days = day;

                // 익혔는데도 전과 수가 같으면 실패야
                if (rippedTomatoes == lastRippedTomatoes) {
                    return false;
                }

                lastRippedTomatoes = rippedTomatoes;
            }

            for (int i = 0; i < 4; i++) {
                int newY = y + dy[i];
                int newX = x + dx[i];

                // 범위 바깥이면
                if (newY < 0 || newY >= N || newX < 0 || newX >= M) {
                    continue;
                }

                // 이미 방문했으면
                if (visited[newY][newX]) {
                    continue;
                }

                // 비어있는 곳이면
                if (map[newY][newX] == null) {
                    continue;
                }

                // 아직 안익었으면
                if (map[newY][newX].equals(false)) {
                    rippedTomatoes += 1;
                    map[newY][newX] = true;
                    visited[newY][newX] = true;

                    queue.offer(new int[] {newY, newX, day + 1});
                }
            }
        }

        // 익혔는데도 전과 수가 같으면 실패야
        if (totalTargetTomatoes == rippedTomatoes && rippedTomatoes == lastRippedTomatoes) {
            return true;
        }

        return false;
    }
}