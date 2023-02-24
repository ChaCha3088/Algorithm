import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        
        List<Integer> sortedList = Arrays.stream(sides)
            .boxed()
            .sorted()
            .collect(Collectors.toList());
        
        if (sortedList.get(2) < sortedList.get(1) + sortedList.get(0)) {
            return 1;
        }
        
        return 2;
    }
}