import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int[][] digit = {
        {1, 1, 1, 0, 1, 1, 1}, // 0
        {0, 0, 1, 0, 0, 0, 1}, // 1
        {0, 1, 1, 1, 1, 1, 0}, // 2
        {0, 1, 1, 1, 0, 1, 1}, // 3
        {1, 0, 1, 1, 0, 0, 1}, // 4
        {1, 1, 0, 1, 0, 1, 1}, // 5
        {1, 1, 0, 1, 1, 1, 1}, // 6
        {0, 1, 1, 0, 0, 0, 1}, // 7
        {1, 1, 1, 1, 1, 1, 1}, // 8
        {1, 1, 1, 1, 0, 1, 1}, // 9
    };

    private static int N, K, P, X, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        P = Integer.parseInt(input[2]);
        X = Integer.parseInt(input[3]);

        // 현재 층을 디지털로 변환
        int[][] currentFloor = numToDigit(X);

        for (int i = 1; i <= N; i++) {
            // 1부터 N까지 틀린 개수 P를 안넘는 것 몇 개?
            // rising
            if (i == X) {
                continue;
            }

            int[][] risingNum = numToDigit(i);

            int diffNum = 0;
            for (int j = 0; j < K; j++) {
                for (int k = 0; k < 7; k++) {
                    if (currentFloor[j][k] != risingNum[j][k])
                        diffNum++;
                }
            }

            if (diffNum <= P) {
                answer++;
            }
        }

        // 출력
        System.out.println(answer);
    }

    public static int[][] numToDigit(int num) {
        int[][] makeFloor = new int[K][7];

        for (int i = 0; i < K; i++) {
            int cur = num % 10;
            num /= 10;
            makeFloor[K - i - 1] = digit[cur];
        }

        return makeFloor;
    }
}