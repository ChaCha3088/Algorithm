import java.io.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int N;
    private static int row;
    private static int column;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");

        N = Integer.parseInt(split[0]);
        row = Integer.parseInt(split[1]);
        column = Integer.parseInt(split[2]);

        answer = 0;

        recursive(1 << N);

        System.out.println(answer);
    }

    private static void recursive(int length) {
        int half = length / 2;
        int add = length * length / 4;

        if (row < half && column < half) {
            if (row == 0 && column == 0) {
                return;
            }
        } else if (row < half && column >= half) {
            answer += add;

            if (row == 0 && column == half) {
                return;
            }
            column -= half;
        } else if (row >= half && column < half) {
            answer += add * 2;

            if (column == 0 && row == half) {
                return;
            }
            row -= half;
        } else if (row >= half && column >= half) {
            answer += add * 3;

            if (row == half && column == half) {
                return;
            }
            row -= half;
            column -= half;
        }

        if (length <= 2) {
            return;
        }

        recursive(half);
    }
}