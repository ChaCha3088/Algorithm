import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

class Quarter {
    public int[][] map;

    public Quarter(int[][] map) {
        this.map = map;
    }
}

public class Main {
    private static int[][] arr;
    private static int direction;
    private static Quarter[] quarters;
    private static int[] instructions;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]), M = Integer.parseInt(split[1]), R = Integer.parseInt(split[2]);

        arr = new int[N + 1][M + 1];

        for (int n = 1; n <= N; n++) {
            split = br.readLine().split(" ");

            for (int s = 0; s < split.length; s++) {
                arr[n][s + 1] = Integer.parseInt(split[s]);
            }
        }

        split = br.readLine().split(" ");

        instructions = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            instructions[i] = Integer.parseInt(split[i]);
        }

        // 방향, 반전
        direction = 0;

        // 클래스 생성
        int[][] quarterMap1 = new int[N / 2 + 1][M / 2 + 1];
        int[][] quarterMap2 = new int[N / 2 + 1][M / 2 + 1];
        int[][] quarterMap3 = new int[N / 2 + 1][M / 2 + 1];
        int[][] quarterMap4 = new int[N / 2 + 1][M / 2 + 1];

        for (int y = 1; y <= N / 2; y++) {
            for (int x = 1; x <= M / 2; x++) {
                quarterMap1[y][x] = arr[y][x];
                quarterMap2[y][x] = arr[y][x + M / 2];
                quarterMap3[y][x] = arr[y + N / 2][x + M / 2];
                quarterMap4[y][x] = arr[y + N / 2][x];
            }
        }

        quarters = new Quarter[5];

        quarters[1] = new Quarter(quarterMap1);
        quarters[2] = new Quarter(quarterMap2);
        quarters[3] = new Quarter(quarterMap3);
        quarters[4] = new Quarter(quarterMap4);

        // 명령 실행
        for (int i = 0; i < instructions.length; i++) {
            // 1. 상하 반전
            if (instructions[i] == 1) {
                if (direction == 0) {
                    direction = 5;
                }
                else if (direction == 1) {
                    direction = 4;
                }
                else if (direction == 2) {
                    direction = 3;
                }
                else if (direction == 3) {
                    direction = 2;
                }
                else if (direction == 4) {
                    direction = 1;
                }
                else if (direction == 5) {
                    direction = 0;
                }
                else if (direction == 6) {
                    direction = 7;
                }
                else if (direction == 7) {
                    direction = 6;
                }

                quarters[0] = quarters[1];
                quarters[1] = quarters[4];
                quarters[4] = quarters[0];

                quarters[0] = quarters[2];
                quarters[2] = quarters[3];
                quarters[3] = quarters[0];
            }

            // 2. 좌우 반전
            else if (instructions[i] == 2) {
                if (direction == 0) {
                    direction = 1;
                }
                else if (direction == 1) {
                    direction = 0;
                }
                else if (direction == 2) {
                    direction = 7;
                }
                else if (direction == 3) {
                    direction = 6;
                }
                else if (direction == 4) {
                    direction = 5;
                }
                else if (direction == 5) {
                    direction = 4;
                }
                else if (direction == 6) {
                    direction = 3;
                }
                else if (direction == 7) {
                    direction = 2;
                }

                quarters[0] = quarters[1];
                quarters[1] = quarters[2];
                quarters[2] = quarters[0];

                quarters[0] = quarters[4];
                quarters[4] = quarters[3];
                quarters[3] = quarters[0];
            }

            // 3. 오른쪽 90도
            else if (instructions[i] == 3) {
                direction += 2;
                direction %= 8;

                quarters[0] = quarters[4];
                quarters[4] = quarters[3];
                quarters[3] = quarters[2];
                quarters[2] = quarters[1];
                quarters[1] = quarters[0];
            }

            // 4. 왼쪽 90도
            else if (instructions[i] == 4) {
                direction += 6;
                direction %= 8;

                quarters[0] = quarters[1];
                quarters[1] = quarters[2];
                quarters[2] = quarters[3];
                quarters[3] = quarters[4];
                quarters[4] = quarters[0];
            }

            // 5. 시계방향 이동
            else if (instructions[i] == 5) {
                quarters[0] = quarters[4];
                quarters[4] = quarters[3];
                quarters[3] = quarters[2];
                quarters[2] = quarters[1];
                quarters[1] = quarters[0];
            }
            // 6. 반시계방향 이동
            else if (instructions[i] == 6) {
                quarters[0] = quarters[1];
                quarters[1] = quarters[2];
                quarters[2] = quarters[3];
                quarters[3] = quarters[4];
                quarters[4] = quarters[0];
            }
        }

        // 4개의 quarter에 대해
        // 정답 배열 모양 바뀌고
        for (int i = 1; i <= 4; i++) {
            // 좌우반전
            if (direction == 1) {
                // 새 배열 생성
                int[][] newArr = new int[quarters[i].map.length][quarters[i].map[0].length];

                // 채우고
                for (int y = 1; y < quarters[i].map.length; y++) {
                    for (int x = 1; x < quarters[i].map[0].length; x++) {
                        newArr[y][x] = quarters[i].map[y][quarters[i].map[0].length - x];
                    }
                }

                // arr에 다시 할당
                quarters[i].map = newArr;
            }
            // 오른쪽으로 90도
            else if (direction == 2) {
                // 새 배열 생성
                int[][] newArr = new int[quarters[i].map[0].length][quarters[i].map.length];

                // 채우고
                for (int y = 1; y < quarters[i].map[0].length; y++) {
                    for (int x = 1; x < quarters[i].map.length; x++) {
                        newArr[y][x] = quarters[i].map[quarters[i].map.length - x][y];
                    }
                }

                // arr에 다시 할당
                quarters[i].map = newArr;
            }
            else if (direction == 3) {
                // 새 배열 생성
                int[][] newArr = new int[quarters[i].map[0].length][quarters[i].map.length];

                // 채우고
                for (int y = 1; y < quarters[i].map[0].length; y++) {
                    for (int x = 1; x < quarters[i].map.length; x++) {
                        newArr[y][x] = quarters[i].map[quarters[i].map.length - x][quarters[i].map[0].length - y];
                    }
                }

                // arr에 다시 할당
                quarters[i].map = newArr;
            }
            else if (direction == 4) {
                // 새 배열 생성
                int[][] newArr = new int[quarters[i].map.length][quarters[i].map[0].length];

                // 채우고
                for (int y = 1; y < quarters[i].map.length; y++) {
                    for (int x = 1; x < quarters[i].map[0].length; x++) {
                        newArr[y][x] = quarters[i].map[quarters[i].map.length - y][quarters[i].map[0].length - x];
                    }
                }

                // arr에 다시 할당
                quarters[i].map = newArr;
            }
            else if (direction == 5) {
                // 새 배열 생성
                int[][] newArr = new int[quarters[i].map.length][quarters[i].map[0].length];

                // 채우고
                for (int y = 1; y < quarters[i].map.length; y++) {
                    for (int x = 1; x < quarters[i].map[0].length; x++) {
                        newArr[y][x] = quarters[i].map[quarters[i].map.length - y][x];
                    }
                }

                // arr에 다시 할당
                quarters[i].map = newArr;
            }
            else if (direction == 6) {
                // 새 배열 생성
                int[][] newArr = new int[quarters[i].map[0].length][quarters[i].map.length];

                // 채우고
                for (int x = 1; x < quarters[i].map[0].length; x++) {
                    for (int y = 1; y < quarters[i].map.length; y++) {
                        newArr[x][y] = quarters[i].map[y][quarters[i].map[0].length - x];
                    }
                }

                // arr에 다시 할당
                quarters[i].map = newArr;
            }
            else if (direction == 7) {
                // 새 배열 생성
                int[][] newArr = new int[quarters[i].map[0].length][quarters[i].map.length];

                // 채우고
                for (int y = 1; y < quarters[i].map[0].length; y++) {
                    for (int x = 1; x < quarters[i].map.length; x++) {
                        newArr[y][x] = quarters[i].map[x][y];
                    }
                }

                // arr에 다시 할당
                quarters[i].map = newArr;
            }
        }

        // 출력
        for (int y = 1; y < quarters[1].map.length; y++) {
            for (int x = 1; x < quarters[1].map[0].length; x++) {
                sb.append(quarters[1].map[y][x]).append(" ");
            }
            for (int x = 1; x < quarters[1].map[0].length; x++) {
                sb.append(quarters[2].map[y][x]);
                if (x < quarters[1].map[0].length - 1) {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }

        for (int y = 1; y < quarters[1].map.length; y++) {
            for (int x = 1; x < quarters[1].map[0].length; x++) {
                sb.append(quarters[4].map[y][x]).append(" ");
            }
            for (int x = 1; x < quarters[1].map[0].length; x++) {
                sb.append(quarters[3].map[y][x]);
                if (x < quarters[1].map[0].length - 1) {
                    sb.append(" ");
                }
            }
            if (y < quarters[1].map.length - 1) {
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}