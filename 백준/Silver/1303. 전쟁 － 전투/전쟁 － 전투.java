import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N, M, mine, enemy, temp;
    private static boolean[][] map, visited;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        mine = 0;
        enemy = 0;

        map = new boolean[M][N];
        visited = new boolean[M][N];

        // 입력
        for (int m = 0; m < M; m++) {
            String line = br.readLine();
            for (int n = 0; n < N; n++) {
                char c = line.charAt(n);
                if (c == 'W') {
                    map[m][n] = true;
                }
            }
        }

        // 순환하면서
        for (int m = 0; m < M; m++) {
            for (int n = 0; n < N; n++) {
                // 방문 안했으면
                if (!visited[m][n]) {
                    // temp 초기화하고
                    temp = 0;

                    // 방문 기록 남기고
                    visited[m][n] = true;

                    // DFS 시작
                    dfs(m, n);

                    // 다 방문했으면

                    // 우리 병사들이면
                    if (map[m][n]) {
                        // 우리 팀에 위력을 더해주고
                        mine += Math.pow(temp, 2);
                    }
                    // 적국 병사들이면
                    else {
                        // 적국 팀에 위력를 더해준다.
                        enemy += Math.pow(temp, 2);
                    }
                }
            }
        }

        // 모두 방문했으니까
        // 정답 출력
        System.out.println(mine + " " + enemy);
    }

    private static void dfs(int y, int x) {
        // 카운트
        temp += 1;

        // 상하좌우
        for (int i = 0; i < 4; i++) {
            int newY = y + dy[i];
            int newX = x + dx[i];

            // 범위 밖이거나, 이미 방문했거나, 적국 병사이면
            if (newY >= M || newY < 0 || newX >= N || newX < 0 || visited[newY][newX] || map[newY][newX] != map[y][x]) {
                // 넘어가
                continue;
            }

            // 통과했으니까
            // 방문 기록 남기고
            visited[newY][newX] = true;

            // 탐색
            dfs(newY, newX);
        }
    }
}