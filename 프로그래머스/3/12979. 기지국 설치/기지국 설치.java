class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int stationIndex = 0;

        int now = 1;
        
        while (now <= n) {
            if (stationIndex >= stations.length || now < stations[stationIndex] - w) {
                answer += 1;
                now = now + w * 2 + 1;
            }
            else {
                now = stations[stationIndex] + w + 1;
                stationIndex += 1;
            }
        }

        return answer;
    }
}