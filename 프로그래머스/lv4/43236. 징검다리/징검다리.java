import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        
        Arrays.sort(rocks);
        
        int[] distances = new int[rocks.length];
        distances[0] = rocks[0];
        distances[distances.length - 1] = distance - rocks[rocks.length - 1];
        
        for (int i = 1; i < rocks.length; i++) {
            distances[i] = rocks[i] - rocks[i - 1];
        }
        
        int left = 0;
        int right = distance;
        
        while (left < right) {
            int mid = (left + right) / 2;
            
            int removedStone = 0;
            int current = 0;
            
            for (int i = 0; i < distances.length; i++) {
                current += distances[i];
                
                if (current < mid) {
                    removedStone++;
                } else {
                    current = 0;
                }
            }
            
            if (removedStone < n) {
                left = mid + 1;
            } else if (removedStone > n) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left - 1;
    }
}