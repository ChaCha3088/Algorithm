import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static Set<Integer>[] temp;
    private static int[][] info;
    private static int count;
    private static int[] history;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]), M = Integer.parseInt(split[1]);

        temp = new Set[101];
        for (int t = 0; t <= 100; t++) {
            temp[t] = new HashSet<>();
        }

        Set<Integer> friends = new HashSet<>();

        for (int m = 1; m <= M; m++) {

            split = br.readLine().split(" ");

            int first = Integer.parseInt(split[0]);
            int second = Integer.parseInt(split[1]);

            temp[first].add(second);
            temp[second].add(first);

            friends.add(first);
            friends.add(second);
        }

        // info 배열 초기화
        info = new int[101][];

        for (int n = 0; n <= 100; n++) {
            info[n] = new int[temp[n].size() + 1];
        }

        for (int t = 0; t <= 100; t++) {
            List<Integer> collect = temp[t].stream()
                    .collect(Collectors.toList());

            for (int c = 0; c < collect.size(); c++) {
                info[t][c] = collect.get(c);
            }
        }

        int minValue = Integer.MAX_VALUE;
        int answer = -1;

        List<Integer> friendList = friends.stream()
                .collect(Collectors.toList());

        for (int friend : friendList) {
            // 기록 초기화
            count = 0;
            history = new int[101];

            bfs(friend);

            if (minValue > count) {
                minValue = count;
                answer = friend;
            }
        }

        System.out.println(answer);
    }

    private static void bfs(int start) {
        Deque<int[]> queue = new ArrayDeque<>();

        queue.offerLast(new int[] {start, 0});

        while (!queue.isEmpty()) {
            int[] polled = queue.pollFirst();
            int next = polled[0];
            int depth = polled[1];

            for (int i = 0; i < info[next].length; i++) {
                // 가본 적 없고, 시작점과 같지 않으면
                if (history[info[next][i]] == 0 && info[next][i] != start) {
                    // 방문 기록
                    history[info[next][i]] = depth + 1;

                    count += (depth + 1);

                    queue.offerLast(new int[]{info[next][i], depth + 1});
                }
            }
        }
    }
}