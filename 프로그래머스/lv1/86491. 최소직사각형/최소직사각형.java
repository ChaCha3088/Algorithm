import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
       List<List<Integer>> list = sort(sizes);
        
        List<Integer> w = new ArrayList<>();
        List<Integer> h = new ArrayList<>();
        
        for (int i = 0; i < list.size(); i++) {
            w.add(list.get(i).get(0));
            h.add(list.get(i).get(1));
        }
        
        Collections.sort(w, Collections.reverseOrder());
        Collections.sort(h, Collections.reverseOrder());
        
        System.out.println("w");
        System.out.println(w);
        System.out.println("h");
        System.out.println(h);
        
        //최대값 X 최대값
        
        answer = w.get(0) * h.get(0);    
        
        return answer;
    }
    
    private List<List<Integer>> sort(int[][] input) {
        List<List<Integer>> outside = new ArrayList<>();
        
        for (int i = 0; i < input.length; i++) {
            List<Integer> inside = new ArrayList<>();   
            
            if (input[i][0] >= input[i][1]) {
                inside.add(input[i][0]);
                inside.add(input[i][1]);
                outside.add(inside);
            } else {
                inside.add(input[i][1]);
                inside.add(input[i][0]);
                outside.add(inside);
            }
        }
        
        return outside;
    }
}