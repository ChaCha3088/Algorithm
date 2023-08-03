import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[][] arr;
    private static int[] numbers;
    private static int[][] result;
    private static int minValue = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 배열 초기화
        arr = new int[N + 1][];
        numbers = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            numbers[i] = i;
        }
        result = new int[(int) Math.pow(2, N)][];

        for (int i = 1; i <= N; i++) {
            String[] s = br.readLine().split(" ");

            arr[i] = new int[] {Integer.parseInt(s[0]), Integer.parseInt(s[1])};
        }

        // 조합 구하기
        for (int i = 1; i < 1 << N; i++) {
            result[i] = new int[N];
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) > 0) {
                    result[i][j] = numbers[j + 1];
                }
            }
        }

        // 신맛과 쓴맛 계산
        for (int i = 1; i < result.length; i++) {
            int s = 1;
            int b = 0;

            for (int j = 0; j < result[i].length; j++) {
                if (result[i][j] != 0) {
                    int[] ingredient = arr[result[i][j]];

                    s *= ingredient[0];
                    b += ingredient[1];
                }
            }

            int difference = Math.abs(s - b);

            if (difference < minValue) {
                minValue = difference;
            }
        }

        System.out.println(minValue);
    }
}