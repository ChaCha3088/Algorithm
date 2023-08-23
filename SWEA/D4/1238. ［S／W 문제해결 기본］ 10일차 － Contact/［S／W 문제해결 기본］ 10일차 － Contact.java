import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    private static boolean[] visited;
    private static int E;
    private static List[] arr;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 가장 나중에 연락을 받게 되는 사람 중 번호가 가장 큰 사람을 구하는 함수

        for (int t = 1; t <= 10; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            E = N / 2;
            int start = Integer.parseInt(st.nextToken());

            arr = new List[101];
            visited = new boolean[101];

            for (int i = 1; i <= 100; i++) {
                arr[i] = new ArrayList();
            }

            st = new StringTokenizer(br.readLine());
            for (int n = 0; n < E; n++) {
                arr[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
            }

            visited[start] = true;
            int result = bfs(start);

            sb.append("#").append(t).append(" ").append(result).append("\n");
        }

        System.out.println(sb);
    }

    private static int bfs(int start) {
        int maxDepth = 0;
        Queue<Integer> results = new PriorityQueue<>((o1, o2) -> o2 - o1);

        Deque<int[]> queue = new ArrayDeque();

        queue.offerLast(new int[] {start, 0});

        while (!queue.isEmpty()) {
            int[] polled = queue.pollFirst();

            for (int i = 0; i < arr[polled[0]].size(); i++) {
                // 방문 아직 안했으면
                if (!visited[(int) arr[polled[0]].get(i)]) {
                    // 방문 기록 남기고
                    visited[(int) arr[polled[0]].get(i)] = true;

                    // 최대 깊이 업데이트
                    if (polled[1] > maxDepth) {
                        maxDepth = polled[1];

                        // 결과 기록 초기화
                        results.clear();
                    }

                    // 결과 기록
                    results.add((int) arr[polled[0]].get(i));

                    // 큐에 추가
                    queue.offerLast(new int[]{(int) arr[polled[0]].get(i), polled[1] + 1});
                }
            }
        }

        return results.poll();
    }
}