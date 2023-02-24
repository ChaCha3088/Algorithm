import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int n) {
        int target = n;
        
        Set<Integer> set = new HashSet<>();
        
        for (int i = 2; i <= target; i++) {
            if (target == 1) {
                break;
            }
            while (target % i == 0) {
                System.out.println(target);
                target /= i;
                set.add(i);
                System.out.println(i);
                System.out.println(target);
            }
        }
        
        List<Integer> list = new ArrayList<>(set);
        
        int[] answer = new int[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}
