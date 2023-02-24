import java.util.*;

class Solution {
    public String solution(String my_string) {
        String answer = "";
        
        String[] string = my_string.split("");
        
        Set<String> set = new LinkedHashSet<>();
        
        for (String str : string) {
            set.add(str);
        }
        
        List<String> list = new ArrayList(set);
        
        for (String str : list) {
            answer += str;
        }
    
        return answer;
    }
}