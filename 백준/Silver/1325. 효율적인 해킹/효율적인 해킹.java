import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

class Main {
    private static Map<Integer, Integer> map = new LinkedHashMap<>();
    private static List<Integer>[] arr = new List[10_001];
    private static boolean[] visited = new boolean[10_001];
    private static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 1; i < 10_001; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());

            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            arr[second].add(first);
        }

        for (int i = 1; i <= N; i++) {
            visited = new boolean[10_001];
            visited[i] = true;

            if (!arr[i].isEmpty()) {
                Deque<Integer> stack = new LinkedList<>();
                stack.offerLast(i);

                int result = 1;

                while (!stack.isEmpty()) {
                    int polled = stack.pollLast();

                    for (int e : arr[polled]) {
                        if (!visited[e]) {
                            result += 1;
                            visited[e] = true;
                            stack.offerLast(e);
                        }
                    }
                }

                map.put(i, result);
            }
        }

        // map의 value로 내림차순 정렬
        List<Map.Entry<Integer, Integer>> entries = new LinkedList<>(map.entrySet());
        Collections.sort(entries, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        List<Integer> answers = new LinkedList<>();
        int max = entries.get(0).getValue();

        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue() == max) {
                answers.add(entry.getKey());
            }
        }

        answers.sort(Integer::compareTo);

        answers.forEach(e -> sb.append(e).append(" "));

        System.out.println(sb);
    }
}