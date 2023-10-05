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
    private static int result, count;
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
                    map[h][w] = Integer.parseInt(st.nextToken());

                    if (map[h][w] > 0) {
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

    private static void chooseWhereToDrop(int index) {
        if (index == N) {
            dropBalls();
            return;
        }

        for (int i = 0; i < W; i++) {
            whereToDrop[index] = i;
            chooseWhereToDrop(index + 1);
        }
    }

    private static void dropBalls() {
        tempMap = new int[H][W];
        for (int i = 0; i < H; i++) {
            tempMap[i] = map[i].clone();
        }

        count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < H; j++) {
                if (tempMap[j][whereToDrop[i]] != 0) {
                    destroy(j, whereToDrop[i]);
                    break;
                }
            }

            dropBricks();
        }

        result = Math.max(result, count);
    }

    private static void destroy(int x, int y) {
        int range = tempMap[x][y] - 1;

        count += 1;
        tempMap[x][y] = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= range; j++) {
                int newX = x + dx[i] * j;
                int newY = y + dy[i] * j;

                if (newX >= 0 && newX < H && newY >= 0 && newY < W) {
                    if (tempMap[newX][newY] != 0) {
                        destroy(newX, newY);
                    }
                }
            }
        }
    }

    private static void dropBricks() {
        for (int i = H - 2; i >= 0; i--) {
            for (int j = 0; j < W; j++) {
                if (tempMap[i][j] != 0 && tempMap[i + 1][j] == 0) {
                    int x = i;

                    for (int k = i + 1; k < H; k++) {
                        if (tempMap[k][j] != 0) {
                            break;
                        }

                        x = k;
                    }

                    tempMap[x][j] = tempMap[i][j];
                    tempMap[i][j] = 0;
                }
            }
        }
    }
}