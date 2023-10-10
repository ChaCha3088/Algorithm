import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static int R, C, T;
    private static int[][] arr, temp;
    private static List<Integer> cleaner = new ArrayList();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        arr = new int[R][C];

        // 입력
        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < C; c++) {
                int input = Integer.parseInt(st.nextToken());
                arr[r][c] = input;

                if (input == -1) {
                    cleaner.add(r);
                }
            }
        }

        for (int t = 1; t <= T; t++) {
            temp = new int[R][C];

            // 청정기 위치 기록
            temp[cleaner.get(0)][0] = -1;
            temp[cleaner.get(1)][0] = -1;

            spread();

            clean();

            // 배열 업데이트
            arr = temp;
        }

        // 남아있는 미세먼지 양 계산
        int answer = 0;

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (arr[r][c] > 0) {
                    answer += arr[r][c];
                }
            }
        }

        // 출력
        System.out.println(answer);
    }

    private static void spread() {
        // 모든 칸을 돌면서
        // 0 초과이면
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (arr[r][c] > 0) {
                    // 몇 칸으로 확산할 수 있는지 확인
                    int howMany = 0;

                    // 확산되는 양 계산
                    int spreadingAmount = arr[r][c] / 5;

                    if (spreadingAmount > 0) {
                        for (int i = 0; i < 4; i++) {
                            int newR = r + dy[i];
                            int newC = c + dx[i];

                            // 범위를 넘어가거나, 청정기가 있으면
                            if (newR < 0 || newC < 0 || newR >= R || newC >= C || arr[newR][newC] == -1) {
                                // 넘어가
                                continue;
                            }

                            // 확산 반영
                            temp[newR][newC] += spreadingAmount;

                            howMany += 1;
                        }
                    }

                    // 남은 미세먼지 양 계산
                    int leftOver = arr[r][c] - spreadingAmount * howMany;

                    // 남은 미세먼지 양 반영
                    temp[r][c] += leftOver;
                }
            }
        }
    }

    private static void clean() {
        // 위쪽
        int limit = cleaner.get(0);

        int r = cleaner.get(0);
        int c = 0;

        int index = 2;

        while (true) {
            int newR = r + dy[index];
            int newC = c + dx[index];

            // 범위 나가면
            if (newR > limit || newR < 0 || newC >= C || newC < 0) {
                // 방향 바꾸고
                if (index == 0) {
                    index = 3;
                }
                else {
                    index -= 1;
                }

                // 다시 하기
                continue;
            }

            // 범위 안나가면
            // 공기 청정기에 들어가는거 아니면
            if (temp[newR][newC] == -1) {
                temp[r][c] = 0;
            }
            else if (temp[r][c] != -1) {
                // 순환
                temp[r][c] = temp[newR][newC];
            }

            // 다시 돌아오면
            if (newR == limit && newC == 0) {
                // 끝
                break;
            }

            r = newR;
            c = newC;
        }

        // 아래쪽
        limit = cleaner.get(1);

        r = cleaner.get(1);
        c = 0;

        index = 0;

        while (true) {
            int newR = r + dy[index];
            int newC = c + dx[index];

            // 범위 나가면
            if (newR < limit || newR >= R || newC >= C || newC < 0) {
                // 방향 바꾸고
                index = (index + 1) % 4;

                // 다시 하기
                continue;
            }

            // 범위 안나가면
            // 공기 청정기에 들어가는거 아니면
            if (temp[newR][newC] == -1) {
                temp[r][c] = 0;
            }
            else if (temp[r][c] != -1) {
                // 순환
                temp[r][c] = temp[newR][newC];
            }

            // 다시 돌아오면
            if (newR == limit && newC == 0) {
                // 끝
                break;
            }

            r = newR;
            c = newC;
        }
    }
}