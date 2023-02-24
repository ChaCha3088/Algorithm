import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String my_string) {
        int numbersIndex = 0;
        
        String[] splitted = my_string.split("");
        
        List<Integer> numbers = new ArrayList<>();
        
        for (int i = 0; i < splitted.length; i++) {
            try {
                numbers.add(Integer.parseInt(splitted[i]));
            } catch (NumberFormatException e) {
                continue;
            }
        }
        
        System.out.println(numbers);
        
        List<Integer> result = numbers.stream()
            .sorted()
            .collect(Collectors.toList());
        
        System.out.println(result);
        
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}