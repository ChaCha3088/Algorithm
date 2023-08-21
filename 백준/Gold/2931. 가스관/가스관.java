import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static List<int[]> result;

    private static char[][] arr;
    private static boolean[][] visited;
    private static int[] start;
    private static int previousDirection;
    private static Set<int[]> set = new HashSet<>();
    private static int[] end;

    private static int R;
    private static int C;

    private static int[] dx = new int[] {0, 0, -1, 1};
    private static int[] dy = new int[] {1, -1, 0, 0};
    private static char[] charArray = new char[] {'-', '|', '1', '2', '3', '4', '+'};
    private static int[][] info = new int[][] {{2, 3}, {0, 1}, {0, 3}, {1, 3}, {1, 2}, {0, 2}};

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        // 배열 초기화
        arr = new char [R][C];
        visited = new boolean[R][C];

        // 배열 채우기
        for (int r = 0; r < R; r++) {
            String line = br.readLine();

            for (int c = 0; c < C; c++) {
                arr[r][c] = line.charAt(c);

                // 시작, 끝 위치 저장
                if (arr[r][c] == 'M') {
                    start = new int[] {r, c};
                }
                else if (arr[r][c] == 'Z') {
                    end = new int[] {r, c};
                }
            }
        }

        // M에서 시작
        visited[start[0]][start[1]] = true;
        move(start[0], start[1]);

        // Z에서 시작
        if (!visited[end[0]][end[1]]) {
            visited[end[0]][end[1]] = true;
            move(end[0], end[1]);
        }

        //
        if (set.size() == 1) {
            move(start[0], start[1]);
        }

        // set을 list로
        result = set.stream().collect(Collectors.toList());

        decide();

        System.out.println(sb);
    }

    private static void move(int r, int c) {
        int count = 0;

        // 대상이 + 일 때
        if (arr[r][c] == '+') {
            for (int i = 0; i < 4; i++) {
                // 범위 안이고
                if (r + dy[i] < R && r + dy[i] >= 0 && c + dx[i] >= 0 && c + dx[i] < C) {
                    // .이면 좌표 기록
                    if (arr[r + dy[i]][c + dx[i]] == '.') {
                        set.add(new int[] {r, c, i});
                        visited[r + dy[i]][c + dx[i]] = true;
                    }
                    // .이 아니고, 방문한 적 없으면
                    else if (arr[r + dy[i]][c + dx[i]] != '.' && visited[r + dy[i]][c + dx[i]] == false) {
                        // 기록 남기고
                        visited[r + dy[i]][c + dx[i]] = true;

                        previousDirection = i;

                        // 방문해보기
                        move(r + dy[i], c + dx[i]);
                    }
                }
            }
        }
        // 대상이 +가 아닐 때
        else {
            int[] array = null;

            for (int i = 0; i < 6; i++) {
                if (arr[r][c] == charArray[i]) {
                    array = info[i];
                }
            }

            if (array != null) {
                for (int i = 0; i < 2; i++) {
                    int newR = r + dy[array[i]];
                    int newC = c + dx[array[i]];

                    // 범위 안이고
                    if (newR < R && newR >= 0 && newC >= 0 && newC < C) {
                        // 대상에 따라 .이면 카운트
                        if (arr[newR][newC] == '.') {
                            set.add(new int[] {r, c, array[i]});
                            visited[newR][newC] = true;
                        }
                        // .이 아니고, 방문한 적 없으면
                        else if (arr[newR][newC] != '.' && visited[newR][newC] == false) {
                            // 기록 남기고
                            visited[newR][newC] = true;

                            previousDirection = array[i];

                            // 방문해보기
                            move(newR, newC);
                        }
                    }
                }
            }
            else {
                for (int i = 0; i < 4; i++) {
                    // 범위 안이고
                    if (r + dy[i] < R && r + dy[i] >= 0 && c + dx[i] >= 0 && c + dx[i] < C) {
                        if (arr[r + dy[i]][c + dx[i]] != '.' && visited[r + dy[i]][c + dx[i]] == false) {
                            count += 1;

                            // 기록 남기고
                            visited[r + dy[i]][c + dx[i]] = true;

                            previousDirection = i;

                            // 방문해보기
                            move(r + dy[i], c + dx[i]);
                        }
                    }
                }

                if (count == 0) {
                    for (int i = 0; i < 4; i++) {
                        // 범위 안이고
                        if (r + dy[i] < R && r + dy[i] >= 0 && c + dx[i] >= 0 && c + dx[i] < C) {
                            if (arr[r + dy[i]][c + dx[i]] == '.' && visited[r + dy[i]][c + dx[i]]) {
                                count += 1;

                                // 기록 남기고
                                visited[r + dy[i]][c + dx[i]] = true;

                                previousDirection = i;

                                set.add(new int[] {r, c, i});
                            }
                        }
                    }
                }
            }


        }
    }

    private static void decide() {
        int newR = result.get(0)[0] + dy[result.get(0)[2]] + 1;
        int newC = result.get(0)[1] + dx[result.get(0)[2]] + 1;

        char block;

        // 블록 |
        if ((result.get(0)[2] == 0 && result.get(1)[2] == 1) || (result.get(0)[2] == 1 && result.get(1)[2] == 0)) {
            block = '|';
        }
        // 블록 -
        else if ((result.get(0)[2] == 2 && result.get(1)[2] == 3) || (result.get(0)[2] == 3 && result.get(1)[2] == 2)) {
            block = '-';
        }
        // 블록 1
        else if ((result.get(0)[2] == 0 && result.get(1)[2] == 2) || (result.get(0)[2] == 2 && result.get(1)[2] == 0)) {
            block = '2';
        }
        // 블록 2
        else if ((result.get(0)[2] == 1 && result.get(1)[2] == 2) || (result.get(0)[2] == 2 && result.get(1)[2] == 1)) {
            block = '1';
        }
        // 블록 3
        else if ((result.get(0)[2] == 1 && result.get(1)[2] == 3) || (result.get(0)[2] == 3 && result.get(1)[2] == 1)) {
            block = '4';
        }
        // 블록 4
        else if ((result.get(0)[2] == 0 && result.get(1)[2] == 3) || (result.get(0)[2] == 3 && result.get(1)[2] == 0)) {
            block = '3';
        }
        // 블록 +
        else {
            block = '+';
        }

        int r = result.get(0)[0] + dy[result.get(0)[2]];
        int c = result.get(0)[1] + dx[result.get(0)[2]];

        int target = 0;
        int change = 0;
        if (r + 1 < R && r + 1 >= 0) {
            target += 1;
            if ((arr[r + 1][c] == '2' || arr[r + 1][c] == '3' || arr[r + 1][c] == '|' || arr[r + 1][c] == '+')) {
                change += 1;
            }
        }

        if (r - 1 >= 0) {
            target += 1;
            if ((arr[r - 1][c] == '1' || arr[r - 1][c] == '4' || arr[r - 1][c] == '|' || arr[r - 1][c] == '+')) {
                change += 1;
            }
        }

        if (c + 1 < C) {
            target += 1;
            if ((arr[r][c + 1] == '3' || arr[r][c + 1] == '4' || arr[r][c + 1] == '-' || arr[r][c + 1] == '+')) {
                change += 1;
            }
        }

        if (c - 1 >= 0) {
            target += 1;
            if ((arr[r][c - 1] == '1' || arr[r][c - 1] == '2' || arr[r][c - 1] == '-' || arr[r][c - 1] == '+')) {
                change += 1;
            }
        }

        if (change == target && target == 4) {
            block = '+';
        }

        sb.append(newR).append(" ").append(newC).append(" ").append(block);
    }
}