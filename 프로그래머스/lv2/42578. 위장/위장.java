import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        
        Map<String, List<String>> hm = new HashMap<>();
        
        for (int i = 0; i < clothes.length; i++) {
                
            if (hm.containsKey(clothes[i][1]) == false) {
                hm.put(clothes[i][1], new ArrayList<>());
                hm.get(clothes[i][1]).add(clothes[i][0]);
            } else {
                hm.get(clothes[i][1]).add(clothes[i][0]);
            }
            
        }
        
        
        
        List<Integer> counts = new ArrayList<>();
                
        hm.forEach((key, value) -> {
            counts.add(value.size() + 1);
        });
        
        int multi = 1;
        
        for (int i = 0; i < counts.size(); i++) {
            multi = multi * counts.get(i);
        }
        
        answer = multi - 1;
        
        return answer;
    }
}