import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int[][] info;
    private static boolean[] visited;
    private static int answer = -1;
    private static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        info = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int first = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());
        for (int m = 1; m <= M; m++) {
            st = new StringTokenizer(br.readLine());

            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());

            info[parent][child] = 1;
            info[child][parent] = 2;
        }

        explore(first, 0, second);

        System.out.println(answer);
    }

    private static boolean explore(int current, int depth, int target) {
        if (current == target) {
            answer = depth;
            return true;
        }

        visited[current] = true;

        boolean result = false;

        // 자식 탐색
        for (int i = 1; i <= N; i++) {
            // 자식이고, 방문하지 않았다면
            if (info[current][i] == 1 && !visited[i]) {
                result = explore(i, depth + 1, target);

                if (result) {
                    return true;
                }
            }
        }

        // 자식에 없으면
        // 부모 탐색
        for (int i = 1; i <= N; i++) {
            // 부모이고, 방문하지 않았다면
            if (info[current][i] == 2 && !visited[i]) {
                result = explore(i, depth + 1, target);

                if (result) {
                    return true;
                }
            }
        }

        return false;
    }
}