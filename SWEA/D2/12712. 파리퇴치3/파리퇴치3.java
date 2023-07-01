import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    private static int T, N, M;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            //입력
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            arr = new int[N + 1][N + 1];

            for (int j = 1; j <= N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 1; k <= N; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append("#" + (i + 1) + " ");

            int[][] max_arr = new int[N + 1][N + 1];

            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    //+
                    int plusSum = 0;
                    plusSum += arr[j][k];
                    for (int l = 1; l < M; l++) {
                        //상
                        if (k + l <= N) {
                            plusSum += arr[j][k + l];
                        }

                        //하
                        if (k - l >= 1) {
                            plusSum += arr[j][k - l];
                        }

                        //좌
                        if (j - l >= 1) {
                            plusSum += arr[j - l][k];
                        }

                        //우
                        if (j + l <= N) {
                            plusSum += arr[j + l][k];
                        }
                    }

                    //x
                    int xSum = 0;
                    xSum += arr[j][k];
                    for (int l = 1; l < M; l++) {
                        //오른쪽 위
                        if (j + l <= N && k + l <= N) {
                            xSum += arr[j + l][k + l];
                        }

                        //오른쪽 아래
                        if (j + l <= N && k - l >= 1) {
                            xSum += arr[j + l][k - l];
                        }

                        //왼쪽 위
                        if (j - l >= 1 && k + l <= N) {
                            xSum += arr[j - l][k + l];
                        }

                        //왼쪽 아래
                        if (j - l >= 1 && k - l >= 1) {
                            xSum += arr[j - l][k - l];
                        }
                    }

                    if (plusSum >= xSum) {
                        max_arr[j][k] = plusSum;
                    } else {
                        max_arr[j][k] = xSum;
                    }
                }
            }

            //최대값 찾기
            int max = 0;

            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    if (max_arr[j][k] > max) {
                        max = max_arr[j][k];
                    }
                }
            }

            sb.append(max + "\n");
        }

        //출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}