import java.io.*;

public class Main {

    private static int[][] arr;
    private static int answer = 0;

    private static int[][] resultArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[20][20];

        for (int i = 1; i <= 19; i++) {
            String[] split = br.readLine().split(" ");

            for (int j = 1; j <= 19; j++) {
                arr[i][j] = Integer.valueOf(split[j - 1]);
            }
        }

        for (int i = 1; i <= 19; i++) {
            boolean isFinish = false;
            for (int j = 1; j <= 19; j++) {
                if (arr[i][j] != 0) {
                    boolean result = examine(j, i, arr[i][j]);

                    if (result) {
                        isFinish = true;
                        break;
                    }
                }
            }
            if (isFinish) {
                break;
            }
        }

        System.out.println(answer);

        if (answer != 0) {
            // 가장 왼쪽 X
            int smallX = resultArr[0][0];
            int itsY = resultArr[0][1];

            for (int i = 0; i < resultArr.length; i++) {
                if (smallX > resultArr[i][0]) {
                    smallX = resultArr[i][0];
                    itsY = resultArr[i][1];
                }
            }

            System.out.println(itsY + " " + smallX);
        }
    }

    private static boolean examine(int x, int y, int target) {
        int[] dxList = new int[]{1, 0, -1};
        int[] dyList = new int[]{1, 0, -1};

        // 모든 방향으로 확인
        boolean isSuccess = false;

        for (int a = 0; a < dxList.length; a++) {
            for (int b = 0; b < dyList.length; b++) {
                int dx = dxList[a];
                int dy = dyList[b];

                if (dx == 0 && dy == 0) {
                    continue;
                }

                for (int i = 1; i <= 4; i++) {
                    int newX = x + i * dx;
                    int newY = y + i * dy;

                    // 범위 밖이면 이 방향은 실패
                    if (newX < 1 || newY < 1 || newX > 19 || newY > 19) {
                        break;
                    }

                    // 연속적인 5목 아니면 실패
                    if (arr[newY][newX] != target) {
                        break;
                    }

                    // 5목 성공
                    if (i == 4) {
                        isSuccess = true;
                        boolean isFirstOut = false;
                        boolean isSecondOut = false;

                        // 범위 나가거나
                        if (x + 5 * dx < 1 || y + 5 * dy < 1 || x + 5 * dx > 19 || y + 5 * dy > 19) {
                            isFirstOut = true;
                        }
                        // 범위 나가거나
                        if (x - dx < 1 || y - dy < 1 || x - dx > 19 || y - dy > 19) {
                            isSecondOut = true;
                        }
                        if (!isFirstOut) {
                            // 6번째나, 반대편 뒤가 하나라도 같으면
                            if (arr[y + 5 * dy][x + 5 * dx] == target) {
                                isSuccess = false;
                            }
                        }
                        if (!isSecondOut) {
                            if (arr[y - dy][x - dx] == target) {
                                isSuccess = false;
                            }
                        }
                    }
                }

                if (isSuccess) {
                    // 결과 기록
                    answer = target;
                    resultArr = new int[5][2];

                    for (int i = 0; i <= 4; i++) {
                        int newX = x + i * dx;
                        int newY = y + i * dy;

                        resultArr[i][0] = newX;
                        resultArr[i][1] = newY;
                    }
                    break;
                }
            }

            if (isSuccess) {
                break;
            }
        }

        if (isSuccess) {
            answer = target;
        }

        return isSuccess;
    }
}