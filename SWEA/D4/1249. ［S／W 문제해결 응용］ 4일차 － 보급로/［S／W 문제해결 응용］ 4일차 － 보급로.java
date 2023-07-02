import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;
 
public class Solution {
    private static int T, N;
    private static int[][] min;
    private static int[][] map;
    private static LinkedList<Integer> queue;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
 
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
 
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
 
 
        for (int i = 0; i < T; i++) {
            queue = new LinkedList<>();
 
            //입력
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
 
            map = new int[N + 1][N + 1];
 
            for (int j = 1; j <= N; j++) {
                st = new StringTokenizer(br.readLine());
                String[] split = st.nextToken().split("");
                for (int k = 1; k <= split.length; k++) {
                    map[j][k] = Integer.parseInt(split[k - 1]);
                }
            }
 
            min = new int[N + 1][N + 1];
 
            int[][] visited = new int[N + 1][N + 1];
            visited[1][1] = 1;
 
            sb.append("#" + (i + 1) + " ");
 
            int result = move(visited);
 
            sb.append(result).append("\n");
        }
 
        //출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
 
    private static int move(int[][] visited) {
        int result = Integer.MAX_VALUE;
 
        queue.clear();
        queue.offer(1);
        queue.offer(1);
 
        while (!queue.isEmpty()) {
            int x = queue.poll();
            int y = queue.poll();
 
            if (x == N && y == N) {
                result = Math.min(result, min[x][y]);
            }
 
            if (result <= min[x][y]) continue;
 
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
 
                if (nx < 1 || ny < 1 || nx > N || ny > N) continue;
 
                // 방문 안 했거나, 방문했더라도 최소 비용 갱신이 가능하다면
                if (visited[nx][ny] == 0 || min[nx][ny] > min[x][y] + map[nx][ny]) {
 
                    //최소값 갱신
                    min[nx][ny] = min[x][y] + map[nx][ny];
 
                    // 방문처리 및 새로운 정점 큐에 넣기
                    visited[nx][ny] = 1;
                    queue.offer(nx);
                    queue.offer(ny);
                }
            }
        }
 
        return result;
    }
}