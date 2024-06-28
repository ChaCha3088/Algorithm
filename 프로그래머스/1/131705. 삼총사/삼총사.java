class Solution {
    private int answer = 0;
    
    public int solution(int[] number) {
        for (int i = 0; i < number.length; i++) {
            dfs(number[i], i, 1, number);
        }
        
        return answer;
    }
    
    private void dfs(int sum, int idx, int currentDepth, int[] arr) {        
        if (currentDepth >= 3) {
            if (sum == 0) {
                answer += 1;
            }
            
            return;
        }
        
        if (idx >= arr.length) {
            return;
        }
        
        for (int i = idx + 1; i < arr.length; i++) {
            if (currentDepth < 3) {
                dfs(sum + arr[i], i, currentDepth + 1, arr);
            }
        }
    }
}