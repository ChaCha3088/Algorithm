import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    private static int answer = 0;
    private static List<Integer>[] arr = new List[1_001];
    private static boolean[] visited = new boolean[1_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 1; i < 1_001; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());

            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            arr[first].add(second);
            arr[second].add(first);
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                if (!arr[i].isEmpty()) {
                    visited[i] = true;
                    dfs(i);
                    answer += 1;
                }
                else {
                    visited[i] = true;
                    answer += 1;
                }
            }
        }

        System.out.println(answer);
    }

    private static void dfs(int input) {
        Deque<Integer> stack = new LinkedList<>();
        stack.offerLast(input);

        while (!stack.isEmpty()) {
            int polled = stack.pollLast();

            for (int e : arr[polled]) {
                if (!visited[e]) {
                    visited[e] = true;
                    stack.offerLast(e);
                }
            }
        }
    }
}