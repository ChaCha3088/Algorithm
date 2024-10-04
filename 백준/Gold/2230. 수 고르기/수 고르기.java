import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static int[] arr;
    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N];

        M = Integer.parseInt(st.nextToken());

        for (int n = 0; n < N; n++) {
            int input = Integer.parseInt(br.readLine());

            arr[n] = input;
        }

        Arrays.sort(arr);

        int l = 0;
        int r = 0;
        while (l < arr.length && r < arr.length) {
            int diff = arr[r] - arr[l];

            // 차이가 M보다 작으면
            if (diff < M) {
                r += 1;
                continue;
            }

            // 가장 작은 diff가 발견되면
            if (answer > diff) {
                answer = diff;
            }

            l += 1;
        }

        System.out.println(answer);
    }
}