import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        //결과 ArrayList
        List<Integer> result = new ArrayList<>();
        
        //개발 기간
        int date = 1;
        
        //큐에 progresses, speeds 넣기
        List<Integer> queue = new ArrayList<>();
        List<Integer> speed = new ArrayList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            queue.add(progresses[i]);
            speed.add(speeds[i]);
        }
        
        //큐에 요소가 존재하면
        while (queue.size() > 0) {
            System.out.println("before queue");
            System.out.println(queue);
            System.out.println("before speed");
            System.out.println(speed);
            
            //진도가 100 이상인 요소가 기록된 트리거
            boolean trigger = false;
            
            //모든 요소를 순회하면서
            for (int i = 0; i < queue.size(); i++) {
                
                //진도가 100 미만이면
                if (queue.get(i) < 100) {
                    
                    //하루 진도를 더한다.
                    queue.set(i, queue.get(i) + speed.get(i));
                }
            }
            
            //첫번째 요소의 진도가 100 이상이 되면
            if (queue.get(0) >= 100) {
                //트리거를 true로 바꾼다.
                trigger = true;
            }
            
            //하루가 끝나고
        
            //트리거가 true이면
            if (trigger) {
                
                //배포량
                int deploy = 0;
                
                //남은 요소가 존재하고, 첫번째 요소가 100 이상이면
                while (queue.size() > 0) {

                    if (queue.get(0) >= 100) {
                        //요소를 꺼내고
                        queue.remove(0);
                        speed.remove(0);

                        //배포 수를 기록한다.
                        deploy += 1;
                    } else {
                        break;
                    }
                }
                
                //배포량을 기록
                if (deploy > 0) {
                    result.add(deploy);
                }
            }
            
            //몇 일이 지났는지 기록한다.
            date += 1;
            
            System.out.println("after queue");
            System.out.println(queue);
            System.out.println("after speed");
            System.out.println(speed);
            System.out.println("===================");
        }
        
        System.out.println("result is");
        System.out.println(result);
        
        int[] answer = new int[result.size()];
        
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}