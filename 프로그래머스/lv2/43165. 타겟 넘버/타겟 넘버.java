class Solution {
    int[] numbers;
    int target;
    int count;
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        this.numbers = numbers;
        this.target = target;
        this.count = 0;
        
        dfs(0, 0);
        
        answer = count;
        
        return answer;
    }
    
    private void dfs(int index, int sum) {
        if (index == numbers.length) {
            if (target == sum) {
                count += 1;
            }
            return;
        }
        
        dfs(index + 1, sum + numbers[index]);
        dfs(index + 1, sum - numbers[index]);
    }
}