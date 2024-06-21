import java.util.*;

class Solution {
    private int length = Integer.MAX_VALUE;
    private int sum;
    private Map<Integer, int[]> map = new HashMap<>();
    
    public int[] solution(int[] sequence, int k) {
        int left = 0;
        int right = 0;
        
        int sum = sequence[left];
        
        while (left < sequence.length && right < sequence.length) {
            if (k < sum) {
                // 합을 줄여야 한다.
                
                // sum에서 맨 왼쪽을 빼고
                sum -= sequence[left];
                
                // 붙어있으면 같이 옮긴다.
                if (left == right) {
                    right += 1;
                }
                
                // left를 옮긴다.
                left += 1;
            }
            else if (sum == k) {
                // 수열의 길이를 잰다.
                int newLength = right - left + 1;
                
                int[] data = map.getOrDefault(newLength, new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE});
                
                if (left < data[0]) {
                    // map에 기록한다.
                    map.put(newLength, new int[] {left, right});
                    
                    // 가장 짧은 수열의 길이를 기록한다.
                    length = Math.min(newLength, length);
                }
                
                // 오른쪽을 옮긴다.
                right += 1;
                
                if (left >= sequence.length || right >= sequence.length) {
                    break;
                }   
                
                // sum에서 다음을 더한다.
                sum += sequence[right];
            }
            else {
                // 합을 늘려야 한다.
                
                // right를 옮긴다.
                right += 1;
                
                if (left >= sequence.length || right >= sequence.length) {
                    break;
                }   
                
                // sum에서 다음을 더한다.
                sum += sequence[right];
            }
        }
        
        // 가장 짧은 수열을 찾는다.
        return map.get(length);
    }
}