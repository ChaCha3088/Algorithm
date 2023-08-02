import java.io.*;

public class Main {
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        arr = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            s = br.readLine().split(" ");

            for (int j = 1; j <= N; j++) {
                arr[i][j] = arr[i][j - 1] + arr[i - 1][j] + Integer.parseInt(s[j - 1]) - arr[i - 1][j - 1];
            }
        }

        for (int i = 1; i <= M; i++) {
            s = br.readLine().split(" ");

            int y1 = Integer.parseInt(s[0]);
            int x1 = Integer.parseInt(s[1]);
            int y2 = Integer.parseInt(s[2]);
            int x2 = Integer.parseInt(s[3]);

            sb.append(arr[y2][x2] - arr[y1 - 1][x2] - arr[y2][x1 - 1] + arr[y1 - 1][x1 - 1]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}