import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N, L, answer;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        answer = 0;

        // 입력
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());

            for (int m = 0; m < N; m++) {
                map[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            if (visit(i, 0, true)) {
                answer += 1;
            }

            if (visit(0, i, false)) {
                answer += 1;
            }
        }

        // 출력
        System.out.println(answer);
    }

    private static boolean visit(int r, int c, boolean flag) {
        int[] height = new int[N];
        boolean[] slope = new boolean[N];

        for (int i = 0; i < N; i++) {
            if (flag) {
                // 행 체크
                height[i] = map[r][i];
            } else {
                // 행 체크
                height[i] = map[i][c];
            }
        }

        for (int i = 0; i < N - 1; i++) {
            // 평지이면
            if (height[i] == height[i + 1]) {
                // 다음으로
                continue;
            }
            // 내리막이면
            else if (height[i] - 1 == height[i + 1]) {
                // 앞으로 가면서
                for (int j = i + 1; j < i + 1 + L; j++) {
                    // 범위 벗어나면
                    if (j >= N) {
                        return false;
                    }
                    // 경사로가 이미 있으면
                    if (slope[j]) {
                        return false;
                    }
                    // 경사로 놓을 곳이 평평하지 않으면
                    if (height[i + 1] != height[j]) {
                        return false;
                    }
                    // 문제가 없으면 경사로를 놓는다.
                    slope[j] = true;
                }
            }
            // 오르막이면
            else if (height[i] + 1 == height[i + 1]) {
                // 뒤로 가면서
                for (int j = i; j > i - L; j--) {
                    // 범위 벗어나면
                    if (j < 0) {
                        return false;
                    }

                    // 경사로가 이미 있으면
                    if (slope[j]) {
                        return false;
                    }

                    // 경사로 놓을 곳이 평평하지 않으면
                    if (height[i] != height[j]) {
                        return false;
                    }
                    // 문제가 없으면 경사로를 놓는다.
                    slope[j] = true;
                }
            }
            // 높이 차이가 1 초과이면
            else {
                return false;
            }
        }

        // 이걸 살아남아?
        return true;
    }
}