import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    private static int N;
    private static boolean[][] arr;
    private static int[] maxResults;
    private static Deque<int[]> candidates = new ArrayDeque<>();
    private static boolean[][] visited;
    private static int coreCount;
    private static int sumOfLines;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {1, -1, 0, 0};
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());

            arr = new boolean[N + 1][N + 1];
            candidates.clear();
            visited = new boolean[N + 1][N + 1];
            coreCount = 0;
            sumOfLines = 0;

            // 최대값 결과 배열 초기화
            maxResults = new int[N * N + 1];
            Arrays.fill(maxResults, Integer.MAX_VALUE);

            // 입력
            for (int n = 1; n <= N; n++) {
                st = new StringTokenizer(br.readLine());

                for (int m = 1; m <= N; m++) {
                    if (Integer.parseInt(st.nextToken()) == 1) {
                        arr[n][m] = true;
                        visited[n][m] = true;

                        // 후보군 따로 기록
                        if (n >= 2 && n <= N - 1 && m >= 2 && m <= N - 1) {
                            candidates.offerLast(new int[]{n, m});
                        }
                        if (n == 1 || n == N || m == 1 || m == N) {
                            coreCount += 1;
                        }
                    }
                }
            }

            // 후보군에 있는 것들 dfs로 시작
            // 선택지가 상하좌우, 아무것도 안하는거
            int[] poll = candidates.pollFirst();
            dfs(poll[0], poll[1]);

            sb.append("#").append(t).append(" ");

            for (int n = N * N; n >= 1; n--) {
                if (maxResults[n] < Integer.MAX_VALUE) {
                    sb.append(maxResults[n]).append("\n");
                    break;
                }
            }
        }

        System.out.println(sb);
    }

    private static void dfs(int y, int x) {
        boolean atLeastOnce = false;

        // 기록했다가
        // 다시 돌아오는거로
        for (int i = 0; i < 4; i++) {
            List<int[]> result = connect(y, dy[i], x, dx[i]);
            // 성공했으면
            if (result.size() >= 1) {
                // 기록
                for (int[] coord : result) {
                    visited[coord[0]][coord[1]] = true;
                }

                atLeastOnce = true;
                sumOfLines += result.size();
                coreCount += 1;

                if (!candidates.isEmpty()) {
                    int[] poll = candidates.pollFirst();
                    dfs(poll[0], poll[1]);
                    candidates.offerFirst(poll);
                }
                else {
                    // 후보군이 더이상 없는 경우
                    if (maxResults[coreCount] > sumOfLines) {
                        maxResults[coreCount] = sumOfLines;
                    }
                }

                // 기록 지우고
                for (int[] coord : result) {
                    visited[coord[0]][coord[1]] = false;
                }

                coreCount -= 1;
                sumOfLines -= result.size();
            }
        }

        // 모든 시도가 실패했지만, 후보군이 남아있는 경우
        if (candidates.size() >= 1) {
            // 다음거 확인
            int[] poll = candidates.pollFirst();
            dfs(poll[0], poll[1]);
            candidates.offerFirst(poll);
        }
        // 모든 시도도 실패, 후보군도 없는 경우
        else if (!atLeastOnce && candidates.size() == 0) {
            if (maxResults[coreCount] > sumOfLines) {
                maxResults[coreCount] = sumOfLines;
            }
        }
    }

    private static List<int[]> connect(int y, int dy, int x, int dx) {
        List<int[]> result = new ArrayList<>();

        boolean isSuccess = false;
        int currentX = x;
        int currentY = y;
        int lineCount = 0;

        // while 문으로 확인해보고
        if (dy == 1) {
            while (currentY < N) {
                currentY += dy;
                
                // 코어가 있으면 실패
                if (arr[currentY][currentX]) {
                    break;
                }
                
                // 방문 기록이 있으면 실패
                if (visited[currentY][currentX]) {
                    break;
                }
                
                result.add(new int[]{currentY, currentX});

                // 끝까지 확인했는데 살아남은거면
                if (currentY == N) {
                    // 성공
                    isSuccess = true;
                }
            }
        }
        else if (dy == -1) {
            while (currentY > 1) {
                currentY += dy;

                // 코어가 있으면 실패
                if (arr[currentY][currentX]) {
                    break;
                }

                // 방문 기록이 있으면 실패
                if (visited[currentY][currentX]) {
                    break;
                }

                result.add(new int[]{currentY, currentX});

                // 끝까지 확인했는데 살아남은거면
                if (currentY == 1) {
                    // 성공
                    isSuccess = true;
                }
            }
        }
        else if (dx == 1) {
            while (currentX < N) {
                currentX += dx;

                // 코어가 있으면 실패
                if (arr[currentY][currentX]) {
                    break;
                }

                // 방문 기록이 있으면 실패
                if (visited[currentY][currentX]) {
                    break;
                }

                result.add(new int[]{currentY, currentX});

                // 끝까지 확인했는데 살아남은거면
                if (currentX == N) {
                    // 성공
                    isSuccess = true;
                }
            }
        }
        else if (dx == -1) {
            while (currentX > 1) {
                currentX += dx;

                // 코어가 있으면 실패
                if (arr[currentY][currentX]) {
                    break;
                }

                // 방문 기록이 있으면 실패
                if (visited[currentY][currentX]) {
                    break;
                }

                result.add(new int[]{currentY, currentX});

                // 끝까지 확인했는데 살아남은거면
                if (currentX == 1) {
                    // 성공
                    isSuccess = true;
                }
            }
        }
        
        // 성공했으면
        if (!isSuccess) {
            result.clear();
        }

        return result;
    }
}