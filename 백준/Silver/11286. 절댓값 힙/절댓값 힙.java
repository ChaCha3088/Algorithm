import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

class Main {
    private static int N;
    private static Queue<Long> pq1 = new PriorityQueue<>();
    private static Queue<Long> pq2 = new PriorityQueue<>(Collections.reverseOrder());
    private static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int n = 0; n < N; n++) {
            long input = Long.parseLong(br.readLine());

            if (input == 0) {
                if (pq1.isEmpty() && pq2.isEmpty()) {
                    sb.append(0).append("\n");
                }
                else if (pq1.isEmpty()) {
                    sb.append(pq2.poll()).append("\n");
                }
                else if (pq2.isEmpty()) {
                    sb.append(pq1.poll()).append("\n");
                }
                else {
                    long a = Math.abs(pq1.peek());
                    long b = Math.abs(pq2.peek());
                    if (a < b) {
                        sb.append(pq1.poll()).append("\n");
                    }
                    else if (a >= b) {
                        sb.append(pq2.poll()).append("\n");
                    }
                }
            }
            else {
                if (input >= 1) {
                    pq1.offer(input);
                }
                else {
                    pq2.offer(input);
                }
            }
        }

        System.out.println(sb);
    }
}