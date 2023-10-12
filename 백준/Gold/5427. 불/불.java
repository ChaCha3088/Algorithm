import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int T, W, H, r, c;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {1, -1, 0, 0};
    private static Queue<int[]> fireList;
    private static int time;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            map = new int[H][W];
            visited = new boolean[H][W];
            fireList = new ArrayDeque<>();
            time = 0;

            // 입력
            for (int h = 0; h < H; h++) {
                String string = br.readLine();

                for (int w = 0; w < W; w++) {
                    char character = string.charAt(w);

                    if (character == '.') {
                        map[h][w] = 1;
                    }
                    else if (character == '@') {
                        r = h;
                        c = w;
                        map[h][w] = 1;
                    }
                    else if (character == '*') {
                        map[h][w] = 2;
                        fireList.offer(new int[] {h, w, 0});
                    }
                }
            }

            int result = bfs();

            if (result >= 0) {
                sb.append(result).append("\n");
            }
            else {
                sb.append("IMPOSSIBLE").append("\n");
            }
        }

        System.out.println(sb);
    }

    private static int bfs() {
        Queue<int[]> queue = new ArrayDeque();
        queue.offer(new int[] {r, c, 0});

        int status = -1;
        while (!queue.isEmpty()) {
            int[] polled = queue.poll();

            if (polled[2] > status) {
                spread();
                status += 1;
                time += 1;
            }

            for (int i = 0; i < 4; i++) {
                int newR = polled[0] + dy[i];
                int newC = polled[1] + dx[i];

                if (newR < 0 || newR >= H || newC < 0 || newC >= W) {
                    return polled[2] + 1;
                }

                // 불이 있거나, 벽이 있으면
                if (map[newR][newC] == 0 || map[newR][newC] == 2) {
                    continue;
                }

                if (!visited[newR][newC]) {
                    visited[newR][newC] = true;
                    queue.offer(new int[]{newR, newC, polled[2] + 1});
                }
            }
        }

        return -1;
    }

    private static void spread() {
        // fireList가 들어있고, 현재 시간과 같을 때
        while (!fireList.isEmpty() && fireList.peek()[2] == time) {
            int[] target = fireList.poll();

            for (int i = 0; i < 4; i++) {
                int newR = target[0] + dy[i];
                int newC = target[1] + dx[i];

                if (newR < 0 || newR >= H || newC < 0 || newC >= W || map[newR][newC] == 0 || map[newR][newC] == 2) {
                    continue;
                }

                map[newR][newC] = 2;
                fireList.offer(new int[] {newR, newC, time + 1});
            }
        }
    }
}