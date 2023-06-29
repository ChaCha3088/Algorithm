import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    enum Player {
        A, B
    }

    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        switch (A) {
            case 1:
                if (B == 2) {
                    sb.append(Player.B);
                } else if (B == 3) {
                    sb.append(Player.A);
                }
            case 2:
                if (B == 1) {
                    sb.append(Player.A);
                } else if (B == 3) {
                    sb.append(Player.B);
                }
            case 3:
                if (B == 1) {
                    sb.append(Player.B);
                } else if (B == 2) {
                    sb.append(Player.A);
                }
        }

        //출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}