import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Queue<Long> queue = new PriorityQueue<>((o1, o2) -> {
            if (Math.abs(o1) >= Math.abs(o2)) {
                if (Math.abs(o1) == Math.abs(o2)) {
                    return o1 > o2 ? 1 : -1;
                }
                return 1;
            }
            return -1;
        });

        for (int n = 1; n <= N; n++) {
            Long x = Long.parseLong(br.readLine());

            if (x != 0) {
                queue.offer(x);
            }
            else if (x == 0) {
                sb.append(queue.isEmpty() ? 0 : queue.poll()).append("\n");
            }
        }

        System.out.println(sb);
    }
}