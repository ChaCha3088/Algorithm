import java.util.*;

class Solution {
    public int solution(String my_string) {
        int answer = 0;
        
        String[] string = my_string.split("");
        
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < string.length; i++) {
            try {
                result.add(Integer.parseInt(string[i]));
            } catch (NumberFormatException e) {
                continue;
            }
        }
        
        for (Integer I : result) {
            answer += I;
        }
        
        return answer;
    }
}