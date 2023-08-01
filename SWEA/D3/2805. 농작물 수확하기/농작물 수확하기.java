import java.io.*;

class Solution {
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.valueOf(br.readLine());

        for (int i = 1; i <= T; i++) {
            int N = Integer.valueOf(br.readLine());

            // 배열 초기화
            arr = new int[N + 1][N + 1];

            // 지도 입력
            for (int j = 1; j <= N; j++) {
                String[] split = br.readLine().split("");

                for (int k = 0; k < split.length; k++) {
                    arr[j][k + 1] = Integer.valueOf(split[k]);
                }
            }

            // 합 초기화
            int sum = 0;

            int y = 1;
            while (y <= (N + 1) / 2) {
                sum += arr[y][(N + 1) / 2];

                for (int j = 1; j < y; j++) {
                    sum += arr[y][(N + 1) / 2 + j];
                    sum += arr[y][(N + 1) / 2 - j];
                }

                y += 1;
            }

            y = N;
            while (y > (N + 1) / 2) {
                sum += arr[y][(N + 1) / 2];

                for (int j = 1; j <= N - y; j++) {
                    sum += arr[y][(N + 1) / 2 + j];
                    sum += arr[y][(N + 1) / 2 - j];
                }

                y -= 1;
            }

            // 출력
            sb.append("#").append(i).append(" ").append(sum);
            System.out.println(sb);

            // StringBuilder 초기화
            sb = new StringBuilder();
        }
    }
}