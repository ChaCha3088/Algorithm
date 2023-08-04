import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            String[] s = br.readLine().split(" ");

            int N = Integer.parseInt(s[0]), M = Integer.parseInt(s[1]);

            int maxValue = 0;

            map = new int[N + 1][N + 1];

            // 입력
            for (int j = 1; j <= N; j++) {
                String[] s1 = br.readLine().split(" ");

                for (int k = 1; k <= N; k++) {
                    map[j][k] = Integer.parseInt(s1[k - 1]);
                }
            }

            for (int y = 1; y <= N - M + 1; y++) {
                // 행마다 초기화
                int sum = 0;
                for (int b = y; b < y + M; b++) {
                    for (int a = 1; a <= M; a++) {
                        sum += map[b][a];
                    }
                }

                for (int x = 1; x <= N - M + 1; x++) {
                    if (sum > maxValue) {
                        maxValue = sum;
                    }

                    if (x <= N - M) {
                        for (int h = y; h < y + M; h++) {
                            sum += (map[h][x + M]);
                            sum -= (map[h][x]);
                        }
                    }
                }
            }

            // 출력
            sb.append("#").append(i).append(" ").append(maxValue).append("\n");
        }

        System.out.println(sb);
    }
}