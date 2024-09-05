import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

class Main {
    private static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        while (!input.isBlank()) {
            if (input.equals(".")) {
                break;
            }

            Deque<Character> stack = new LinkedList<>();

            boolean isFail = false;

            for (int i = 0; i < input.length(); i++) {
                char target = input.charAt(i);

                if (target == '(' || target == ')') {
                    if (target == '(') {
                        stack.offerLast(target);
                    }
                    else {
                        if (!stack.isEmpty()) {
                            char peeked = stack.peekLast();

                            if (peeked == '(') {
                                stack.pollLast();
                            }
                            else {
                                stack.offerLast(target);
                            }
                        }
                        else {
                            isFail = true;
                            break;
                        }
                    }
                }
                else if (target == '[' || target == ']') {
                    if (target == '[') {
                        stack.offerLast(target);
                    }
                    else {
                        if (!stack.isEmpty()) {
                            char peeked = stack.peekLast();

                            if (peeked == '[') {
                                stack.pollLast();
                            }
                            else {
                                stack.offerLast(target);
                            }
                        }
                        else {
                            isFail = true;
                            break;
                        }
                    }
                }
            }

            if (isFail || stack.size() > 0) {
                sb.append("no").append("\n");
            }
            else if (stack.size() == 0) {
                sb.append("yes").append("\n");
            }

            input = br.readLine();
        }

        System.out.println(sb);
    }
}