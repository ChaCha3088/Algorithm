import java.util.*;

class Solution {
    private static Set<Integer> set = new HashSet<>();
    public int solution(int[] elements) {
        // 수열의 길이
        for (int count = 1; count <= elements.length; count++) {            
            // 시작점
            for (int i = 0; i < elements.length; i++) {
                int answer = 0;

                // 끝점
                for (int j = i; j < i + count; j++) {
                    answer += elements[j % elements.length];
                }
                
                set.add(answer);
            }
        }
        
        return set.size();
    }
}