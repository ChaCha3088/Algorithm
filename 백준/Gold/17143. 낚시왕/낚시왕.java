import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class Main {
    static class Shark {
        private int row;
        private int column;
        private int speed;
        private int direction;
        private int size;

        public Shark(int row, int column, int speed, int direction, int size) {
            this.row = row;
            this.column = column;
            this.speed = speed;
            this.direction = direction;
            this.size = size;
        }
    }

    private static int R, C, M;
    private static Shark[][] map;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new Shark[R + 1][C + 1];

        // 상어 생성
        for (int m = 1; m <= M; m++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            map[r][c] = new Shark(r, c, s, d, z);
        }

        for (int king = 1; king <= C; king++) {
            // 상어 잡기
            catchShark(king);


            // 상어 이동
            Queue<Shark> queue = new ArrayDeque();
            for (int i = 1; i <= R; i++) {
                for (int j = 1; j <= C; j++) {
                    if (map[i][j] != null) { // 현재 map에 있는 상어들 큐에 추가
                        queue.add(new Shark(i, j, map[i][j].speed, map[i][j].direction, map[i][j].size));
                    }
                }
            }

            // 맵 초기화
            map = new Shark[R + 1][C + 1];

            while (!queue.isEmpty()) {
                // 상어의 새로운 위치 결정
                Shark target = queue.poll();

                if (target.direction == 3) {
                    int[] ints = newLocation(target.speed, target.column, C, 1);
                    target.column = ints[0];

                    if (ints[1] == 1) {
                        target.direction = 4;
                    }
                }
                else if (target.direction == 4) {
                    int[] ints = newLocation(target.speed, target.column, C, -1);

                    target.column = ints[0];

                    if (ints[1] == 1) {
                        target.direction = 3;
                    }
                }
                else if (target.direction == 1) {
                    int[] ints = newLocation(target.speed, target.row, R, -1);

                    target.row = ints[0];

                    if (ints[1] == 1) {
                        target.direction = 2;
                    }
                }
                else if (target.direction == 2) {
                    int[] ints = newLocation(target.speed, target.row, R, 1);

                    target.row = ints[0];

                    if (ints[1] == 1) {
                        target.direction = 1;
                    }
                }

                // 그 자리에 상어가 없으면
                if (map[target.row][target.column] == null) {
                    map[target.row][target.column] = target;
                }
                // 있으면
                else {
                    Shark comparison = map[target.row][target.column];

                    // 더 큰 상어인 것을 넣는다.
                    if (comparison.size < target.size) {
                        map[target.row][target.column] = target;
                    }
                }
            }
        }

        System.out.println(answer);
    }

    private static void catchShark(int king) {
        boolean isFound = false;
        int row = -1;

        // 가장 가까운 상어 찾기
        for (int r = 1; r <= R; r++) {
            // 지도에 머가 있으면
            if (map[r][king] != null) {
                row = r;
                isFound = true;
                break;
            }
        }

        // 발견된 상어가 있으면
        if (isFound) {
            // 상어를 잡는다
            answer += map[row][king].size;
            map[row][king] = null;
        }
    }

    private static int[] newLocation(int speed, int current, int div, int direction) {
        int count = speed;
        int location = current;
        int newDirection = direction;

        while (count > 0) {
            if (location == 1 && newDirection == -1) {
                newDirection = 1;
            }
            else if (location == div && newDirection == 1) {
                newDirection = -1;
            }

            location += newDirection;

            count -= 1;
        }

        int directionChange;
        if (direction != newDirection) {
            directionChange = 1;
        }
        else {
            directionChange = 0;
        }

        return new int[] {location, directionChange};
    }
}