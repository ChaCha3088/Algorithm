import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

class Main {
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int n = 0; n < N; n++) {
            String input = br.readLine();

            if (input.length() % 2 == 1) {
                continue;
            }

            Deque<Character> stack = new LinkedList<>();

            for (int i = 0; i < input.length(); i++) {
                char target = input.charAt(i);

                if (stack.isEmpty()) {
                    stack.offerLast(target);
                }
                else {
                    char peeked = stack.peekLast();

                    if (peeked == target) {
                        stack.pollLast();
                    }
                    else {
                        stack.offerLast(target);
                    }
                }
            }

            if (stack.size() == 0) {
                answer += 1;
                continue;
            }

            while (stack.size() >= 2) {
                char end = stack.pollLast();
                char peeked = stack.peekLast();

                if (end != peeked) {
                    break;
                }
                else {
                    stack.pollLast();
                }
            }
        }

        System.out.println(answer);
    }
}