import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    private static StringBuffer sb = new StringBuffer();
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        double pow = Math.pow(2, N);
        int po = (int) pow;
        po -= 1;

        sb.append(po).append("\n");

        hanoi(N, 1, 2, 3);

        System.out.println(sb);
    }

    private static void hanoi(int n, int from, int by, int to) {
        if (n == 1) {
            sb.append(from).append(" ").append(to).append("\n");
        } else {
            hanoi(n - 1, from, to, by);
            sb.append(from).append(" ").append(to).append("\n");
            hanoi(n - 1, by, from, to);
        }
    }

}