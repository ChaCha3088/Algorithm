import java.io.*;
import java.util.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, -1, 0, 1};
    private static int r;
    private static int c;
    private static int[][] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        int x = Math.max(Math.abs(c2), Math.abs(c1));
        int y = Math.max(Math.abs(r2), Math.abs(r1));
        int length = Math.max(x, y);
        int newlength = (length * 2) + 1;

        int diffX = c2 - c1 + 1;
        int diffY = r2 - r1 + 1;

        int howMany = newlength * newlength;

        answer = new int[r2 - r1 + 1][c2 -c1 + 1];

        r = 0;
        c = 0;

        int i = 1;
        int directionPointer = 0;
        int chargingCount = 1;
        int historyOfCharging = 1;
        int chargingAmout = 1;

        int maxValue = 0;

        // 정사각형 채우기
        while (i <= howMany) {
            // 범위 안에 들어오면 i 넣음
            if (r1 <= r && r <= r2 && c1 <= c && c <= c2) {
                answer[r - r1][c - c1] = i;

                if (i > maxValue) {
                    maxValue = i;
                }
            }

            chargingAmout -= 1;
            r += dy[directionPointer];
            c += dx[directionPointer];

            if (chargingAmout == 0) {
                if (chargingCount >= 1) {
                    chargingCount -= 1;
                }
                else {
                    chargingCount += 1;
                    historyOfCharging += 1;
                }

                chargingAmout += historyOfCharging;

                directionPointer = (directionPointer + 1) % 4;
            }

            i += 1;
        }

        // howMany의 자리수를 통해 최대 몇 자인지 확인
        int howLong = (int) Math.floor(Math.log10(maxValue)) + 1;

        // 범위에 맞게
        for (int row = 0; row < answer.length; row++) {
            for (int col = 0; col < answer[0].length; col++) {
                int number = answer[row][col];

                int lengthOfNumber = (int) Math.floor(Math.log10(number));

                if (lengthOfNumber + 1 < howLong) {
                    for (int j = 0; j < howLong - lengthOfNumber - 1; j++) {
                        sb.append(" ");
                    }
                }

                sb.append(number);

                if (col < answer[0].length - 1) {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}