import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    private static StringBuilder sb = new StringBuilder();
    private static int T, K;
    private static Gear[] gears = new Gear[5];
    private static boolean[] isTurnable;
    private static boolean[] directions = new boolean[5];
    private static boolean[] visited;
    private static int answer;

    static class Gear {
        private int firstIndex = 0;
        private boolean[] arr;

        public Gear(boolean[] arr) {
            this.arr = arr;
        }

        public boolean getRightGear() {
            return this.arr[(firstIndex + 2) % 8];
        }

        public boolean getLeftGear() {
            return this.arr[(firstIndex + 6) % 8];
        }

        public void turnClockwise() {
            this.firstIndex = (this.firstIndex + 7) % 8;
        }

        public void turnCounterClockwise() {
            this.firstIndex = (this.firstIndex + 1) % 8;
        }

        public boolean getFirstIndex() {
            return this.arr[this.firstIndex];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            K = Integer.parseInt(br.readLine());

            answer = 0;

            // 입력
            for (int i = 1; i <= 4; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                boolean[] array = new boolean[8];
                for (int j = 0; j < 8; j++) {
                    int number = Integer.parseInt(st.nextToken());

                    if (number == 0) {
                        array[j] = true;
                    }
                }

                gears[i] = new Gear(array);
            }

            for (int k = 0; k < K; k++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                int number = Integer.parseInt(st.nextToken());
                int direction = Integer.parseInt(st.nextToken());

                visited = new boolean[5];
                directions = new boolean[5];
                isTurnable = new boolean[5];

                // 회전방향
                setTurningDirection(number, direction);

                // 돌아가는지 확인
                visited[number] = true;
                checkTurnable(number);

                // 돌리기
                turn();
            }

            // 모든 회전 후, 점수 계산
            for (int i = 1; i <= 4; i++) {
                if (!gears[i].getFirstIndex()) {
                    answer += Math.pow(2, i - 1);
                }
            }

            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }

        System.out.println(sb);
    }

    private static void checkTurnable(int index) {
        isTurnable[index] = true;

        if (2 <= index && index <= 3) {
            // 왼쪽
            if (!visited[index - 1]) {
                // 왼쪽 기어랑
                if (gears[index].getLeftGear() != gears[index - 1].getRightGear()){
                    visited[index - 1] = true;
                    checkTurnable(index - 1);
                }
            }

            // 오른쪽
            if (!visited[index + 1]) {
                // 오른쪽 기어랑
                if (gears[index].getRightGear() != gears[index + 1].getLeftGear()){
                    visited[index + 1] = true;
                    checkTurnable(index + 1);
                }
            }
        }
        else if (index == 1) {
            // 오른쪽
            if (!visited[index + 1]) {
                // 오른쪽 기어랑
                if (gears[index].getRightGear() != gears[index + 1].getLeftGear()){
                    visited[index + 1] = true;
                    checkTurnable(index + 1);
                }
            }
        }
        else if (index == 4) {
            // 왼쪽
            if (!visited[index - 1]) {
                // 왼쪽 기어랑
                if (gears[index].getLeftGear() != gears[index - 1].getRightGear()){
                    visited[index - 1] = true;
                    checkTurnable(index - 1);
                }
            }
        }
    }

    private static void setTurningDirection(int gearNumber, int firstDirection) {
        boolean direction = false;

        if (firstDirection == 1) {
            direction = true;
        }

        int count = 0;
        while (true) {
            directions[gearNumber] = direction;

            if (direction) {
                direction = false;
            }
            else {
                direction = true;
            }

            if (count >= 3) {
                break;
            }

            gearNumber += 1;

            if (gearNumber == 5) {
                gearNumber = 1;
            }

            count += 1;
        }
    }

    private static void turn() {
        // 1 ~ 4 돌면서
        // index 돌려줌

        for (int i = 1; i <= 4; i++) {
            if (isTurnable[i]) {
                if (directions[i]) {
                    gears[i].turnClockwise();
                }
                else {
                    gears[i].turnCounterClockwise();
                }
            }
        }
    }
}