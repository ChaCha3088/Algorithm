import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int N;
    private static int[][] distance;
    private static Point[] points;
    private static final int INF = 327670;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            points = new Point[N + 2];
            for(int i = 0; i < N + 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            distance = new int[N + 2][N + 2];
            for (int i = 0; i < N + 1; i++) {
                for(int j = i + 1; j < N + 2; j++) {
                    distance[i][j] = distance[j][i] = INF;

                    // 거리 측정
                    int diff = Math.abs(points[i].y - points[j].y) + Math.abs(points[i].x - points[j].x);

                    // 거리가 50 * 20 이하이면 갈 수 있는 길이다.
                    if (diff <= 50 * 20) {
                        distance[i][j] = distance[j][i] = 1;
                    }
                }
            }

            for (int k = 0; k < N + 2; k++) {
                for (int i = 0; i < N + 2; i++) {
                    for (int j = 0; j < N + 2; j++) {
                        distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                    }
                }
            }

            if (0 < distance[0][N + 1] && distance[0][N + 1] < INF) {
                System.out.println("happy");
            }
            else {
                System.out.println("sad");
            }
        }
    }
}