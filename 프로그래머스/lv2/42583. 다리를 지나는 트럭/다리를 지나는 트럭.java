//모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지

//완전히 오르지 않은 트럭의 무게는 무시

import java.util.*;

class Solution {
    int time = 0;
    int sumTruckWeights = 0;
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        //queue로 만들기
        //truck_weights
        Queue<Integer> trucks = new LinkedList<>();
        for (int i = 0; i < truck_weights.length; i++) {
            trucks.offer(truck_weights[i]);
        }
        //crossingTrucks
        Queue<Integer> crossingTrucks = new LinkedList<>();
        for (int i = 0; i < bridge_length; i++) {
            crossingTrucks.offer(0);
        }
        
        //crossingTrucks가 빌 때까지 반복
        while (crossingTrucks.size() > 0) {
            sumTruckWeights -= crossingTrucks.poll();
                        
            //최대 bridge_length대 & weight 이하까지의 무게를 만족하는 한
            if (((sumTruckWeights + (trucks.peek())) <= weight)) {
                //트럭 추가
                int truck = trucks.poll();
                crossingTrucks.offer(truck);
                sumTruckWeights += truck;
                
                if (trucks.size() == 0) {
                    time += bridge_length + 1;
                    break;
                }
            } else {
                //트럭 추가
                crossingTrucks.offer(0);
            }
            
            //시간 경과
            time += 1;
            
            if (crossingTrucks.size() == 0) {
                    break;
            }
        }
        
        answer = time;
        
        return answer;
    }
}