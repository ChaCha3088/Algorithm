import java.util.Collections;
import java.util.Arrays;

class Solution {    
    private StringBuffer sb = new StringBuffer();
    
    public String solution(int[] numbers) {
        String[] strings = new String[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            strings[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(strings, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        if (strings[0].equals("0")) {
           return "0";
        }
        
        for (int i = 0; i < numbers.length; i++) {
            sb.append(strings[i]);
        }
        
        
        return sb.toString();
    }
}