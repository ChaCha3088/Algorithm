import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int R, C, startR, startC;
    private static Integer[][] fires;
    private static boolean[][] visited;

    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {1, -1, 0, 0};

    // 목표: 지훈이가 불에 타기전에 탈출할 수 있는지의 여부, 그리고 얼마나 빨리 탈출할 수 있는지를 결정
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        visited = new boolean[R][C];
        fires = new Integer[R][C];
        Queue<int[]> f = new LinkedList<>();

        for (int r = 0; r < R; r++) {
            String line = br.readLine();
            String[] lines = line.split("");

            for (int c = 0; c < C; c++) {
                String input = lines[c];

                if (input.equals(".")) {
                    fires[r][c] = 0;
                }
                else if (input.equals("#")) {
                    visited[r][c] = true;
                }
                else if (input.equals("J")) {
                    visited[r][c] = true;
                    fires[r][c] = 0;
                    startR = r;
                    startC = c;
                }
                else if (input.equals("F")) {
                    visited[r][c] = true;
                    fires[r][c] = 1;
                    f.offer(new int[] {r, c});
                }
            }
        }

        Queue<int[]> q = new LinkedList<>();

        while (!f.isEmpty()) {
            int[] polled = f.poll();

            q.offer(new int[] {polled[0], polled[1], 1, 1});
        }

        q.offer(new int[] {startR, startC, 1, 0});

        while (!q.isEmpty()) {
            int[] polled = q.poll();

            int r = polled[0];
            int c = polled[1];
            int time = polled[2];
            int isFire = polled[3];

            for (int i = 0; i < 4; i++) {
                int newR = r + dy[i];
                int newC = c + dx[i];

                if (isFire == 0) {
                    if (newR < 0 || newR >= R || newC < 0 || newC >= C) {
                        System.out.println(time);
                        return;
                    }

                    // 이미 방문 했으면
                    if (visited[newR][newC]) {
                        continue;
                    }

                    // 벽이면
                    if (fires[newR][newC] == null) {
                        continue;
                    }

                    // 이미 불타고 있으면
                    if (fires[newR][newC] >= time) {
                        continue;
                    }

                    visited[newR][newC] = true;
                    q.offer(new int[] {newR, newC, time + 1, isFire});
                }
                else if (isFire == 1) {
                    if (newR < 0 || newR >= R || newC < 0 || newC >= C) {
                        continue;
                    }

                    // 벽이면
                    if (fires[newR][newC] == null) {
                        continue;
                    }

                    // 이미 불타고 있으면
                    if (fires[newR][newC] >= 1) {
                        continue;
                    }

                    fires[newR][newC] = time + 1;
                    q.offer(new int[] {newR, newC, time + 1, isFire});
                }

            }
        }

        System.out.println("IMPOSSIBLE");
    }
}