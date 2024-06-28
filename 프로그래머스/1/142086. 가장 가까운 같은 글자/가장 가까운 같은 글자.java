class Solution {
    private int[] arr;
    private int[] alphabet;
    
    public int[] solution(String s) {
        arr = new int[s.length()];
        alphabet = new int[26];
        
        for (int i = 0; i < 26; i++) {
            alphabet[i] = -1;
        }
        
        for (int i = 0; i < s.length(); i++) {
            char target = s.charAt(i);
            
            // 나온적이 있다면
            if (alphabet[target - 'a'] > -1) {
                // 몇 칸 앞인지 기록
                arr[i] = i - alphabet[target - 'a'];
            }
            // 나온적이 없다면
            else {
                arr[i] = -1;
            }
            
            // 최신 index를 기록
            alphabet[target - 'a'] = i;
        }
        
        return arr;
    }
}