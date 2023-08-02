import java.io.*;

public class Main {
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        // 누적
        int sum = 0;

        // 누적 배열 초기화
        arr = new int[N + 1];

        // 누적 배열 입력
        s = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            sum += Integer.parseInt(s[i - 1]);
            arr[i] = sum;
        }

        for (int i = 0; i < M; i++) {
            s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);

            sb.append(arr[end] - arr[start - 1]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}