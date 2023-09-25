import java.io.*;
import java.util.*;

public class Main {
    static class Jewerly {
        private int M;
        private int V;

        public Jewerly(int M, int V) {
            this.M = M;
            this.V = V;
        }
    }

    private static StringBuilder sb = new StringBuilder();
    private static int N, K;
    private static PriorityQueue<Jewerly> arr;
    private static PriorityQueue<Integer> bags;
    private static long answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new PriorityQueue<>((o1, o2) -> {
            if (o1.M == o2.M) {
                return o2.V - o1.V;
            }
            return o1.M - o2.M;
        });
        bags = new PriorityQueue<>((o1, o2) -> {
            if (o1 >= o2) {
                return 1;
            }
            else {
                return -1;
            }
        });

        // 입력
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            arr.offer(new Jewerly(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        for (int k = 0; k < K; k++) {
            bags.offer(Integer.parseInt(br.readLine()));
        }

        PriorityQueue<Jewerly> temp = new PriorityQueue<>(((o1, o2) -> {
            if (o1.V >= o2.V) {
                return -1;
            }
            else {
                return 1;
            }
        }));
        while (!bags.isEmpty()) {
            int bag = bags.peek();

            // 보석의 무게와 같거나 작은 애들 전부 큐에 넣는다.
            while (!arr.isEmpty() && arr.peek().M <= bag) {
                temp.offer(arr.poll());
            }

            if (!temp.isEmpty()) {
                bags.poll();
                Jewerly polled = temp.poll();

                answer += polled.V;
            }
            else {
                bags.poll();
            }
        }

        System.out.println(answer);
    }
}