import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int test = 1; test <= 10; test++) {
			int answer = 0;
			boolean result = true;
			int N = Integer.parseInt(br.readLine());
			String[] split = br.readLine().split("");
			
			Stack<Character> stack = new Stack<>();
			
			for (int i = 0; i < N; i++) {
				if (split[i].charAt(0) == '(' || split[i].charAt(0) == '[' || split[i].charAt(0) == '{' || split[i].charAt(0) == '<') {
					stack.push(split[i].charAt(0));
				}
				else {
					if (stack.peek() == '(') {
						if (split[i].charAt(0) == ')') {
							stack.pop();
						}
						else {
							result = false;
							break;
						}
					}
					else if (stack.peek() == '[') {
						if (split[i].charAt(0) == ']') {
							stack.pop();
						}
						else {
							result = false;
							break;
						}
					}
					else if (stack.peek() == '{') {
						if (split[i].charAt(0) == '}') {
							stack.pop();
						}
						else {
							result = false;
							break;
						}
					}
					else if (stack.peek() == '<') {
						if (split[i].charAt(0) == '>') {
							stack.pop();
						}
						else {
							result = false;
							break;
						}
					}
					else {
						result = false;
						break;
					}
				}
			}
			
			if (stack.size() > 0) {
				result = false;
			}
			
			if (result) {
				answer = 1;
			}
			
			sb.append("#").append(test).append(" ").append(answer).append("\n");
		}
		
		System.out.println(sb);
	}

}