import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 손님들은 호텔 정문으로부터 걸어서 가장 짧은 거리에 있는 방을 선호

        // 각 층에 W 개의 방이 있는 H 층 건물
        // 엘리베이터는 가장 왼쪽에 있다.

        // 거리가 같으면, 엘리베이터 안타는게 먼저

        // 방 번호는 YXX 나 YYXX
        // Y 나 YY 는 층 수

        // N 번째로 도착한 손님에게 배정될 방 번호

        int T = Integer.valueOf(br.readLine());

        for (int i = 1; i <= T; i++) {
            String[] split = br.readLine().split(" ");
            int H = Integer.valueOf(split[0]);
            int W = Integer.valueOf(split[1]);
            int N = Integer.valueOf(split[2]); // 몇 번째 손님


            int y = N % H;

            int x;

            if (y == 0) {
                x = Integer.valueOf(N / H);
                y = H;
            }
            else {
                x = 1 + Integer.valueOf(N / H);
            }

            String answer = String.valueOf(y);

            if (x < 10) {
                answer += ("0" + x);
            }
            else {
                answer += x;
            }

            System.out.println(answer);
        }
    }
}