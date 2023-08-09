import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");

        int yLength = Integer.parseInt(split[0]), xLength = Integer.parseInt(split[1]), R = Integer.parseInt(split[2]);

        // 배열 초기화
        arr = new int[yLength + 1][xLength + 1];

        // 배열 입력
        for (int n = 1; n <= yLength; n++) {
            split = br.readLine().split(" ");

            for (int s = 1; s <= split.length; s++) {
                arr[n][s] = Integer.parseInt(split[s - 1]);
            }
        }

        // 새 배열 변수 선언
        int[][] newArr;

        split = br.readLine().split(" ");
        for (int r = 0; r < split.length; r++) {
            yLength = arr.length - 1;
            xLength = arr[0].length - 1;

            switch (Integer.parseInt(split[r])) {
                default:
                    newArr = new int[1][1];

                // 상하 반전
                case 1:
                    // 새 배열 초기화
                    newArr = new int[yLength + 1][xLength + 1];

                    for (int y = 1; y <= yLength; y++) {
                        for (int x = 1; x <= xLength; x++) {
                            newArr[y][x] = arr[yLength - y + 1][x];
                        }
                    }

                    break;

                // 좌우 반전
                case 2:
                    // 새 배열 초기화
                    newArr = new int[yLength + 1][xLength + 1];

                    for (int y = 1; y <= yLength; y++) {
                        for (int x = 1; x <= xLength; x++) {
                            newArr[y][x] = arr[y][xLength - x + 1];
                        }
                    }

                    break;

                // 오른쪽으로 90도
                case 3:
                    // 새 배열 초기화
                    newArr = new int[xLength + 1][yLength + 1];

                    for (int x = 1; x <= xLength; x++) {
                        for (int y = 1; y <= yLength; y++) {
                            newArr[x][y] = arr[yLength - y + 1][x];
                        }
                    }

                    break;

                // 왼쪽으로 90도
                case 4:
                    // 새 배열 초기화
                    newArr = new int[xLength + 1][yLength + 1];

                    for (int x = 1; x <= xLength; x++) {
                        for (int y = 1; y <= yLength; y++) {
                            newArr[x][y] = arr[y][xLength - x + 1];
                        }
                    }

                    break;

                // 돌리기
                case 5:
                    // 새 배열 초기화
                    newArr = new int[yLength + 1][xLength + 1];

                    // 4 -> 1
                    for (int y = 1; y <= yLength / 2; y++) {
                        for (int x = 1; x <= xLength / 2; x++) {
                            newArr[y][x] = arr[y + yLength / 2][x];
                        }
                    }

                    // 1 - > 2
                    for (int y = 1; y <= yLength / 2; y++) {
                        for (int x = xLength / 2 + 1; x <= xLength; x++) {
                            newArr[y][x] = arr[y][x - xLength / 2];
                        }
                    }

                    // 2 -> 3
                    for (int y = yLength / 2 + 1; y <= yLength; y++) {
                        for (int x = xLength / 2 + 1; x <= xLength; x++) {
                            newArr[y][x] = arr[y - arr.length / 2][x];
                        }
                    }

                    // 3 -> 4
                    for (int y = yLength / 2 + 1; y <= yLength; y++) {
                        for (int x = 1; x <= xLength / 2; x++) {
                            newArr[y][x] = arr[y][x + xLength / 2];
                        }
                    }

                    break;

                case 6:
                    // 새 배열 초기화
                    newArr = new int[yLength + 1][xLength + 1];

                    // 2 -> 1
                    for (int y = 1; y <= yLength / 2; y++) {
                        for (int x = 1; x <= xLength / 2; x++) {
                            newArr[y][x] = arr[y][x + xLength / 2];
                        }
                    }

                    // 3 -> 2
                    for (int y = 1; y <= yLength / 2; y++) {
                        for (int x = xLength / 2 + 1; x <= xLength; x++) {
                            newArr[y][x] = arr[y + yLength / 2][x];
                        }
                    }

                    // 4 -> 3
                    for (int y = yLength / 2 + 1; y <= yLength; y++) {
                        for (int x = xLength / 2 + 1; x <= xLength; x++) {
                            newArr[y][x] = arr[y][x - xLength / 2];
                        }
                    }

                    // 1 -> 4
                    for (int y = yLength / 2 + 1; y <= yLength; y++) {
                        for (int x = 1; x <= xLength / 2; x++) {
                            newArr[y][x] = arr[y - yLength / 2][x];
                        }
                    }

                    break;
            }

            arr = newArr;
        }

        yLength = arr.length - 1;
        xLength = arr[0].length - 1;

        for (int b = 1; b <= yLength; b++) {
            for (int a = 1; a <= xLength; a++) {
                sb.append(arr[b][a]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}