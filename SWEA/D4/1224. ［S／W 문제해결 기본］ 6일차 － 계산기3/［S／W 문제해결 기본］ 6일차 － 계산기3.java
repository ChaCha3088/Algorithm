import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Stack;

class Solution
{
        private static Stack <Character> stack = new Stack();
    
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            int length = sc.nextInt();
            String input = sc.next();
            
            System.out.println("#" + (i + 1) + " " + calculate(convert(input)));
        }
	}
    
    private static String convert(String input) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char now = input.charAt(i);

            switch (now){
                case '+':
                case '-':
                case '*':
                case '/':
                    while (!stack.isEmpty() && priority(stack.peek()) >= priority(now)) {
                        sb.append(stack.pop());
                    }
                    stack.add(now);
                    break;
                case '(':
                    stack.add(now);
                    break;
                case ')':
                    while(!stack.isEmpty() && stack.peek() != '('){
                        sb.append(stack.pop());
                    }
                    stack.pop();
                    break;
                default:
                    sb.append(now);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    private static int calculate(String input) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char now = input.charAt(i);

            if (now == '+' || now == '-' || now == '*' || now == '/') {
                int b = stack.pop();
                int a = stack.pop();

                switch (now) {
                    case '+':
                        stack.push(a + b);
                        break;
                    case '-':
                        stack.push(a - b);
                        break;
                    case '*':
                        stack.push(a * b);
                        break;
                    case '/':
                        stack.push(a / b);
                        break;
                }
            } else {
                stack.push(now - '0');
            }
        }

        return stack.pop();
    }

    private static int priority(char operator){

        if(operator=='(' || operator==')'){
            return 0;
        } else if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/') {
            return 2;
        }
        return -1;
    }
}