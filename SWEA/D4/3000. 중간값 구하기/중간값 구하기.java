import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    private static StringBuilder sb = new StringBuilder();
    private static final int div = 20_171_109;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test = 1; test <= T; test++) {
            String[] split = br.readLine().split(" ");
            int N = Integer.parseInt(split[0]), A = Integer.parseInt(split[1]);

            Queue<Integer> leftPq = new PriorityQueue<>(Collections.reverseOrder());
            Queue<Integer> rightPq = new PriorityQueue<>();

            // 초기값을 왼쪽 pq에 넣음
            leftPq.offer(A);

            int mid = 0;

            for (int n = 1; n <= N; n++) {
                split = br.readLine().split(" ");
                int X = Integer.parseInt(split[0]), Y = Integer.parseInt(split[1]);

                if (X < leftPq.peek() && Y < leftPq.peek()) {
                    leftPq.offer(X);
                    leftPq.offer(Y);

                    rightPq.offer(leftPq.poll());
                }
                else if (X > leftPq.peek() && Y > leftPq.peek()) {
                    rightPq.offer(X);
                    rightPq.offer(Y);

                    leftPq.offer(rightPq.poll());
                }
                else {
                    if (X < Y) {
                        leftPq.offer(X);
                        rightPq.offer(Y);
                    }
                    else {
                        leftPq.offer(Y);
                        rightPq.offer(X);
                    }
                }

                mid = (mid + leftPq.peek()) % div;
            }
            sb.append("#").append(test).append(" ").append(mid).append("\n");
        }
        System.out.println(sb);
    }
}