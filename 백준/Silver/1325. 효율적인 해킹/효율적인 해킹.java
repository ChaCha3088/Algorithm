import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;


public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static List<List<Integer>> list = new ArrayList();;
    private static boolean[] visited;
    private static int max;
    private static int count;
    private static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList());
        }

        // 입력
        for (int m = 1; m <= M; m++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            list.get(B).add(A);
        }

        max = Integer.MIN_VALUE;

        int[] result = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            count = 0;
            bfs(i);
            result[i] = count;
            max = Math.max(count, max);
        }

        for (int i = 1; i <= N; i++) {
            if (result[i] == max) {
                sb.append(i + " ");
            }
        }

        System.out.println(sb);
    }

    private static void bfs(int index) {
        Queue<Integer> queue = new LinkedList();
        queue.add(index);
        visited[index] = true;

        while (!queue.isEmpty()) {
            int poll = queue.poll();

            for (int i : list.get(poll)) {
                // 방문 안했으면
                if (!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    count += 1;
                }
            }
        }
    }
}