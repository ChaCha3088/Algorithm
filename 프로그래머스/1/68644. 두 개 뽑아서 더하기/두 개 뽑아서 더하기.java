import java.util.*;
import java.util.stream.Collectors;

class Solution {
    private Set<Integer> set = new HashSet<>();
    
    public int[] solution(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        
        List<Integer> list = set.stream()
            .sorted(Comparator.comparingInt(o -> o))
            .collect(Collectors.toList());
        
        int[] answer = new int[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    private void combination(int[] numbers) {
        int N = numbers.length;
        int howMany = 2;
        
        for (int i = 0; i < (1 << N); i++) {
            int count = 0;
            
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) > 0) {
                    count += 1;
                }
            }
            
            if (count == howMany) {
                int result = 0;

                for (int j = 0; j < N; j++) {
                    if ((i & (1 << j)) > 0) {
                        result += numbers[j];
                    }
                }
                
                set.add(result);
            }
        }
    }
}