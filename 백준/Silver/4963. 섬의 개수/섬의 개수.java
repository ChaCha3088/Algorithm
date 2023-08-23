import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int W, H;
    private static int[][] map;
    private static boolean[][] visited;
    private static int answer;
    private static int[] dx = new int[] {0, 0, -1, 1, 1, 1, -1, -1};
    private static int[] dy = new int[] {1, -1, 0, 0, 1, -1, 1, -1};
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        while (!(W == 0 && H == 0)) {
            answer = 0;

            map = new int[H + 2][W + 2];
            visited = new boolean[H + 2][W + 2];

            for (int h = 1; h <= H; h++) {
                st = new StringTokenizer(br.readLine());

                for (int w = 1; w <= W; w++) {
                    map[h][w] = Integer.parseInt(st.nextToken());
                }
            }

            for (int h = 1; h <= H; h++) {
                for (int w = 1; w <= W; w++) {
                    if (!visited[h][w] && map[h][w] == 1) {
                        visited[h][w] = true;

                        answer += 1;

                        dfs(w, h, 0);
                    }
                }
            }

            sb.append(answer).append("\n");

            st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
        }

        System.out.println(sb);
    }

    private static void dfs(int x, int y, int depth) {
        int dep = depth;

        for (int i = 0; i < 8; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            // 맵 범위 안짝이고
            if (newX >= 1 && newX <= W && newY >= 1 && newY <= H) {
                // 방문한적 없고, 갈 수 있으면
                if (!visited[newY][newX] && map[newY][newX] == 1) {
                    visited[newY][newX] = true;

                    dfs(newX, newY, depth + 1);
                }
            }
        }
    }
}