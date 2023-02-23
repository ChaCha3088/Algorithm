import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        
        List<Integer> numberList = 
            Arrays.stream(numbers)
            .boxed()
            .sorted(Collections.reverseOrder())
            .collect(Collectors.toList());
        
        System.out.println(numberList);
            
        answer = numberList.get(0) * numberList.get(1);
        
        
        return answer;
    }
}