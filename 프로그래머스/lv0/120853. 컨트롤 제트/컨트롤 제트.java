import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        String[] string = s.split(" ");
        
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < string.length; i++) {
            try {
                stack.push(Integer.parseInt(string[i]));
            } catch (NumberFormatException e) {
                stack.pop();
            }
        }
        
        List<Integer> result = new ArrayList(stack);
        
        for (Integer I : result) {
            answer += I;
        }
        
        return answer;
    }
}