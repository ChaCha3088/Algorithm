import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int length = nums.length;

        for (int i = 0; i < length -2; i++) {
            for (int j = i + 1; j < length - 1; j++) {
                for (int k = j + 1; k < length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    System.out.println(sum);
                    int prime = isPrime(sum);
                    System.out.println(prime);
                    answer += prime;
                }
            }
        }
        
        

        return answer;
    }
    
    private int isPrime(int input) {
        for (int i = 2; i <= Math.sqrt(input); i++) {
            if (input % i == 0) {
                return 0;
            }
        }
        return 1;
    }
}