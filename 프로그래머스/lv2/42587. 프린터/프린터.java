//중요도가 높은 문서를 먼저 인쇄

//1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
//2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
//3. 그렇지 않으면 J를 인쇄합니다.

//내가 요청한 문서가 몇 번째로 인쇄되는지 알고 싶습니다.

//내가 인쇄를 요청한 문서가 몇 번째로 인쇄

import java.util.*;

class Solution {
    int targetLocation;
    int printCount = 0;
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int target = priorities[location];
        targetLocation = location;
        
        //queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(priorities[i]);
        }
        
        //priorityqueue
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> a <= b ? 1 : -1);
        for (int i = 0; i < priorities.length; i++) {
            pq.offer(priorities[i]);
        }
        
        while (true) {
            //그냥 인쇄
            if (queue.peek() == pq.peek()) {
                queue.poll();
                pq.poll();
                printCount += 1;
                
                if (targetLocation == 0) {
                    break;
                } else {
                    targetLocation -= 1;
                }
            } else {
                //peek해서 다르면 대기 목록 가장 뒤로 보내
                int polled = queue.poll();
                queue.offer(polled);
                
                if (targetLocation == 0) {
                    targetLocation = queue.size() - 1;
                } else {
                    targetLocation -= 1;
                }
            }
        }
        
        answer = printCount;
        
        return answer;
    }
}