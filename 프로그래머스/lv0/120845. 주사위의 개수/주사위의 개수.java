class Solution {
    public int solution(int[] box, int n) {
        int answer = 0;
        
        int ga = box[0] / n;
        
        int se = box[1] / n;
        
        int nop = box[2] / n;
        
        int cubeSum = ga * se * nop;
        
        answer = cubeSum;
        
        return answer;
    }
}