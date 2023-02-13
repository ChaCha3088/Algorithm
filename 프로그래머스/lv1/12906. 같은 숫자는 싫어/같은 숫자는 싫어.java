import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        List<Integer> answerList = new ArrayList<>();
        
        int target = arr[0];
        answerList.add(target);
        
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            if (target != current) {
                answerList.add(current);
            }
            target = current;
        }
        
        int[] answer = new int[answerList.size()];
        
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}