class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for (int i = 1; i <= n; i++) {
            if (findYaksu(i)) {
                System.out.println(i);
                answer += 1;
            }
        }
        
        return answer;
    }
    
    private boolean findYaksu(int input) {
        int count = 0;
        
        for (int i = 1; i <= input; i++) {
            if (count >= 3) {
                return true;
            }
            if (input % i == 0) {
                count += 1;
            }
        }
        
        if (count >= 3) {
                return true;
            }
        
        return false;
    }
}