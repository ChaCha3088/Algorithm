import java.io.*;
import java.util.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            // 배열 초기화
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];

            // 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            long sum = 0;
            int max = 0;

            for (int i = N - 1; i >= 0; i--) {
                if (arr[i] > max) {
                    max = arr[i];
                }
                else if (arr[i] < max) {
                    sum += (max - arr[i]);
                }

            }
            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }
}