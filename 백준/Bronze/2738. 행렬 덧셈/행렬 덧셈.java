import java.io.*;

public class Main {

    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N * M 크기의 두 행렬 A와 B가 주어졌을 때, 두 행렬을 더하는 프로그램을 작성
        String[] split = br.readLine().split(" ");

        int N = Integer.valueOf(split[0]);
        int M = Integer.valueOf(split[1]);

        arr = new int[N][M];

        for (int k = 0; k < 2; k++) {
            for (int i = 0; i < N; i++) {
                String[] split1 = br.readLine().split(" ");

                for (int j = 0; j < M; j++) {
                    arr[i][j] += Integer.valueOf(split1[j]);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            String line = "";

            for (int j = 0; j < arr[i].length; j++) {
                line += (arr[i][j]);
                if (j < arr[i].length - 1) {
                    line += " ";
                }
            }

            System.out.println(line);
        }
    }
}