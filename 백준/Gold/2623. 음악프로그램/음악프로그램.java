import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int N, M;
    private static int[] indegrees;
    private static List<List<Integer>> adjacentLists;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        indegrees = new int[N + 1];
        adjacentLists = new ArrayList();
        for (int i = 0; i <= N; i++) {
            adjacentLists.add(new ArrayList());
        }

        // 입력
        for (int m = 1; m <= M; m++) {
            st = new StringTokenizer(br.readLine());

            int howMany = Integer.parseInt(st.nextToken());
            int first = Integer.parseInt(st.nextToken());
            for (int i = 0; i < howMany - 1; i++) {
                int second = Integer.parseInt(st.nextToken());

                adjacentLists.get(first).add(second);
                indegrees[second] += 1;

                first = second;
            }
        }

        Queue<Integer> queue = new ArrayDeque();
        for (int i = 1; i <= N; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
                sb.append(i).append("\n");
            }
        }

        while (!queue.isEmpty()) {
            int polled = queue.poll();

            for (int i = 0; i < adjacentLists.get(polled).size(); i++) {
                int next = adjacentLists.get(polled).get(i);

                if (indegrees[next] == 1) {
                    indegrees[next] = 0;
                    queue.offer(next);
                    sb.append(next).append("\n");
                }
                else {
                    indegrees[next] -= 1;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (indegrees[i] > 0) {
                System.out.println(0);
                return;
            }
        }

        System.out.println(sb);
    }
}