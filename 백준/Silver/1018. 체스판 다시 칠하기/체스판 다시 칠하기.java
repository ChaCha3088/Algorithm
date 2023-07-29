import java.io.*;

public class Main {

    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 이 보드를 잘라서 8×8 크기의 체스판으로 만들려고 한다.

        // 체스판을 색칠하는 경우는 두 가지뿐

        // 다시 칠해야 하는 정사각형의 최소 개수를 구하는 프로그램

        String[] nAndM = br.readLine().split(" ");
        int N = Integer.valueOf(nAndM[0]);
        int M = Integer.valueOf(nAndM[1]);

        arr = new int[N][M];

        int minValue = Integer.MAX_VALUE;

        // 입력
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");

            for (int j = 0; j < M; j++) {
                if (split[j].equals("W")) {
                    arr[i][j] = 1;
                }
                else {
                    arr[i][j] = 0;
                }
            }
        }

        for (int y = 0; y < N - 7; y++) {
            for (int x = 0; x < M - 7; x++) {
                int result1 = count(x, y, 1);
                int result2 = count(x, y, 0);

                if (result1 < minValue) {
                    minValue = result1;
                }

                if (result2 < minValue) {
                    minValue = result2;
                }
            }
        }

        System.out.println(minValue);
    }

    private static int count(int x, int y, int initial) {
        int initialValue = initial;
        int countOfWhatToPaint = 0;

        for (int j = y; j < y + 8; j++) {
            for (int i = x; i < x + 8; i++) {
                if (arr[j][i] != initialValue) {
                    countOfWhatToPaint += 1;
                }

                if (i != x + 7) {
                    if (initialValue == 1) {
                        initialValue = 0;
                    } else {
                        initialValue = 1;
                    }
                }
            }
        }

        return countOfWhatToPaint;
    }
}