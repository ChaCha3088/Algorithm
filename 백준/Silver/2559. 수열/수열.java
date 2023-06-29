import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static int N, K, max;
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //초기 세팅
        int sum = 0;
        int idx = 0;
        for (int i = 0; i < K; i++) {
            sum += arr[i];
        }

        int max = sum;

        //검색
        for (int i = 1; i < N - K + 1; i++) {
            sum -= arr[i - 1];
            sum += arr[i + K - 1];
            if (sum > max) {
                max = sum;
            }
        }

        //출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }
}