import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N, M;
    private static int[][] CCTVs = new int[8][];
    private static int indexOfCCTV;
    private static int countOfWatch = 0;
    private static int countOfNotCounted = 0;
    private static int[] dx = new int[] {0, 1, 0, -1};
    private static int[] dy = new int[] {1, 0, -1, 0};
    private static int[][] arr;
    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][M + 1];

        indexOfCCTV = 0;

        // 입력
        for (int n = 1; n <= N; n++) {
            st = new StringTokenizer(br.readLine());

            for (int m = 1; m <= M; m++) {
                int typeOfCCTV = Integer.parseInt(st.nextToken());

                if (typeOfCCTV == 6) {
                    arr[n][m] = typeOfCCTV;
                    countOfNotCounted += 1;
                }
                else if (1<= typeOfCCTV && typeOfCCTV <= 5) {
                    CCTVs[indexOfCCTV] = new int[]{typeOfCCTV, n, m};
                    arr[n][m] = typeOfCCTV;
                    indexOfCCTV += 1;
                    countOfNotCounted += 1;
                }
            }
        }

        dfs(0);

        System.out.println(answer);
    }

    private static void dfs(int depth) {
        if (depth == indexOfCCTV) {
            // 사각 지대의 최소 크기 업데이트
            int result = N * M - countOfWatch - countOfNotCounted;

            if (result < answer) {
                answer = result;
            }

            return;
        }

        int[] cctv = CCTVs[depth];

        int typeOfCCTV = cctv[0];
        int n = cctv[1];
        int m = cctv[2];

        // 감시한다.
        List<int[]> listOfWatches = new ArrayList();

        for (int i = 0; i < 4; i++) {
            listOfWatches.clear();

            if (typeOfCCTV == 1) {
                listOfWatches.addAll(watch(n, m, i));
            }
            else if (typeOfCCTV == 2) {
                if (i <= 1) {
                    listOfWatches.addAll(watch(n, m, i));
                    listOfWatches.addAll(watch(n, m, (i + 2) % 4));
                }
            }
            else if (typeOfCCTV == 3) {
                listOfWatches.addAll(watch(n, m, i));
                listOfWatches.addAll(watch(n, m, (i + 1) % 4));
            }
            else if (typeOfCCTV == 4) {
                listOfWatches.addAll(watch(n, m, i));
                listOfWatches.addAll(watch(n, m, (i + 1) % 4));
                listOfWatches.addAll(watch(n, m, (i + 3) % 4));
            }
            else {
                if (i == 0) {
                    listOfWatches.addAll(watch(n, m, i));
                    listOfWatches.addAll(watch(n, m, i + 1));
                    listOfWatches.addAll(watch(n, m, i + 2));
                    listOfWatches.addAll(watch(n, m, i + 3));
                }
            }

            // 감시 개수 카운트하고
            int tempOfCounts = listOfWatches.size();
            countOfWatch += tempOfCounts;

            // 더 들어가고
            dfs(depth + 1);

            // 감시 개수 카운트 다시 빼고
            countOfWatch -= tempOfCounts;

            // 스택 빼면서 기록 원상복구
            for (int[] watch : listOfWatches) {
                int y = watch[0];
                int x = watch[1];
                int type = watch[2];

                arr[y][x] = type;
            }
        }

    }

    private static List<int[]> watch(int n, int m, int direction) {
        List<int[]> historyOfWatches = new ArrayList();

        int newN = n + dy[direction];
        int newM = m + dx[direction];

        // 범위 안쪽이고, -1이 아니고, 6이 아니면
        while (1 <= newN && newN <= N && 1 <= newM && newM <= M && arr[newN][newM] != 6) {
            if (arr[newN][newM] == 0) {
                // 원래 정보 기록하고
                // {좌표, 원래 값}
                historyOfWatches.add(new int[]{newN, newM, arr[newN][newM]});

                // 기록 변경하고
                arr[newN][newM] = -1;
            }

            // 좌표 이동
            newN = newN + dy[direction];
            newM = newM + dx[direction];
        }

        return historyOfWatches;
    }
}