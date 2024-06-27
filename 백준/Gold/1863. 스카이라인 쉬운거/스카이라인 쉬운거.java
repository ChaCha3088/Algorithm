import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

class Main {
    private static int n;
    private static int answer = 0;
    private static Deque<Integer> stack = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");

            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);

            // stack 비었으면
            if (stack.isEmpty()) {
                // 넣고
                stack.offerLast(y);

                // 다음 라운드로
                continue;
            }

            // 높이가 감소했을 때, 계속 제거
            while (!stack.isEmpty() && stack.peekLast() > y) {
                answer += 1;
                stack.removeLast();
            }

            // 높이가 같으면
            if (!stack.isEmpty() && stack.peekLast() == y) {
                // 다음 라운드로
                continue;
            }

            // 높이가 높아졌을 때
            stack.offerLast(y);
        }

        while (!stack.isEmpty()) {
            if (stack.pollLast() > 0) {
                answer += 1;
            }
        }

        System.out.println(answer);
    }
}