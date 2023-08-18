import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Clazz {
    int x;
    int y;
    int depth;

    public Clazz(int x, int y, int depth) {
        this.x = x;
        this.y = y;
        this.depth = depth;
    }
}

public class Main {
    private static int N;
    private static int M;
    private static boolean[][] arr;
    private static boolean[][] visited;
    private static int[] dx = new int[] {0, 0, -1, 1};
    private static int[] dy = new int[] {1, -1, 0, 0};
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N  = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 초기화
        arr = new boolean[N + 2][M + 2];
        visited = new boolean[N + 2][M + 2];

        // 입력
        for (int i = 1; i <= N; i++) {
            String string = br.readLine();

            for (int j = 1; j <= string.length(); j++) {
                if (string.charAt(j - 1) == '1') {
                    arr[i][j] = true;
                }
            }
        }

        int result = bfs();
        System.out.println(result);
    }

    private static int bfs() {
        Deque<Clazz> queue = new ArrayDeque();
        visited[1][1] = true;
        queue.offerLast(new Clazz(1, 1, 0));

        while (!queue.isEmpty()) {
            Clazz polled = queue.pollFirst();

            if (polled.x == M && polled.y == N) {
                return polled.depth + 1;
            }

            for (int i = 0; i < 4; i++) {
                // 범위 안이고, 방문한적이 없으면
                if (polled.x + dx[i] >= 1 && polled.x + dx[i] <= M && polled.y + dy[i] >= 1 && polled.y + dy[i] <= N && arr[polled.y + dy[i]][polled.x + dx[i]] == true && visited[polled.y + dy[i]][polled.x + dx[i]] == false) {
                    visited[polled.y + dy[i]][polled.x + dx[i]] = true;
                    queue.offerLast(new Clazz(polled.x + dx[i], polled.y + dy[i], polled.depth + 1));
                }
            }
        }

        return -1;
    }
}