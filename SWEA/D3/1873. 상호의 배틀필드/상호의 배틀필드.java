import java.io.*;

public class Solution {
    private static String[][] arr;
    private static int x;
    private static int y;
    private static int direction;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test = 1; test <= T; test++) {
            String[] split = br.readLine().split(" ");
            int H = Integer.parseInt(split[0]), W = Integer.parseInt(split[1]);

            arr = new String[H + 2][W + 2];

            for (int h = 1; h <= H; h++) {
                split = br.readLine().split("");

                for (int s = 1; s <= split.length; s++) {
                    arr[h][s] = split[s - 1];

                    // 처음 위치
                    if (split[s - 1].equals("^") || split[s - 1].equals("v") || split[s - 1].equals("<") || split[s - 1].equals(">")) {
                        x = s;
                        y = h;

                        if (split[s - 1].equals("^")) {
                            direction = 0;
                        }
                        else if (split[s - 1].equals("v")) {
                            direction = 2;
                        }
                        else if (split[s - 1].equals("<")) {
                            direction = 3;
                        }
                        else if (split[s - 1].equals(">")) {
                            direction = 1;
                        }
                    }
                }
            }

            int N = Integer.parseInt(br.readLine());

            split = br.readLine().split("");
            for (int s = 0; s < N; s++) {
                if (split[s].equals("U")) {
                    move(0);
                }
                else if (split[s].equals("D")) {
                    move(2);
                }
                else if (split[s].equals("L")) {
                    move(3);
                }
                else if (split[s].equals("R")) {
                    move(1);
                }
                else if (split[s].equals("S")) {
                    shoot();
                }

                // 마지막 명령 후에 탱크 놓기
                if (s == N - 1) {
                    if (direction == 0) {
                        arr[y][x] = "^";
                    }
                    else if (direction == 2) {
                        arr[y][x] = "v";
                    }
                    else if (direction == 1) {
                        arr[y][x] = ">";
                    }
                    else if (direction == 3) {
                        arr[y][x] = "<";
                    }
                }
            }

            sb.append("#").append(test).append(" ");
            for (int b = 1; b <= H; b++) {
                for (int a = 1; a <= W; a++) {
                    sb.append(arr[b][a]);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
    private static void move(int direct) {
        int dx;
        int dy;

        if (direct == 0) {
            dx = 0;
            dy = -1;
        }
        else if (direct == 1) {
            dx = 1;
            dy = 0;
        }
        else if (direct == 2) {
            dx = 0;
            dy = 1;
        }
        else {
            dx = -1;
            dy = 0;
        }

        // 맵 범위 안에 있으면
        if (arr[y + dy][x + dx] != null) {
            // 가는 곳이 평지면
            if (arr[y + dy][x + dx].equals(".")) {
                // 지나간 곳은 평지로
                arr[y][x] = ".";

                // 움직인다.
                x += dx;
                y += dy;
            }
        }
        
        // 방향을 바꾼다.
        direction = direct;
    }

    private static void shoot() {
        int dx;
        int dy;

        if (direction == 0) {
            dx = 0;
            dy = -1;
        }
        else if (direction == 1) {
            dx = 1;
            dy = 0;
        }
        else if (direction == 2) {
            dx = 0;
            dy = 1;
        }
        else {
            dx = -1;
            dy = 0;
        }

        int missileX = x;
        int missileY = y;

        while (true) {
            // 맵 바깥으로 나가면 끝
            if (arr[missileY + dy][missileX + dx] == null) {
                break;
            }

            // 벽이거나 강철이면 끝
            if (arr[missileY + dy][missileX + dx].equals("*") || arr[missileY + dy][missileX + dx].equals("#")) {
                // 벽돌 벽이면
                if (arr[missileY + dy][missileX + dx].equals("*")) {
                    // 평지로 바뀜
                    arr[missileY + dy][missileX + dx] = ".";
                }

                break;
            }

            missileX += dx;
            missileY += dy;
        }
    }
}