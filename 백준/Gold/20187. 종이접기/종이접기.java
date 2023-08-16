import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        int K = Integer.parseInt(br.readLine());
        String[] commands = br.readLine().split(" ");
        int H = Integer.parseInt(br.readLine());

        Deque<String> deque = new ArrayDeque();

        int x = 1;
        int y = 1;
        int xLength = (int) Math.pow(2, K);
        int yLength = (int) Math.pow(2, K);

        arr = new int[yLength + 1][xLength + 1];

        for (int i = 0; i < commands.length; i++) {
            deque.offerLast(commands[i]);

            if (commands[i].equals("U")) {
                yLength /= 2;

                y += yLength;
            }
            else if (commands[i].equals("D")) {
                yLength /= 2;
            }
            else if (commands[i].equals("L")) {
                xLength /= 2;
            }
            else if (commands[i].equals("R")) {
                xLength /= 2;

                x += xLength;
            }
        }

        // 처음 구멍 뚫기
        arr[y][x] = H;

        while (!deque.isEmpty()) {
            String polled = deque.pollLast();

            if (xLength == 1 && yLength == 1) {
                if (polled.equals("D")) {
                    arr[y + 1][x] = (H + 2) % 4;

                    yLength *= 2;
                }
                else if (polled.equals("U")) {
                    arr[y - 1][x] = (H + 2) % 4;

                    y -= yLength;

                    yLength *= 2;
                }
                else if (polled.equals("R")) {
                    if (H == 0) {
                        arr[y][x - 1] = 1;
                    }
                    else if (H == 1) {
                        arr[y][x - 1] = 0;
                    }
                    else if (H == 2) {
                        arr[y][x - 1] = 3;
                    }
                    else if (H == 3) {
                        arr[y][x - 1] = 2;
                    }

                    x -= xLength;

                    xLength *= 2;
                }
                else if (polled.equals("L")) {
                    if (H == 0) {
                        arr[y][x - 1] = 1;
                    }
                    else if (H == 1) {
                        arr[y][x - 1] = 0;
                    }
                    else if (H == 2) {
                        arr[y][x - 1] = 3;
                    }
                    else if (H == 3) {
                        arr[y][x - 1] = 2;
                    }

                    xLength *= 2;
                }
            }
            else if (xLength < 2 || yLength < 2) {
                if (polled.equals("D")) {
                    for (int dy = 0; dy < yLength; dy++) {
                        for (int dx = 0; dx < xLength; dx++) {
                            if (xLength > yLength) {
                                arr[y + dy + yLength][x + dx] = (arr[y + dy][x + dx] + 2) % 4;
                            }
                            else {
                                arr[y + dy + yLength][x + dx] = arr[y + dy][x + dx];
                            }
                        }
                    }

                    yLength *= 2;
                }
                else if (polled.equals("U")) {
                    for (int dy = 0; dy < yLength; dy++) {
                        for (int dx = 0; dx < xLength; dx++) {
                            if (xLength > yLength) {
                                arr[y + dy - yLength][x + dx] = (arr[y + dy][x + dx] + 2) % 4;
                            }
                            else {
                                arr[y + dy - yLength][x + dx] = arr[y + dy][x + dx];
                            }
                        }
                    }

                    y -= yLength;

                    yLength *= 2;
                }
                else if (polled.equals("L")) {
                    for (int dy = 0; dy < yLength; dy++) {
                        for (int dx = 0; dx < xLength; dx++) {
                            if (xLength < yLength) {
                                if (arr[y + dy][x + dx] == 0) {
                                    arr[y + dy][x + dx + xLength] = 1;
                                } else if (arr[y + dy][x + dx] == 1) {
                                    arr[y + dy][x + dx + xLength] = 0;
                                } else if (arr[y + dy][x + dx] == 2) {
                                    arr[y + dy][x + dx + xLength] = 3;
                                } else if (arr[y + dy][x + dx] == 3) {
                                    arr[y + dy][x + dx + xLength] = 2;
                                }
                            }
                            else {
                                arr[y + dy][x + dx + xLength] = arr[y + dy][x + dx];
                            }
                        }
                    }

                    xLength *= 2;
                }
                else if (polled.equals("R")) {
                    for (int dy = 0; dy < yLength; dy++) {
                        for (int dx = 0; dx < xLength; dx++) {
                            if (xLength < yLength) {
                                if (arr[y + dy][x + dx] == 0) {
                                    arr[y + dy][x + dx - xLength] = 1;
                                } else if (arr[y + dy][x + dx] == 1) {
                                    arr[y + dy][x + dx - xLength] = 0;
                                } else if (arr[y + dy][x + dx] == 2) {
                                    arr[y + dy][x + dx - xLength] = 3;
                                } else if (arr[y + dy][x + dx] == 3) {
                                    arr[y + dy][x + dx - xLength] = 2;
                                }
                            }
                            else {
                                arr[y + dy][x + dx - xLength] = arr[y + dy][x + dx];
                            }
                        }
                    }

                    x -= xLength;
                    xLength *= 2;
                }
            }
            else {
                if (polled.equals("D")) {
                    for (int dy = 0; dy < yLength; dy++) {
                        for (int dx = 0; dx < xLength; dx++) {
                            arr[y + dy + yLength][x + dx] = arr[y + dy][x + dx];
                        }
                    }

                    yLength *= 2;
                }
                else if (polled.equals("U")) {
                    for (int dy = 0; dy < yLength; dy++) {
                        for (int dx = 0; dx < xLength; dx++) {
                            arr[y + dy - yLength][x + dx] = arr[y + dy][x + dx];
                        }
                    }

                    y -= yLength;

                    yLength *= 2;
                }
                else if (polled.equals("L")) {
                    for (int dy = 0; dy < yLength; dy++) {
                        for (int dx = 0; dx < xLength; dx++) {
                            arr[y + dy][x + dx + xLength] = arr[y + dy][x + dx];
                        }
                    }

                    xLength *= 2;
                }
                else if (polled.equals("R")) {
                    for (int dy = 0; dy < yLength; dy++) {
                        for (int dx = 0; dx < xLength; dx++) {
                            arr[y + dy][x + dx - xLength] = arr[y + dy][x + dx];
                        }
                    }

                    x -= xLength;
                    xLength *= 2;
                }
            }
        }

        for (int b = yLength; b >= 1; b--) {
            for (int a = 1; a <= xLength; a++) {
                sb.append(arr[b][a]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}