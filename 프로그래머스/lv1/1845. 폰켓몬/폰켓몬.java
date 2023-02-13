import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        int available = nums.length / 2;
        
        Set<Integer> hs = new HashSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            hs.add(nums[i]);
        }
        
        int size = hs.size();
        if (size > available) {
            return available;
        } else {
            return size;
        }
    }
}