import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

class Main {
    private static int N;
    private static Queue<Long> pq1 = new PriorityQueue<>();
    private static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int n = 0; n < N; n++) {
            long input = Long.parseLong(br.readLine());

            if (input < 1) {
                if (pq1.isEmpty()) {
                    sb.append(0).append("\n");
                }
                else {
                    sb.append(pq1.poll()).append("\n");
                }
            }
            else {
                pq1.offer(input);
            }
        }

        System.out.println(sb);
    }
}