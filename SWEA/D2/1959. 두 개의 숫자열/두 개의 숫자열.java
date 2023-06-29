import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    private static int T, N, M;
    private static int[] A, B;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            A = new int[N];
            B = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                B[j] = Integer.parseInt(st.nextToken());
            }

            int smaller = Math.min(N, M);
            int diff = Math.abs(N - M);
            int answer = Integer.MIN_VALUE;

            if (smaller == N) {
                for (int j = 0; j <= diff; j++) {
                    int sum = 0;
                    for (int k = 0; k < smaller; k++) {
                        sum += A[k] * B[j + k];
                    }
                    if (sum > answer) {
                        answer = sum;
                    }
                }
            } else {
                for (int j = 0; j <= diff; j++) {
                    int sum = 0;
                    for (int k = 0; k < smaller; k++) {
                        sum += B[k] * A[j + k];
                    }
                    if (sum > answer) {
                        answer = sum;
                    }
                }
            }

            sb.append("#").append(i + 1).append(" ").append(answer).append("\n");
        }

        //출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}