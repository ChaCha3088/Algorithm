class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        // 최대공약수 계산
        int gcdA = getGCD(arrayA);
        int gcdB = getGCD(arrayB);
        
        // 안나누어지는지 확인
        boolean isGCDAPossible = notDividedBy(gcdA, arrayB);
        boolean isGCDBPossible = notDividedBy(gcdB, arrayA);
        
        if (isGCDAPossible && isGCDBPossible) {
            answer = Math.max(gcdA, gcdB);
        }
        else if (isGCDAPossible) {
            answer = gcdA;
        }
        else if (isGCDBPossible) {
            answer = gcdB;
        }
        
        return answer;
    }
    
    private boolean notDividedBy(int gcd, int[] arr) {        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % gcd == 0) {
                return false;
            }
        }
        
        return true;
    }
    
    private int getGCD(int[] arr) {
        int result = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            result = gcd(result, arr[i]);
        }
        
        return result;
    }
    
    private int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        
        return gcd(b % a, a);
    }
}