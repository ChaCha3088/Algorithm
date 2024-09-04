import java.util.*;

class Solution {
    private List<Integer>[] info;
    private int answer = Integer.MAX_VALUE;
    private boolean[] visited;
    
    public int solution(int n, int[][] wires) {
        if (n == 2) {
            return 0;
        }
        
        info = new List[101];
        for (int i = 0; i <= 100; i++) {
            info[i] = new ArrayList<>();
        }

        for (int i = 0; i < wires.length; i++) {
            int[] element = wires[i];

            info[element[0]].add(element[1]);
            info[element[1]].add(element[0]);
        }

        for (int i = 0; i < wires.length; i++) {
            int[] element = wires[i];

            info[element[0]].removeIf(e -> e == element[1]);
            info[element[1]].removeIf(e -> e == element[0]);

            visited = new boolean[101];

            List<Integer> results = new ArrayList<>();

            for (int j = 1; j < info.length; j++) {
                // 끝 노드일 때 탐색
                if (info[j].size() == 1 && !visited[j]) {
                    visited[j] = true;

                    int result = dfs(j);
                    results.add(result);
                }
            }

            if (results.size() == 2) {
                int diff = results.get(0) - results.get(1);
                diff = Math.abs(diff);

                if (diff < answer) {
                    answer = diff;
                }
            }
            else if (results.size() == 1) {
                int diff = results.get(0);
                diff = Math.abs(diff);

                if (diff < answer) {
                    answer = diff;
                }
            }

            // 선 복구
            info[element[0]].add(element[1]);
            info[element[1]].add(element[0]);
        }

        return answer;
    }
    
    private int dfs(int i) {
        int depth = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.offerLast(i);

        while (!stack.isEmpty()) {
            int polled = stack.pollLast();

            for (int j = 0; j < info[polled].size(); j++) {
                if (!visited[info[polled].get(j)]) {
                    depth += 1;
                    visited[info[polled].get(j)] = true;
                    stack.offerLast(info[polled].get(j));
                }
            }
        }

        return depth;
    }
}