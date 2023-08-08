import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    private static StringBuilder sb = new StringBuilder();
    private static int[] arr;
    private static int[][] results;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test = 1; test <= T; test++) {
            int answer = -1;

            String[] split = br.readLine().split(" ");
            int N = Integer.parseInt(split[0]), M = Integer.parseInt(split[1]);

            arr = new int[N];

            split = br.readLine().split(" ");
            for (int n = 0; n < N; n++) {
                arr[n] = Integer.parseInt(split[n]);
            }

            // 정렬
            Arrays.sort(arr);

            // 조합
            results = new int[N * (N - 1) / 2][];

            int index = 0;
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    results[index] = new int[] {arr[i], arr[j]};
                    index += 1;
                }
            }

            // 최대값 찾기
            for (int i = 0; i < results.length; i++) {
                int sum = results[i][0] + results[i][1];

                if (sum <= M && sum > answer) {
                    answer = sum;
                }
            }

            sb.append("#").append(test).append(" ").append(answer).append("\n");
        }

        System.out.println(sb);
    }
}