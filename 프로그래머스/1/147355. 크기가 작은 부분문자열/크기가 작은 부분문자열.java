class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        long right = Long.parseLong(p);

        for (int i = 0; i <= t.length() - p.length(); i++) {
            long left = Long.parseLong(t.substring(i, i + p.length()));

            if (left <= right) {
                answer += 1;
            }
        }
        
        return answer;
    }
}