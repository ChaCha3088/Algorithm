import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {
    private static int T, N, min;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    private static int[] visited;
    private static int[][] coordinate;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            min = Integer.MAX_VALUE;
            coordinate = new int[N + 2][2];
            visited = new int[N + 1];

            st = new StringTokenizer(br.readLine());

            //회사 좌표
            coordinate[0][0] = Integer.parseInt(st.nextToken());
            coordinate[0][1] = Integer.parseInt(st.nextToken());

            //집 좌표
            coordinate[N + 1][0] = Integer.parseInt(st.nextToken());
            coordinate[N + 1][1] = Integer.parseInt(st.nextToken());

            //고객 좌표
            for (int j = 1; j <= N; j++) {
                coordinate[j][0] = Integer.parseInt(st.nextToken());
                coordinate[j][1] = Integer.parseInt(st.nextToken());
            }

            find(0, coordinate[0][0], coordinate[0][1], 0);
            sb.append("#" + (i + 1) + " " + min + "\n");
        }

        //출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void find(int cnt, int x, int y, int len) {
        if (cnt >= N) {
            len += calc(x, y, coordinate[N + 1][0], coordinate[N + 1][1]);
            if (len < min) {
                min = len;
            }
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (visited[i] != 1) {
                visited[i] = 1;
                find(cnt + 1, coordinate[i][0], coordinate[i][1], len + calc(x, y, coordinate[i][0], coordinate[i][1]));
                visited[i] = 0;
            }
        }
    }

    private static int calc(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}