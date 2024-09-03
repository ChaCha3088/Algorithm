import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N;
    private static boolean[][] map;
    private static boolean[][] visited;
    private static List<Integer> answers = new ArrayList<>();
    private static int[] dx = {0, 0, -1 , 1};
    private static int[] dy = {1, -1 , 0, 0};
    private static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new boolean[N][N];
        visited = new boolean[N][N];
        
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");

            for (int j = 0; j < N; j++) {
                if (Integer.parseInt(split[j]) == 1) {
                    map[i][j] = true;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] && !visited[i][j]) {
                    dfs(new int[] {i, j});
                }
            }
        }
        
        // 총 단지수
        sb.append(answers.size()).append("\n");
        
        // 단지내 집 수를 오름차순 정렬
        Collections.sort(answers);

        answers.forEach(e -> sb.append(e).append("\n"));

        System.out.println(sb);
    }
    
    private static void dfs(int[] input) {
        Deque<int[]> stack = new ArrayDeque<>();
        stack.offerLast(input);
        visited[input[0]][input[1]] = true;
        
        int count = 0;
        
        while (!stack.isEmpty()) {
            int[] polled = stack.pollLast();
            count += 1;
            
            for (int i = 0; i < 4; i++) {
                int newY = polled[0] + dy[i];
                int newX = polled[1] + dx[i];
                
                // 범위 밖이면 꺼져
                if (0 > newY || newY >= N || 0 > newX || newX >= N) {
                    continue;
                }

                // 방문 했었거나, 집이 없으면
                if (visited[newY][newX] || !map[newY][newX]) {
                    continue;
                }

                visited[newY][newX] = true;
                stack.offerLast(new int[] {newY, newX});
            }
        }

        answers.add(count);
    }
}