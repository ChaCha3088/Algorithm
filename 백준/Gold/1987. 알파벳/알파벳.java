import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int R, C;
    private static int[][] arr;
    private static boolean[] visited = new boolean['Z' - 'A' + 1];
    private static int answer = Integer.MIN_VALUE;
    
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        // 초기화
        arr = new int[R][C];

        // 입력
        for (int r = 0; r < R; r++) {
            String line = br.readLine();
            
            for (int c = 0; c < C; c++) {
                arr[r][c] = line.charAt(c) - 'A';
            }
        }
        
        // 기록 남겨
        visited[arr[0][0]] = true;
        
        // 탐색
        dfs(0, 0, 1);

        System.out.println(answer);
    }
    
    private static void dfs(int y, int x, int depth) {
        // 최고 기록 기록하자~
        if (depth > answer) {
            answer = depth;
        }
        
        for (int i = 0; i < 4; i++) {
            int newY = y + dy[i];
            int newX = x + dx[i];

            // 범위 밖에 나가면
            if (newY < 0 || newY >= R || newX < 0 || newX >= C) {
                // 꺼져
                continue;
            }

            // 이미 글자를 사용했으면
            if (visited[arr[newY][newX]]) {
                // 꺼져
                continue;
            }
            
            // 글자 방문 기록하고
            visited[arr[newY][newX]] = true;

            // 다음 탐색
            dfs(newY, newX, depth + 1);

            // 탐색하고 오면, 기록 해제
            visited[arr[newY][newX]] = false;
        }
    }
}