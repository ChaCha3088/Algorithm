import java.util.*;

class Solution {
    private Map<Integer, List<Integer>> table = new HashMap<>();
    
    public int solution(int N, int number) {
        int answer = 0;
        
        for (int i = 1; i <= 8; i++) {
            List<Integer> list = conduct(N, i);
            
            //list에서 최소인 number를 찾자
            if (list.contains(number)) {
                return i;
            }            
            
            table.put(i, list);
        }
        
        //없으면
        return -1;
    }
    
    private List<Integer> conduct(int N, int i) {
        List<Integer> result = new ArrayList<>();
        
        //N을 i개 붙인 수
        String nnn = "";
        for (int j = 0; j < i; j++) {
            nnn += String.valueOf(N);
        }
        result.add(Integer.parseInt(nnn));
        
        //Si * Sj
        if (i >= 2) {
            //i = {2 + 1, 1 + 2}
            Map<Integer, Integer> comb = new HashMap<>();
            for (int j = 1; j < i; j++) {
                comb.put(j, i - j);
            }
            
            //
            List<Integer> keys = new ArrayList<>(comb.keySet());
            
            for (int key : keys) {
                List<Integer> Si = table.get(key);
                List<Integer> Sj = table.get(comb.get(key));
                calculate(result, Si, Sj);
            }
        }
        
        return result;
    }
    
    private void calculate(List<Integer> result, List<Integer> Si, List<Integer> Sj) {
        for (int i = 0; i < Si.size(); i++) {
            for (int j = 0; j < Sj.size(); j++) {
                try {
                    result.add(Si.get(i) + Sj.get(j));
                    result.add(Si.get(i) - Sj.get(j));
                    result.add(Si.get(i) * Sj.get(j));
                    result.add(Si.get(i) / Sj.get(j));
                } catch (ArithmeticException e) {
                    
                }
            }
        }
    }
}