import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int test = 1; test <= T; test++) {
            Queue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
            Queue<Integer> maxHeap = new PriorityQueue<>();

            String[] s = br.readLine().split(" ");
            int N = Integer.parseInt(s[0]), A = Integer.parseInt(s[1]);

            minHeap.offer(A);

            int mid = A;
            int answer = 0;

            for (int i = 1; i <= N; i++) {
                s = br.readLine().split(" ");
                int X = Integer.parseInt(s[0]), Y = Integer.parseInt(s[1]);

                if (X < minHeap.peek() && Y < minHeap.peek()) {
                    minHeap.add(X);
                    minHeap.add(Y);

                    maxHeap.add(minHeap.poll());
                }
                else if (X > minHeap.peek() && Y > minHeap.peek()) {
                    maxHeap.add(X);
                    maxHeap.add(Y);

                    minHeap.add(maxHeap.poll());
                }
                else {
                    if (X < Y) {
                        minHeap.add(X);
                        maxHeap.add(Y);
                    }
                    else {
                        minHeap.add(Y);
                        maxHeap.add(X);
                    }
                }

                mid = minHeap.peek();
                answer = (answer + minHeap.peek()) % 20_171_109;
            }

            sb.append("#").append(test).append(" ").append(answer).append("\n");
        }

        System.out.println(sb);
    }
}