import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static boolean[][] map;
    private static boolean[][] visited;
    private static int pics = 0;
    private static int maxArea = 0;

    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {1, -1, 0, 0};

    // 목표: 어떤 큰 도화지에 그림이 그려져 있을 때, 그 그림의 개수와, 그 그림 중 넓이가 가장 넓은 것의 넓이를 출력
    // 그림: 1로 연결된 것을 한 그림: 가로나 세로로 연결된 것
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력
        // 첫째 줄에 도화지의 세로 크기 n(1 ≤ n ≤ 500)과 가로 크기 m(1 ≤ m ≤ 500)
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new boolean[N][M];
        visited = new boolean[N][M];

        // 두 번째 줄부터 n+1 줄 까지 그림의 정보
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());

            for (int m = 0; m < M; m++) {
                String input = st.nextToken();

                if (input.equals("1")) {
                    map[n][m] = true;
                }
            }
        }

        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                if (!visited[n][m] && map[n][m]) {
                    visited[n][m] = true;
                    pics += 1;
                    bfs(new int[] {n, m, 1});
                }
            }
        }

        System.out.println(pics);
        System.out.println(maxArea);
    }

    private static void bfs(int[] start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        int area = 0;

        while (!queue.isEmpty()) {
            int[] polled = queue.poll();
            int y = polled[0];
            int x = polled[1];
            area += 1;

            for (int i = 0; i < 4; i++) {
                int newY = y + dy[i];
                int newX = x + dx[i];

                if (newX < 0 || newX >= M || newY < 0 || newY >= N) {
                    continue;
                }

                if (!map[newY][newX]) {
                    continue;
                }

                if (visited[newY][newX]) {
                    continue;
                }

                visited[newY][newX] = true;

                queue.offer(new int[] {newY, newX});
            }
        }

        // 최대값 업데이트
        if (maxArea < area) {
            maxArea = area;
        }
    }
}