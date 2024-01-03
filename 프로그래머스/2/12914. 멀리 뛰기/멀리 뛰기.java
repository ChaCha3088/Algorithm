class Solution {
    private static long[] arr;
    public long solution(int n) {
        arr = new long[2001];
        
        arr[1] = 1;
        arr[2] = 2;
        
        return getAnswer(n);
    }
    
    private static long getAnswer(int input) {
        if (arr[input] != 0) {
            return arr[input];
        }
        
        return arr[input] = (getAnswer(input - 1) % 1234567 + getAnswer(input - 2) % 1234567) % 1234567;
    }
}