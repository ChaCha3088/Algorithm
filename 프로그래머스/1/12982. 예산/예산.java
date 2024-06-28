import java.util.*;

class Solution {
    private int answer = 0;
    private StringBuffer sb = new StringBuffer();
    
    public int solution(int[] d, int budget) {
        // d를 정렬
        Arrays.sort(d);
        
        for (int i = 0; i < d.length; i++) {
            if (budget >= d[i]) {
                answer += 1;
                budget -= d[i];
            }
            else {
                break;
            }
        }
        
        // 최대 몇 개의 부서에 물품을 지원할 수 있는지
        return answer;
    }
}