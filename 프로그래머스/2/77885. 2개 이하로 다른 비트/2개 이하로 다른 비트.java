import java.util.*;

class Solution {
    private List<Long> answers = new LinkedList<>();
    
    public long[] solution(long[] numbers) {
        for (int index = 0; index < numbers.length; index++) {
            for(long i = 1; ; i <<= 1) {
                if ((numbers[index] & i) == 0) { // (1)
                    numbers[index] |= i; // (2)
                    numbers[index] ^= (i >> 1); // (3)
                    answers.add(numbers[index]);
                    break;
                }
            }
        }
        
        long[] answer = new long[answers.size()];
        
        for (int i = 0; i < answers.size(); i++) {
            answer[i] = answers.get(i);
        }
        
        return answer;
    }
}