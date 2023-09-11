import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.*;
import java.util.StringTokenizer;

public class Main {
    private static int answer = 0;
    private static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 초기화
        arr = new int[N + 1][M + 1];

        // 배열 입력
        for (int n = 1; n <= N; n++) {
            st = new StringTokenizer(br.readLine());

            for (int m = 1; m <= M; m++) {
                arr[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        // 둘레 테두리 범위 안에 놓을수 있는지 확인
        // ㅣ자
        for (int i = 1; i <= M; i++) {
            int sum = 0;
            for (int j = 1; j <= 4; j++) {
                sum += arr[j][i];
            }

            updateMaxValue(sum);

            for (int j = 2; j <= N - 3; j++) {
                // 맨 앞 빼기
                sum -= arr[j - 1][i];

                // 맨 뒤 더하기
                sum += arr[j + 3][i];

                updateMaxValue(sum);
            }
        }

        // ㅡ자
        for (int i = 1; i <= N; i++) {
            int sum = 0;
            for (int j = 1; j <= 4; j++) {
                sum += arr[i][j];
            }

            updateMaxValue(sum);

            for (int j = 2; j <= M - 3; j++) {
                // 맨 앞 빼기
                sum -= arr[i][j - 1];

                // 맨 뒤 더하기
                sum += arr[i][j + 3];

                updateMaxValue(sum);
            }
        }

        // ㅁ자
        for (int i = 1; i <= N - 1; i++) {
            int sum = 0;
            for (int j = 1; j <= 2; j++) {
                sum += arr[i][j];
                sum += arr[i + 1][j];
            }

            updateMaxValue(sum);

            for (int j = 2; j <= M - 1; j++) {
                // 맨 앞 빼기
                sum -= arr[i][j - 1];
                sum -= arr[i + 1][j - 1];

                // 맨 뒤 더하기
                sum += arr[i][j + 1];
                sum += arr[i + 1][j + 1];

                updateMaxValue(sum);
            }
        }

        // 세로형
        for (int i = 1; i <= N - 2; i++) {
            for (int j = 1; j <= M - 1; j++) {
                int sum = 0;

                // ㄴ자
                sum += arr[i][j];
                sum += arr[i + 1][j];
                sum += arr[i + 2][j];
                sum += arr[i + 2][j + 1];

                updateMaxValue(sum);

                // ㄴ 대칭
                sum = 0;
                sum += arr[i][j + 1];
                sum += arr[i + 1][j + 1];
                sum += arr[i + 2][j + 1];
                sum += arr[i + 2][j];

                updateMaxValue(sum);

                // ㄱ
                sum = 0;
                sum += arr[i][j];
                sum += arr[i][j + 1];
                sum += arr[i + 1][j + 1];
                sum += arr[i + 2][j + 1];

                updateMaxValue(sum);

                // ㄱ 대칭
                sum = 0;
                sum += arr[i][j];
                sum += arr[i][j + 1];
                sum += arr[i + 1][j];
                sum += arr[i + 2][j];

                updateMaxValue(sum);

                // ㄹ자
                sum = 0;
                sum += arr[i][j];
                sum += arr[i + 1][j];
                sum += arr[i + 1][j + 1];
                sum += arr[i + 2][j + 1];

                updateMaxValue(sum);

                sum = 0;
                sum += arr[i][j + 1];
                sum += arr[i + 1][j + 1];
                sum += arr[i + 1][j];
                sum += arr[i + 2][j];

                updateMaxValue(sum);

                // ㅏ
                sum = 0;
                sum += arr[i][j];
                sum += arr[i + 1][j];
                sum += arr[i + 2][j];
                sum += arr[i + 1][j + 1];

                updateMaxValue(sum);

                // ㅓ
                sum = 0;
                sum += arr[i][j + 1];
                sum += arr[i + 1][j + 1];
                sum += arr[i + 2][j + 1];
                sum += arr[i + 1][j];

                updateMaxValue(sum);
            }
        }

        // 가로형
        for (int i = 1; i <= N - 1; i++) {
            for (int j = 1; j <= M - 2; j++) {
                int sum = 0;

                // ㄱ자
                sum = 0;
                sum += arr[i][j];
                sum += arr[i][j + 1];
                sum += arr[i][j + 2];
                sum += arr[i + 1][j + 2];

                updateMaxValue(sum);

                // ㄱ자 대칭
                sum = 0;
                sum += arr[i][j];
                sum += arr[i][j + 1];
                sum += arr[i][j + 2];
                sum += arr[i + 1][j];

                updateMaxValue(sum);

                // ㄴ자
                sum = 0;
                sum += arr[i][j];
                sum += arr[i + 1][j];
                sum += arr[i + 1][j + 1];
                sum += arr[i + 1][j + 2];

                updateMaxValue(sum);

                // ㄴ자 대칭
                sum = 0;
                sum += arr[i][j + 2];
                sum += arr[i + 1][j];
                sum += arr[i + 1][j + 1];
                sum += arr[i + 1][j + 2];

                updateMaxValue(sum);

                // ㄹ자
                sum = 0;
                sum += arr[i][j];
                sum += arr[i][j + 1];
                sum += arr[i + 1][j + 1];
                sum += arr[i + 1][j + 2];

                updateMaxValue(sum);

                // ㄹ자 대칭
                sum = 0;
                sum += arr[i][j + 1];
                sum += arr[i][j + 2];
                sum += arr[i + 1][j];
                sum += arr[i + 1][j + 1];

                updateMaxValue(sum);

                // ㅗ
                sum = 0;
                sum += arr[i][j + 1];
                sum += arr[i + 1][j];
                sum += arr[i + 1][j + 1];
                sum += arr[i + 1][j + 2];

                updateMaxValue(sum);

                // ㅜ
                sum = 0;
                sum += arr[i][j];
                sum += arr[i][j + 1];
                sum += arr[i][j + 2];
                sum += arr[i + 1][j + 1];

                updateMaxValue(sum);
            }
        }

        System.out.println(answer);
    }

    private static void updateMaxValue(int sum) {
        if (sum > answer) {
            answer = sum;
        }
    }
}