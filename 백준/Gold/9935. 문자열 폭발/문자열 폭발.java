import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    private static String input, target;
    private static Stack<Character> stack = new Stack<>();
    private static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        input = br.readLine();
        target = br.readLine();

        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));

            if (stack.size() >= target.length()) {
                int count = 0;

                int start = stack.size() - 1;

                int targetIndex = target.length() - 1;

                for (; targetIndex >= 0; targetIndex--) {
                    if (stack.get(start).equals(target.charAt(targetIndex))) {
                        count += 1;
                    }

                    start -= 1;
                }

                // 일치하는 것을 찾으면
                if (count == target.length()) {
                    for (int j = 0; j < target.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        String result = sb.reverse().toString();

        System.out.println(result.isEmpty() ? "FRULA" : result);
    }
}