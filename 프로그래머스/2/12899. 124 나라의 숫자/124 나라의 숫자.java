class Solution {
    private static StringBuffer sb = new StringBuffer();
    private static String[] arr = {"1", "2", "4"};
    
    public String solution(int n) {
        n -= 1;
        r(n);

        return sb.reverse().toString();
    }
                             
    public void r(int n) {
        sb.append(arr[n % 3]);
        
        if (n / 3 == 0)
            return;
        
        r(n / 3 - 1);
    }
}