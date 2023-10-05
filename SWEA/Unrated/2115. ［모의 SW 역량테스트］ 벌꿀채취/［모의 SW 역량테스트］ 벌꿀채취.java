import java.io.*;
import java.util.*;

public class Solution {
    private static StringBuilder sb = new StringBuilder();
    private static int[][] arr;
    private static boolean[] visited;
    private static int[] list;
    private static int N, M, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int max = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            arr = new int[N][N];

            // 입력
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());

                for (int m = 0; m < N; m++) {
                    arr[n][m] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N; i++) {
                // 첫번째 사람 채취
                int firstSum = 0;

                for (int j = 0; j <= N - M; j++) {
                    // 합 초기화
                    if (j == 0) {
                        for (int m = 0; m < M; m++) {
                            firstSum += arr[i][m];
                        }
                    }
                    // 합 업데이트
                    else {
                        firstSum -= arr[i][j - 1];
                        firstSum += arr[i][j + M - 1];
                    }

                    // 제곱합 계산
                    int firstSquareMax = 0;

                    if (firstSum <= C) {
                        for (int m = 0; m < M; m++) {
                            firstSquareMax += Math.pow(arr[i][j + m], 2);
                        }
                    }
                    else {
                        list = new int[M];
                        visited = new boolean[M];
                        for (int m = 0; m < M; m++) {
                            list[m] = arr[i][j + m];
                        }

                        for (int in = 0; in < list.length; in++) {
                            visited[in] = true;
                            int dfsResult = dfs(in, 0, 0, 0);
                            if (dfsResult > firstSquareMax) {
                                firstSquareMax = dfsResult;
                            }
                            visited[in] = false;
                        }
                    }

                    // 다음 탐색
                    for (int a = i; a < N; a++) {
                        int secondSum = 0;

                        // 첫번째와 같은 줄일 때
                        if (a == i) {
                            // 그 줄에 아직 남았을 때만 시도
                            if (j + M <= N - M) {
                                for (int b = j + M; b <= N - M; b++) {
                                    if (b == j + M) {
                                        // 합 초기화
                                        for (int m = 0; m < M; m++) {
                                            secondSum += arr[a][j + M + m];
                                        }
                                    }
                                    else {
                                        secondSum -= arr[a][b - 1];
                                        secondSum += arr[a][b + M - 1];
                                    }

                                    // 제곱합 계산
                                    int secondSquareMax = 0;

                                    if (secondSum <= C) {
                                        for (int m = 0; m < M; m++) {
                                            secondSquareMax += Math.pow(arr[a][b + m], 2);
                                        }
                                    }
                                    else {
                                        list = new int[M];
                                        visited = new boolean[M];
                                        for (int m = 0; m < M; m++) {
                                            list[m] = arr[a][b + m];
                                        }

                                        for (int in = 0; in < list.length; in++) {
                                            visited[in] = true;
                                            int dfsResult = dfs(in, 0, 0, 0);
                                            if (dfsResult > secondSquareMax) {
                                                secondSquareMax = dfsResult;
                                            }
                                            visited[in] = false;
                                        }
                                    }

                                    int sum = firstSquareMax + secondSquareMax;
                                    if (sum > max) {
                                        max = sum;
                                    }
                                }
                            }
                        }
                        // 다른 줄일 때
                        else {
                            for (int b = 0; b <= N - M; b++) {
                                if (b == 0) {
                                    // 합 초기화
                                    for (int m = 0; m < M; m++) {
                                        secondSum += arr[a][m];
                                    }
                                } else {
                                    secondSum -= arr[a][b - 1];
                                    secondSum += arr[a][b + M - 1];
                                }

                                // 제곱합 계산
                                int secondSquareMax = 0;

                                if (secondSum <= C) {
                                    for (int m = 0; m < M; m++) {
                                        secondSquareMax += Math.pow(arr[a][b + m], 2);
                                    }
                                }
                                else {
                                    list = new int[M];
                                    visited = new boolean[M];
                                    for (int m = 0; m < M; m++) {
                                        list[m] = arr[a][b + m];
                                    }

                                    for (int in = 0; in < list.length; in++) {
                                        visited[in] = true;
                                        int dfsResult = dfs(in, 0, 0, 0);
                                        if (dfsResult > secondSquareMax) {
                                            secondSquareMax = dfsResult;
                                        }
                                        visited[in] = false;
                                    }
                                }

                                int sum = firstSquareMax + secondSquareMax;
                                if (sum > max) {
                                    max = sum;
                                }
                            }
                        }
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }

    private static int dfs(int targetIndex, int sum, int squareSum, int squareMax) {
        // 합 계산
        sum += list[targetIndex];

        if (sum > C) {
            return squareMax;
        }

        // 제곱합 계산
        int newSquareSum = (int) (Math.pow(list[targetIndex], 2) + squareSum);

        if (newSquareSum > squareMax) {
            squareMax = newSquareSum;
        }

        for (int i = targetIndex + 1; i < list.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                int dfsResult = dfs(i, sum, newSquareSum, squareMax);
                if (dfsResult > squareMax) {
                    squareMax = dfsResult;
                }
                visited[i] = false;
            }
        }

        return squareMax;
    }
}