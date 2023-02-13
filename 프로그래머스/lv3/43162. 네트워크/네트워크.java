class Solution {
    int[][] data;
    boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        data = computers;
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                find(i);
                answer++;
            }
        }
        
        return answer;
    }
    
    private void find(int i) {
        visited[i] = true;
        
        for (int j = 0; j < data[i].length; j++) {
            if (i != j & data[i][j] == 1 & !visited[j]) {
                find(j);
            }
        }
    }
}