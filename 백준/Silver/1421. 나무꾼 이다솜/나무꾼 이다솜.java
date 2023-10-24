import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static Integer[] arr;
    private static int N, C, W;
    private static long max, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 팔려고 하는 나무의 길이를 전부 같게

        // 한 번 자를 때는, C원이 든다.
        // 한 단위에 W원씩 준다.

        // K개의 나무가 있고, 길이가 L이면, 이다솜은 K*L*W원을 벌 수 있다.

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        arr = new Integer[N];
        max = 0;
        answer = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());

            if (max < arr[i]) {
                max = arr[i];
            }
        }

        // 1부터 최대 길이까지
        for (int i = 1; i <= max; i++) {
            // 합 초기화
            long sum = 0;

            // 전부 돌면서
            for (int j = 0; j < N; j++) {
                long cut = 0;

                // 자를거 개수 카운트
                if (arr[j] >= i) {
                    if (arr[j] % i == 0) {
                        cut = arr[j] / i - 1;
                    } else {
                        cut = arr[j] / i;
                    }

                    // 계산하고
                    long result = W * i * (arr[j] / i) - cut * C;

                    // 도움이 되는거면
                    if (result > 0) {
                        // 합산
                        sum += result;
                    }
                }
            }

            // 최대값만 업데이트
            if (sum > answer) {
                answer = sum;
            }
        }

        System.out.println(answer);
    }
}