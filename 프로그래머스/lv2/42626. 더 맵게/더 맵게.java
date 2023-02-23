import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        int count = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((Integer a, Integer b) -> a > b ? 1 : -1);
        
        for (int i = 0; i < scoville.length; i++) {
            pq.offer(scoville[i]);
        }
            
        //최소값이 K 이상 될 때까지 반복
        while (pq.peek() < K) {
            if (pq.size() < 2) {
                return -1;
            }
            pq.offer(pq.poll() + pq.poll() * 2);
            count += 1;
        }
        
        answer = count;
        
        return answer;
    }
}