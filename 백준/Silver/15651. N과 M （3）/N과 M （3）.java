import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static List<Integer> list = new ArrayList<>();
    private static Deque<Integer> stack = new LinkedList<>();
    private static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int n = 1; n <= N; n++) {
            list.add(n);
        }

        pick(0, M);

        System.out.println(sb);
    }

    private static void pick(int depth, int targetDepth) {
        if (depth >= targetDepth) {
            // 출력
            stack.forEach((e) -> sb.append(e).append(" "));
            sb.append("\n");

            return;
        }

        for (int i = 0; i < list.size(); i++) {
            stack.offerLast(list.get(i));
            pick(depth + 1, targetDepth);
            stack.pollLast();
        }
    }
}