import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

class Main {
    private static int N;
    private static Queue<Integer> pq = new PriorityQueue<>();
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int n = 0; n < N; n++) {
            int input = Integer.parseInt(br.readLine());

            pq.offer(input);
        }

        while (pq.size() >= 2) {
            int first = pq.poll();
            int second = pq.poll();

            int sum = first + second;

            answer += sum;

            pq.offer(sum);
        }

        System.out.println(answer);
    }
}