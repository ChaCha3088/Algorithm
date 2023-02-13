import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Set<String> participantHashSet = new HashSet<>(Arrays.asList(participant));
        Set<String> completionHashSet = new HashSet<>(Arrays.asList(completion));
        
        participantHashSet.removeAll(completionHashSet);
        
        if (participantHashSet.size() == 0) {
            HashMap<String, Integer> map = new HashMap<>();
            for (String player : participant) 
                map.put(player, map.getOrDefault(player, 0) + 1);
            for (String player : completion) 
                map.put(player, map.get(player) - 1);

                Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator();

            while(iter.hasNext()){
                Map.Entry<String, Integer> entry = iter.next();
                if (entry.getValue() != 0){
                    answer = entry.getKey();
                    break;
                }
            }
        } else {
            List<String> list = new ArrayList<>(participantHashSet);
        
            answer = list.get(0);
        }
        
        return answer;
    }
}