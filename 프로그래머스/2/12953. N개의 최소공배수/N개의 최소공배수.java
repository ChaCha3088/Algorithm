class Solution {
    public int solution(int[] arr) {
        int start = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            start = lcm(start, arr[i]);
        }
        
        return start;
    }
    
    private static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        
        return a;
    }
    
    private static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
}