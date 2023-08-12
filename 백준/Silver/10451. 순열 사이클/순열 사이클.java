import java.io.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int answer;
    private static int[] arr;
    private static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test = 1; test <= T; test++) {
            int N = Integer.parseInt(br.readLine());
            String[] split = br.readLine().split(" ");

            answer = 0;

            // 배열 초기화
            arr = new int[N + 1];
            visited = new int[N + 1];

            // 순열 입력
            for (int i = 0; i < split.length; i++) {
                arr[i + 1] = Integer.parseInt(split[i]);
            }

            for (int i = 1; i < arr.length; i++) {
                if (visited[arr[i]] == 0) {
                    bfs(arr[i], arr[i]);
                }
            }

            // 출력
            System.out.println(answer);
        }
    }

    private static void bfs(int currentPoint, int startPoint) {
        // 방문 기록을 남기고
        visited[currentPoint] += 1;

        // 계속 탐색
        int next = arr[currentPoint];

        // 방문 기록이 없으면
        if (visited[next] == 0) {
            // 탐색
            bfs(next, startPoint);
        }
        // 처음 시작했던 포인트에 방문 기록이 있고, 다시 돌아오면 끝
        else if (visited[currentPoint] != 0 && next == startPoint) {
            answer += 1;
            return;
        }
    }
}