import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;


public class Solution {
    private static StringBuilder sb = new StringBuilder();
    private static int N, W, H;
    private static int[][] map;
    private static int[][] tempMap;
    private static int[] whereToDrop;
    private static int result, countOfBrokenBricks;
    private static int countOfBricks;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            map = new int[H][W];
            whereToDrop = new int[N];

            countOfBricks = 0;
            result = 0;

            // 입력
            for (int h = 0; h < H; h++) {
                st = new StringTokenizer(br.readLine());

                for (int w = 0; w < W; w++) {
                    map[H - h - 1][w] = Integer.parseInt(st.nextToken());

                    if (map[H - h - 1][w] > 0) {
                        countOfBricks += 1;
                    }
                }
            }

            // 구슬 떨어뜨릴 위치 선정
            chooseWhereToDrop(0);

            sb.append("#").append(t).append(" ").append(countOfBricks - result).append("\n");
        }

        System.out.println(sb);
    }

    private static void chooseWhereToDrop(int ballNumber) {
        if (ballNumber == N) {
            startGame();
            return;
        }

        for (int i = 0; i < W; i++) {
            whereToDrop[ballNumber] = i;

            // 다음 구슬 선택
            chooseWhereToDrop(ballNumber + 1);
        }
    }

    private static void startGame() {
        // 지도 초기화 및 복사
        tempMap = new int[H][W];
        for (int i = 0; i < H; i++) {
            tempMap[i] = map[i].clone();
        }

        countOfBrokenBricks = 0;
        for (int ballNumber = 0; ballNumber < N; ballNumber++) {
            // 고른 곳에
            for (int j = 0; j < H; j++) {
                // 벽돌이 있으면
                if (tempMap[H - j - 1][whereToDrop[ballNumber]] != 0) {
                    // 부순다.
                    destroy(H - j - 1, whereToDrop[ballNumber]);
                    // 부수면 끝.
                    break;
                }
            }

            // 벽을 부수고, 벽돌을 떨어뜨린다.
            dropBricks();
        }

        result = Math.max(result, countOfBrokenBricks);
    }

    private static void destroy(int y, int x) {
        // 부수는 범위
        int range = tempMap[y][x] - 1;

        // 부순 벽돌 개수 업데이트
        countOfBrokenBricks += 1;

        // 부순 벽돌 업데이트
        tempMap[y][x] = 0;

        // 상하좌우로
        for (int i = 0; i < 4; i++) {
            // 범위
            for (int j = 1; j <= range; j++) {
                int newX = x + dx[i] * j;
                int newY = y + dy[i] * j;

                // 범위 안에 있을 때
                if (newY >= 0 && newY < H && newX >= 0 && newX < W) {
                    // 부술 벽돌이 있으면
                    if (tempMap[newY][newX] != 0) {
                        // 부순다.
                        destroy(newY, newX);
                    }
                }
            }
        }
    }

    private static void dropBricks() {
        for (int h = 1; h < H; h++) {
            for (int w = 0; w < W; w++) {
                // 떨어질게 있으면
                if (tempMap[h][w] != 0 && tempMap[h - 1][w] == 0) {
                    // 떨어질 y좌표를 구한다.
                    int y = h;

                    for (int k = h - 1; k >= 0; k--) {
                        // 아래 뭐가 있으면 끝
                        if (tempMap[k][w] != 0) {
                            break;
                        }
                        y = k;
                    }

                    // 벽돌 이동
                    tempMap[y][w] = tempMap[h][w];

                    // 벽돌 없애기
                    tempMap[h][w] = 0;
                }
            }
        }
    }
}