import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    private static String[] arr;

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int t = 1; t <= T; t++) {
            // 입력
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            arr = new String[N];

            String[] split = br.readLine().split(" ");
            for (int i = 0; i < split.length; i++) {
                 arr[i] = split[i];
            }

            sb.append("#").append(t).append(" ");

            int firstIndex = 0;
            int secondIndex;

            // 홀수 일 때
            if (N % 2 == 1) {
                secondIndex = N / 2 + 1;
            }
            // 짝수 일 때
            else {
                secondIndex = N / 2;
            }

            for (int i = 0; i < secondIndex; i++) {
                sb.append(arr[i]).append(" ");
                if (secondIndex + i < N) {
                    sb.append(arr[secondIndex + i]).append(" ");
                }
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}