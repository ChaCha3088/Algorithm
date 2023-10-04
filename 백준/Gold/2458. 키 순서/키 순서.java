import java.io.*;
import java.util.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int N, M;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][N + 1];

        // 무한대 입력
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                arr[i][j] = 999999999;
            }
        }

        // 입력
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());

            arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
        }

        for (int mid = 1; mid <= N; mid++) { // 가운데 노드
            for (int start = 1; start <= N; start++) { // 시작 노드
                for (int end = 1; end <= N; end++) { // 끝 노드
                    // 시작 ~ 마지막 > 시작 ~ 가운데 + 가운데 + 끝 -> 갱신
                    if (arr[start][end] > arr[start][mid] + arr[mid][end]) {
                        arr[start][end] = arr[start][mid] + arr[mid][end];
                    }
                }
            }
        }

        int answer = 0;

        for (int i = 1; i <= N; i++) {
            int count = 0;

            for (int j = 1; j <= N; j++) {
                if (arr[i][j] != 999999999 || arr[j][i] != 999999999) {
                    count += 1;
                }
            }

            if (count == N - 1) {
                answer += 1;
            }
        }

        System.out.println(answer);
    }
}