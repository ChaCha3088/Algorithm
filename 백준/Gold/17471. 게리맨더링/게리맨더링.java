import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[] combinationNumbers;
    private static String[] combinations;
    private static int combinationIndex;
    private static boolean[] visited;
    private static int[] numberOfPeople;
    private static boolean[][] info;
    private static int N;
    private static int answer;

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        numberOfPeople = new int[N + 1];
        info = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];
        combinations = new String[(int) Math.pow(2, N) - 1];
        for (int i = 0; i < (int) Math.pow(2, N) - 1; i++) {
            combinations[i] = "";
        }
        combinationIndex = 0;
        combinationNumbers = new int[N];
        answer = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());
        for (int n = 1; n <= N; n++) {
            numberOfPeople[n] = Integer.parseInt(st.nextToken());
        }

        for (int n = 1; n <= N; n++) {
            st = new StringTokenizer(br.readLine());

            int howMany = Integer.parseInt(st.nextToken());
            for (int h = 1; h <= howMany; h++) {
                info[n][Integer.parseInt(st.nextToken())] = true;
            }
        }

        // 조합 구하기
        for (int i = 1; i <= N; i++) {
            combinationNumbers[i - 1] = i;
        }

        for (int i = 1; i < (1 << N); i++) {
            for (int k = 0; k < N; k++) {
                if ((i & (1 << k)) > 0) {
                    combinations[combinationIndex] += (combinationNumbers[k] + " ");
                }
            }
            combinationIndex += 1;
        }

        for (int i = 0; i < (int) Math.pow(2, N) - 2; i++) {
            st = new StringTokenizer(combinations[i]);

            int summation = 0;

            // 위치 기록
            while (st.hasMoreTokens()) {
                int whereToVisit = Integer.parseInt(st.nextToken());
                visited[whereToVisit] = true;
                summation += numberOfPeople[whereToVisit];
            }

            // 지들끼리 연결돼있는지 확인
            boolean needToValidate = isConnected(i);

            // 나머지 검증
            if (needToValidate) {
                // 방문 안한거 찾고
                int notVisitedVillage = -1;
                for (int v = 1; v <= N; v++) {
                    if (!visited[v]) {
                        notVisitedVillage = v;
                        break;
                    }
                }

                boolean[] newVisited = new boolean[N + 1];
                System.arraycopy(visited, 0, newVisited, 0, visited.length);
                int result = bfs(notVisitedVillage, newVisited);

                if (result != -1) {
                    int diff = Math.abs(summation - result);

                    if (diff < answer) {
                        answer = diff;
                    }
                }
            }

            // 위치 기록 삭제
            st = new StringTokenizer(combinations[i]);
            while (st.hasMoreTokens()) {
                int whereToVisit = Integer.parseInt(st.nextToken());
                visited[whereToVisit] = false;
            }
        }

        if (answer == Integer.MAX_VALUE) {
            answer = -1;
        }

        System.out.println(answer);
    }

    private static boolean isConnected(int combinationIndex) {
        StringTokenizer st = new StringTokenizer(combinations[combinationIndex]);

        boolean[] visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            visited[i] = true;
        }

        List<Integer> list = new ArrayList<>();
        while (st.hasMoreElements()) {
            int village = Integer.parseInt(st.nextToken());
            visited[village] = false;
            list.add(village);
        }

        bfs(list.get(0), visited);

        for (int i = 0; i < list.size(); i++) {
            if (!visited[list.get(i)]) {
                return false;
            }
        }

        return true;
    }

    private static int bfs(int startVillage, boolean[] visited) {
        Deque<Integer> queue = new ArrayDeque<>();

        queue.offerLast(startVillage);
        visited[startVillage] = true;

        int sum = 0;

        while (!queue.isEmpty()) {
            int polled = queue.pollFirst();
            sum += numberOfPeople[polled];

            for (int i = 1; i <= N; i++) {
                if (info[polled][i] && !visited[i]) {
                    visited[i] = true;
                    queue.offerLast(i);
                }
            }
        }

        // 다 돌았는데도 방문하지 않은 곳이 있으면 불가능하다는 뜻
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                return -1;
            }
        }

        // 가능하면
        return sum;
    }
}