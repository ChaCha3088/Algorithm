import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    private static int T, N;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            arr = new int[N][N];

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append("#").append(i + 1).append("\n");

            //90도
            int[][] arr_90 = new int[N][N];

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    arr_90[j][k] = arr[N - 1 - k][j];
                }
            }

            //180도
            int[][] arr_180 = new int[N][N];

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    arr_180[j][k] = arr_90[N - 1 - k][j];
                }
            }

            //270도
            int[][] arr_270 = new int[N][N];

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    arr_270[j][k] = arr_180[N - 1 - k][j];
                }
            }

            for (int j = 0; j < N; j++) {
                for (int a = 0; a < N; a++) {
                    sb.append(arr_90[j][a]);
                }
                sb.append(" ");
                for (int b = 0; b < N; b++) {
                    sb.append(arr_180[j][b]);
                }
                sb.append(" ");
                for (int c = 0; c < N; c++) {
                    sb.append(arr_270[j][c]);
                }
                sb.append("\n");
            }
        }

        //출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}