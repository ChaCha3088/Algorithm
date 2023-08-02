import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    private static int N;
    private static int[][] arr;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int x = 1;
    private static int y = 1;
    private static int dIndex = 0;
    private static int number = 2;
    private static int iterCount = 0;
    private static boolean isFinished;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;

        int T = Integer.parseInt(br.readLine());


        for (int test = 1; test <= T; test++) {
            N = Integer.parseInt(br.readLine());

            // 배열 초기화
            arr = new int[N + 1][N + 1];
            arr[1][1] = 1;

            // 현재 위치, 방향 인덱스, 넣을 숫 초기화
            x = 1;
            y = 1;
            number = 2;
            iterCount = 0;
            isFinished = false;

            letsGo(0);

            // 출력
            sb = new StringBuilder();
            sb.append("#").append(test).append("\n");

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    sb.append(arr[i][j]).append(" ");
                }

                if (i != N) {
                    sb.append("\n");
                }
            }

            System.out.println(sb);
        }
    }

    private static void letsGo(int dIndex) {
        // 내가 가는 방향이 0이면 계속 가
        while (true) {
            // 앞에 확인
            // 앞이 범위 안이고
            if (x + dx[dIndex] <= N && 1 <= x + dx[dIndex] && y + dy[dIndex] <= N && 1 <= y + dy[dIndex]) {
                // 앞이 아직 가보지 않은 곳이면
                if (arr[y + dy[dIndex]][x + dx[dIndex]] == 0) {
                    iterCount = 0;

                    // 숫자를 넣어준다.
                    arr[y + dy[dIndex]][x + dx[dIndex]] = number;
                    number += 1;

                    // 현재 위치 움직이기
                    x = x + dx[dIndex];
                    y = y + dy[dIndex];
                }
                // 이미 가본 곳이면
                else {
                    if (iterCount >= 4) {
                        isFinished = true;
                        break;
                    }
                    iterCount += 1;
                    letsGo((dIndex + 1) % 4);
                    if (isFinished) {
                        break;
                    }
                }
            }
            // 애초에 범위 밖이면
            else {
                if (iterCount >= 4) {
                    isFinished = true;
                    break;
                }
                iterCount += 1;
                letsGo((dIndex + 1) % 4);
                if (isFinished) {
                    break;
                }
            }
        }


    }
}