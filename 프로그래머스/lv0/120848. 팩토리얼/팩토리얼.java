class Solution {
    public int solution(int n) {
        int answer = 1;
        int cal = 1;
        
        if (n == 1) {
            return 1;
        }
        
        for (int i = 2; i <= n; i++) {
            cal *= i;
            if (cal <= n) {
                answer = i;
            } else {
                break;
            }
        }
        
        return answer;
    }
    
    private int factorial(int input) {
        int result = 1;
        
        for (int i = 1; i <= input; i++) {
            result *= i;
        }
        
        return result;
    }
}