import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        arr = new int[101];
        for (int i = 1; i <= 100; i++) {
            arr[i] = i;
        }

        // 정보 입력
        for (int i = 0; i < N + M; i++) {
            s = br.readLine().split(" ");
            arr[Integer.parseInt(s[0])] = Integer.parseInt(s[1]);
        }

        int result = bfs(1);
        System.out.println(result);
    }

    private static int bfs(int start) {
        int[] visited = new int[101];
        visited[start] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while (true) {
            int poll = queue.poll();

            for (int i = 1; i <= 6; i++) {
                int newNode = poll + i;

                // 범위 벗어나면 스킵
                if (newNode > 100) {
                    continue;
                }

                // 아직 방문하지 않았으면
                if (visited[arr[newNode]] == 0) {
                    queue.offer(arr[newNode]);
                    visited[arr[newNode]] = visited[poll] + 1;
                }

                if (arr[newNode] == 100) {
                    return visited[100];
                }
            }
        }
    }
}