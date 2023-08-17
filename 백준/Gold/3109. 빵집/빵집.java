import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static char[][] map;
    private static int answer = 0;
    private static int R;
    private static int C;
    private static int[] dy = new int[] {-1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R + 1][];

        for (int r = 1; r <= R; r++) {
            map[r] = br.readLine().toCharArray();
        }

        for (int y = 1; y <= R; y++) {
            dfs(0, y);
        }

        System.out.println(answer);
    }

    private static boolean dfs(int x, int y) {
        if (x == C - 1) {
            answer += 1;
            return true;
        }

        // 가능한거에서
        for (int d = 0; d < 3; d++) {
            // 지도 범위 내 & 건물로 막혀있지 않을 것
            if (x + 1 > C - 1 || y + dy[d] > R || y + dy[d] < 1 || map[y + dy[d]][x + 1] != '.') {
                continue;
            }

            map[y][x] = 'x';

            // 탐색하고
            if (dfs(x + 1, y + dy[d])) {
                return true;
            }
        }

        return false;
    }
}