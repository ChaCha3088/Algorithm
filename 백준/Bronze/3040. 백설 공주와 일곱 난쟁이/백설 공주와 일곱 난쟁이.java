import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[] numbers;
    private static int[][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = 9;

        // 배열 초기화
        numbers = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }
        result = new int[(int) Math.pow(2, N)][];

        // 조합 구하기
        for (int i = 1; i < 1 << N; i++) {
            result[i] = new int[N + 1];

            int count = 0;

            for (int j = 0; j <= N; j++) {
                if ((i & (1 << j)) > 0) {
                    count += 1;
                    result[i][j + 1] = numbers[j + 1];

                    if (count == 7) {
                        result[i][0] = 1;
                    }
                    if (count > 7) {
                        result[i][0] = 0;
                    }
                }
            }
        }

        // 계산하기
        for (int i = 1; i <= result.length; i++) {
            if (result[i][0] == 1) {
                int sum = 0;

                for (int j = 1; j < result[i].length; j++) {
                    if (result[i][j] != 0) {
                        sum += result[i][j];
                    }
                }

                if (sum == 100) {
                    for (int k = 1; k < result[i].length; k++) {
                        if (result[i][k] != 0) {
                            System.out.println(result[i][k]);
                        }
                    }

                    break;
                }
            }
        }
    }
}